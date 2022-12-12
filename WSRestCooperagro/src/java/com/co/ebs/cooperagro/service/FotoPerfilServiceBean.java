package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.FotoPerfilDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.UsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.FotoPerfil;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.request.RequestFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseServirFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;


/**
 * @author andysierra
 * email: andres.sierra@ebssas.com
 */
public class FotoPerfilServiceBean implements FotoPerfilService
{
    public FotoPerfilServiceBean() {}
    
    
    

    /**
     * Controller que Actualiza la foto de perfil
     * 
     * @param request 
     * @return respuestaGenerica
     */
    @Override
    public respuestaGenerica actualizarFotoPerfil(RequestFotoPerfil request) {
        
        respuestaGenerica       resultado   = new respuestaGenerica();
        FotoPerfil              dto         = new FotoPerfil();
        FotoPerfilDataAccessImp dao         = new FotoPerfilDataAccessImp();
        UsuarioDataAccessImp    usuarioDao  = new UsuarioDataAccessImp();
        Usuario                 usuarioDto  = null;
        
        // Obtenemos el usuario a partir de la cdentificacion;
        usuarioDto = usuarioDao.findUserByPersonaIdent(
                request.iTipoIdent, 
                request.cIdentificacion,
                1
        );
        
        // Si hay usuario, entonces armamos el dto para subir/actualizar
        if(usuarioDto != null) {
            dto.setCNombre  (request.cNombre);
            dto.setCTipo    (request.cTipo);
            dto.setITamanio (request.iTamanio);
            dto.setFSubida  (request.fFechaSubida);
            dto.setBImgclob(request.bImgBytes);
            dto.setIUsuario (usuarioDto);
            dto.setCEstado  (request.cEstado);

            // Actualizar si existe, crear si no existe
            List<FotoPerfil> filas = dao.buscarPorUsuario(usuarioDto);
            if(filas.size() > 0) {
                FotoPerfil filaPorActualizar = filas.get(0);
                dto.setICodigo(filaPorActualizar.getICodigo());
                dao.update(dto);
                resultado.setsMsj("La imagen seleccionada ha sido actualizada correctamente");
            }
            else {
                dao.create(dto);
                resultado.setsMsj("La imagen seleccionada ha sido guardada correctamente");
            }

            resultado.setbRta(Boolean.TRUE);
        }
        else {
            resultado.setbRta(Boolean.FALSE);
            resultado.setsMsj("No se ha podido encontrar al usuario con identificación ["+request.cIdentificacion+"]");
        }
        return resultado;
    }

    
    
    
    
    /**
     * Controller para obtener la foto de perfil
     * 
     * @param xiTipoIdent tipo de identificación
     * @param xsIdent identificacion
     */
    @Override
    public ResponseServirFotoPerfil obtenerFotoPerfil(int xiTipoIdent, String xsIdent) {
        ResponseServirFotoPerfil    resultado   = new ResponseServirFotoPerfil();
        FotoPerfilDataAccessImp     dao         = new FotoPerfilDataAccessImp();
        FotoPerfil                  dto         = new FotoPerfil();
        UsuarioDataAccessImp        usuarioDao  = new UsuarioDataAccessImp();
        Usuario                     usuarioDto  = new Usuario();
        
        // Obtenemos el usuario a partir de la cdentificacion;
        usuarioDto = usuarioDao.findUserByPersonaIdent(xiTipoIdent, xsIdent, 1);
        
        if(usuarioDto != null) {
            List<FotoPerfil> fotos = dao.buscarPorUsuario(usuarioDto);
            if(fotos.size() > 0) {
                resultado.setbRta(Boolean.TRUE);
                resultado.setsMsj("Correcto: Usuario con identificación ["+
                        xsIdent
                        +"] tiene foto de perfil. Sirviendo...");
                dto = fotos.get(0);
                resultado.setiCodigo(dto.getICodigo());
                resultado.setcNombre(dto.getCNombre());
                resultado.setcTipo(dto.getCTipo());
                resultado.setiTamanio(dto.getITamanio());
                resultado.setfSubida(dto.getFSubida());
                resultado.setcEstado(dto.getCEstado());
                resultado.setUrl64Imagen(dto.getBImgclob());
            }
            else {
                resultado.setbRta(Boolean.TRUE);
                resultado.setiCodigo(0);
                resultado.setsMsj("Correcto: Usuario con identificación ["+
                        xsIdent
                            +"] NO tiene foto de perfil.");
            }
        }
        else {
            resultado.setbRta(Boolean.FALSE);
            resultado.setiCodigo(-1);
            resultado.setsMsj("Error: Usuario con identificación ["+
                    xsIdent
                        +"] NO fue encontrado en la BD");
        }
        
        return resultado;
    }

    
    
    
    
    /**
     * Controller para actualizar a null la foto de perfil
     * 
     * @param xiTipoIdent tipo de identificación
     * @param xsIdent identificacion
     */
    @Override
    public respuestaGenerica nulificarFotoPerfil(int xiTipoIdent, String xsIdent) {
        respuestaGenerica           resultado   = new respuestaGenerica();
        FotoPerfilDataAccessImp     dao         = new FotoPerfilDataAccessImp();
        FotoPerfil                  dto         = new FotoPerfil();
        UsuarioDataAccessImp        usuarioDao  = new UsuarioDataAccessImp();
        Usuario                     usuarioDto  = new Usuario();
        
        // Obtenemos el usuario a partir de la cdentificacion;
        usuarioDto = usuarioDao.findUserByPersonaIdent(xiTipoIdent, xsIdent, 1);
        
        if(usuarioDto != null) {
            List<FotoPerfil> fotos = dao.buscarPorUsuario(usuarioDto);
            if(fotos.size() > 0) {
                dto = fotos.get(0);
                dto.setBImgclob(null);
                FotoPerfil res = dao.update(dto);
                if(res.getBImgclob() == null) {
                    resultado.setbRta(Boolean.TRUE);
                    resultado.setsMsj("Se ha eliminado la foto de perfil");
                }
                else {
                    resultado.setbRta(Boolean.FALSE);
                    resultado.setsMsj("No se ha podido eliminar la imagen");
                }
            }
            else {
                resultado.setbRta(Boolean.FALSE);
                resultado.setsMsj("Se ha eliminado la foto de perfil");
            }
        }
        else {
            resultado.setbRta(Boolean.FALSE);
            resultado.setsMsj("Error: Usuario con identificación ["+
                    xsIdent
                        +"] NO fue encontrado en el sistema");
        }
        
        resultado.setiCodigo(-1);
        return resultado;
    }
}