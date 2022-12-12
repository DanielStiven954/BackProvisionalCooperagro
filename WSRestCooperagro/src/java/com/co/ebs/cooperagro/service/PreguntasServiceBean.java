package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.ParametroDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.PreguntaDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.PreguntaUsuarioDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.UsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.Pregunta;
import com.co.ebs.cooperagro.domain.PreguntaUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.request.RequestListPregRta;
import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePreguntaActNoUtilizadas;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author andysierra
 * email: andres.sierra@ebssas.com
 */
public class PreguntasServiceBean implements PreguntasService
{
    public PreguntasServiceBean() {}    
    
    /**
     * Obtengo preguntas ACTIVAS que no han sido utilizadas por el
     * usuario, es decir, que no se encuentran relacionadas con la
     * tabla usuario_pregunta. Se devuelven n+1 preguntas de forma
     * aleatoria, donde n = CANT_PREG_SEG_REG_USU
     * 
     * @param xsTipoIdent
     * @param xsIdent
     * @return ResponsePreguntaActNoUtilizadas resultado
     */
    @Override
    public ResponsePreguntaActNoUtilizadas preguntasActivasNoUtilizadas(String xsTipoIdent, String xsIdent, boolean obtenerTodas) {
        
        ResponsePreguntaActNoUtilizadas resultado = new ResponsePreguntaActNoUtilizadas();
        
        // obtenemos el código del usuario
        ParametroDataAccessImp params = new ParametroDataAccessImp();
        Usuario usuario = (new UsuarioDataAccessImp()).findUserByPersonaIdent(1, xsIdent, 1);
        long codigoUsuario = usuario.getICodigo();
        
        // obtenemos las preguntas
        PreguntaDataAccessImp preguntaDao = new PreguntaDataAccessImp();
        List<Pregunta> preguntasActNoUsadas = preguntaDao.findPreguntaByNotUsuario(codigoUsuario);
        
        // armamos el response
        if(!preguntasActNoUsadas.isEmpty()) {
            resultado.setiCodigo(1);
            resultado.setbRta(true);
            resultado.setsMsjRta("Informacion obtenida satisfactoriamente");
            
            if(obtenerTodas)
                resultado.setPreguntasActNoUtilizadas(preguntasActNoUsadas);
            else {
                int i = Integer.parseInt(params.getValorParametroByNombre("CANT_PREG_SEG_REG_USU"))+1;
                
                int[] seleccionados = new int[i];
                for (int j = 0; j < seleccionados.length; j++) {
                    int rnd = (int) Math.floor(Math.random()*preguntasActNoUsadas.size());
                    boolean insertar = true;
                    for (int k = 0; k < seleccionados.length; k++) {
                        if(seleccionados[k] == rnd) {
                            insertar = false;
                            break;
                        }
                    }
                    if(insertar)
                        seleccionados[j] = rnd;
                    else j--;
                }
                
                List<Pregunta> preguntasNoUsadasRand = new ArrayList();
                for (int j = 0; j < seleccionados.length; j++) 
                    preguntasNoUsadasRand.add(preguntasActNoUsadas.get(seleccionados[j]));
                
                resultado.setPreguntasActNoUtilizadas(preguntasNoUsadasRand);
            }
        }
        else {
            resultado.setiCodigo(0);
            resultado.setbRta(false);
            resultado.setsMsjRta("No se pudieron obtener las preguntas, seguramente se trata de un error");
        }
        return resultado;
    }

    
    
    
    
    /**
     * Ya teniendo las preguntas y las respuestas, 
     * (ver modelo/clasesAsociado/cuentaAsoc :: RequestRtaCuestionario)
     * envío por update al back para actualizar las preguntas
     * 
     * @param request
     * @return respuestaGenerica resultado
     */
    @Override
    public respuestaGenerica actualizarPreguntasSeguridad(RequestRtaCuestionario request) {
        respuestaGenerica resultado = new respuestaGenerica();
        
        PreguntaUsuarioDataAccessImp puDao  = new PreguntaUsuarioDataAccessImp();
        PreguntaDataAccessImp pDao          = new PreguntaDataAccessImp();
        ParametroDataAccessImp parDao       = new ParametroDataAccessImp();
        int preguntas_usu_inactivadas       = 0;
        int preguntas_usu_nuevas            = 0;
        
        try {
            // obtenemos el código del usuario
            Usuario usuario = (new UsuarioDataAccessImp()).findUserByPersonaIdent(1, request.getsCIdentificacion(), 1);
            long codigoUsuario = usuario.getICodigo();

            // obtenemos las preguntas_usuario que queremos inactivar
            List<PreguntaUsuario> preguntasUsu = puDao.obtenerPreguntasByUsuario(String.valueOf(codigoUsuario), true);

            // inactivamos las preguntas que ya tiene el usuario
            for(PreguntaUsuario p : preguntasUsu) {
                p.setCEstado("INA");
                puDao.update(p);
                preguntas_usu_inactivadas++;
            }

            // obtenemos la fecha actual y la fecha fin
            LocalDateTime inicio    = LocalDateTime.now();
            LocalDateTime fin       = inicio.plusDays(Long.parseLong(
                    parDao.getValorParametroByNombre("VALIDEZ_PREGUNTAS_SEGURIDAD")
            ));

            // creamos los dto de las nuevas preguntas que vamos a insertar e insertamos en la tabla
            // pregunta_usuario
            List<PreguntaUsuario> nuevasPreguntasUsuario = new ArrayList<>();
            for(RequestListPregRta pregunta_respuesta : request.getRequestListPregRta()) {

                PreguntaUsuario nuevoDto = new PreguntaUsuario();

                // obtener el numero de la pregunta utilizada
                Pregunta pregunta 
                        = pDao.findPreguntaByDescripcion(pregunta_respuesta.getsValueCampo()).get(0);

                nuevoDto.setIPregunta(pregunta);
                nuevoDto.setIUsuario(usuario);
                nuevoDto.setIOrden(BigInteger.ONE);
                nuevoDto.setCRespuesta(pregunta_respuesta.getsValueRta());

                Date fecha = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant());
                nuevoDto.setFInicio(fecha);
                fecha = Date.from(fin.atZone(ZoneId.systemDefault()).toInstant());
                nuevoDto.setFFin(fecha);

                nuevoDto.setCEstado("ACT");
                nuevoDto.setCLlaveSeguridad("1");

                puDao.create(nuevoDto);
                preguntas_usu_nuevas++;
            }
            
            resultado.setbRta(Boolean.TRUE);
            resultado.setiCodigo(0);
            resultado.setsMsj("Exito actualizando preguntas de seguridad: "+preguntas_usu_inactivadas+" inactivadas, "+preguntas_usu_nuevas+" nuevas");
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            resultado.setbRta(Boolean.FALSE);
            resultado.setiCodigo(1);
            resultado.setsMsj(ex.getMessage());
        }
        
        return resultado;
    }
}
