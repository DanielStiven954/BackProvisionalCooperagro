/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AutorizacionSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.DatoPersonalSolAfiWebDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.InfoConyugeSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.SolicitudAfiliacionWebDataAccessImp;
import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.InfoConyugeSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.request.RequestConyuge;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Juan Sebastian F
 */
public class DatosConyugeServiceBean {

    public respuestaGenerica UpdateDatosConyugue(InfoConyugeSolAfilWeb conyuge) {
        respuestaGenerica                   respuesta = new respuestaGenerica();        
        DatoPersonalSolAfiWebDataAccessImp  Busqueda  = new DatoPersonalSolAfiWebDataAccessImp();       
        SolicitudAfiliacionWebDataAccessImp InfoSoli  = new SolicitudAfiliacionWebDataAccessImp();
        DatoPersonalSolAfiWebDataAccessImp  datos     = new DatoPersonalSolAfiWebDataAccessImp();
        InfoConyugeSolAfilWebDataAccessImp  Conyuge   = new InfoConyugeSolAfilWebDataAccessImp();
        //Consulta el I_codigo del Afiliado Previamente
        DatoPersonalSolAfilWeb dPersona=datos.findDatoPersonalByCedula(conyuge.getCIdentificacionCony());
        System.out.println("***********************************"+dPersona.toString());
        //Enviamos Dato Codigo
        conyuge.setICodigo(dPersona.getISolAfiliacionWeb().getICodigo());      
        //Terminamos el Proceso
        
        SolicitudAfiliacionWeb Solicitud = InfoSoli.findSolicitudAfiliacionWebById(conyuge.getICodigo());
        conyuge.setISolAfiliacionWeb(Solicitud);
        InfoConyugeSolAfilWeb findConyuge = Conyuge.findInfoConyugeBySolAfilWeb(conyuge.getICodigo());
        
        System.out.println("Datos: "+conyuge.toString());
        
        
        try {

            int Codigo = conyuge.getICodigo().intValue();

            if (conyuge.getCIdentificacion() != null
                    || conyuge.getCApellidos() != null
                    || conyuge.getCDireccion() != null
                    || conyuge.getCNombres() != null
                    || conyuge.getCNumCelular() != null
                    || conyuge.getCNumTelefono() != null
                    || conyuge.getICiudadResidencia() != null                   
                    || conyuge.getISolAfiliacionWeb() != null
                    || conyuge.getITipoIdent() != null) {

                if (findConyuge.getCIdentificacion() != null) {

                    try {

                        Conyuge.updateInfoConyugeSolAfilWeb(conyuge);
                        respuesta.setsMsj("Los Datos se han Actualizado Sastifactoriamente");
                        respuesta.setiCodigo(Codigo);
                        respuesta.setbRta(true);
                    } catch (Exception e) {

                        respuesta.setsMsj("¡Ocurrio un Error Actualizando la Informacion!");
                        respuesta.setiCodigo(Codigo);
                        respuesta.setbRta(false);
                        e.printStackTrace();
                    }

                } else {

                    try {

                        Conyuge.saveInfoConyugeSolAfilWeb(conyuge);
                        respuesta.setsMsj("Los Datos se han Guardado Sastifactoriamente");
                        respuesta.setiCodigo(Codigo);
                        respuesta.setbRta(true);
                    } catch (Exception e) {

                        respuesta.setsMsj("¡Ocurrio un Error Guardando la Informacion!");
                        respuesta.setiCodigo(Codigo);
                        respuesta.setbRta(false);
                        e.printStackTrace();
                    }

                }

            } else {
                respuesta.setsMsj("Datos Incompletos, por favor valide de nuevo");
                respuesta.setiCodigo(Codigo);
                respuesta.setbRta(false);
            }
        } catch (Exception e) {
            respuesta.setsMsj("¡Ocurrio un Error Con los Datos Rectifique la Informacion!");
            respuesta.setiCodigo(0);
            respuesta.setbRta(false);
            e.printStackTrace();
        }
        return respuesta;

    }
    
//    public static void main(String[] args) {
//        DatoPersonalSolAfiWebDataAccessImp Busqueda=new DatoPersonalSolAfiWebDataAccessImp();
////        long dato=1030664681; 
//        long dato=1022426702;
////        DatoPersonalSolAfilWeb datos=Busqueda.findDatoPersonalByCedula(dato);
//        DatoPersonalSolAfilWeb datos=Busqueda.findDatoPersonalByCedula(dato);
//        System.err.println("Dato: "+datos);
//                
//    }
}
