/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.InfoCodeudorDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.SolicitudCreditoDataAccessImp;
import com.co.ebs.cooperagro.domain.InfoCodeudor;
import com.co.ebs.cooperagro.domain.SolicitudCredito;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseInfoCodeudor;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class InfoCodeudorSolCreditoServiceBean implements InfoCodeudorSolCreditoService {

    private final InfoCodeudorDataAccessImp infoDataA = new InfoCodeudorDataAccessImp();
    private final utilidad util = new utilidad();
    private final UsuarioServiceBean usuarioBean = new UsuarioServiceBean();
    private final SolicitudCreditoDataAccessImp solService = new SolicitudCreditoDataAccessImp();

    @Override
    public respuestaGenerica saveInfoCodeudor(String xData) {
        respuestaGenerica rta = new respuestaGenerica();

        try {
            String partes[] = util.decodeBase64(xData).split(";");
            String codSolicitud = partes[0];
            String nombres = partes[1];
            String apellidos = partes[2];
            String identificacion = partes[3];
            String nombreEmpresa = partes[4];
            String direccionResi = partes[5];
            String iCiudad = partes[6];
            String cTelefono = partes[7];
            String codUsuarioCredor = partes[8];
            
            if (codSolicitud != null && !codSolicitud.equals("") && !codSolicitud.equals("undefined")) {
                Usuario usuarioBus = usuarioBean.findUsuarioById(Long.parseLong(codUsuarioCredor));
                SolicitudCredito findSolCredById = solService.findSolicitudCreditoById(new Long(codSolicitud));
                if (findSolCredById != null && findSolCredById.getICodigo() != null) {
                    InfoCodeudor nuevaInfo = new InfoCodeudor();
                    nuevaInfo.setiSolicitudCredito(findSolCredById);
                    nuevaInfo.setcNombres(nombres);
                    nuevaInfo.setcApellidos(apellidos);
                    nuevaInfo.setcIdentificacion(identificacion);
                    nuevaInfo.setcNombreEmpresa(nombreEmpresa);
                    nuevaInfo.setcDireccionResidencia(direccionResi);
                    nuevaInfo.setiCiudad(Long.parseLong(iCiudad));
                    nuevaInfo.setcTelefono(cTelefono);
                    nuevaInfo.setiUsuarioCreador(usuarioBus);

                    InfoCodeudor infoCta = infoDataA.saveInfoCodeudor(nuevaInfo);
                    if (infoCta != null && infoCta.getiCodigo()!= null) {
                        rta.setiCodigo(1);
                        rta.setbRta(Boolean.TRUE);
                        rta.setsMsj("La información del codeudor ha sido guardada satisfactoriamente.");
                    } else {
                        rta.setiCodigo(0);
                        rta.setbRta(Boolean.FALSE);
                        rta.setsMsj("Se ha presentando un inconveniente al guardar la información del codeudor, por favor intente de nuevo.");
                    }
                } else {
                    rta.setiCodigo(0);
                    rta.setbRta(Boolean.FALSE);
                    rta.setsMsj("No se ha encontrado registro de solicitud de crédito, por favor inicie el proceso de solicitud.");
                }

            } else {
                rta.setiCodigo(0);
                rta.setbRta(Boolean.FALSE);
                rta.setsMsj("Se ha presentando un inconveniente al guardar la información del codeudor, por favor intente de nuevo.");
            }

        } catch (Exception e) {
            rta.setiCodigo(0);
            rta.setbRta(Boolean.FALSE);
            rta.setsMsj("Se ha presentando un inconveniente al guardar la información del codeudor, por favor intente de nuevo.");
            e.printStackTrace();
        }
        return rta;
    }

    @Override
    public respuestaGenerica editInfoCodeudor(InfoCodeudor xData) {
        respuestaGenerica rta = new respuestaGenerica();
        InfoCodeudor infoCta = infoDataA.editInfoCodeudor(xData);
        if (infoCta != null && infoCta.getiCodigo()!= null) {
            rta.setiCodigo(1);
            rta.setbRta(Boolean.TRUE);
            rta.setsMsj("Se ha editado la información  de manera correcta");
        } else {
            rta.setiCodigo(0);
            rta.setbRta(Boolean.FALSE);
            rta.setsMsj("Ha ocurrido un error.");
        }
        return rta;
    }

    @Override
    public respuestaGenerica updateInfoCodeudor(String xsData) {
        respuestaGenerica rta = new respuestaGenerica();
        try {
            String partes[] = util.decodeBase64(xsData).split(";");
            String codSolicitud = partes[0];
            String nombres = partes[1];
            String apellidos = partes[2];
            String identificacion = partes[3];
            String nombreEmpresa = partes[4];
            String direccionResi = partes[5];
            String iCiudad = partes[6];
            String cTelefono = partes[7];
            String codUsuarioCredor = partes[8];
            
             if (codSolicitud != null && !codSolicitud.equals("") && !codSolicitud.equals("undefined")) {
                Usuario usuarioBus = usuarioBean.findUsuarioById(Long.parseLong(codUsuarioCredor));
                SolicitudCredito solBuscada = solService.findSolicitudByID(Long.parseLong(codSolicitud)).get(0);

                InfoCodeudor findInfoCtaBanco = this.infoDataA.findInfoCodeudorByIdSolCred(Long.parseLong(codSolicitud));
                if (findInfoCtaBanco != null && findInfoCtaBanco.getiCodigo()!= null) {
                    InfoCodeudor nuevaInfo = new InfoCodeudor();
                    nuevaInfo.setiSolicitudCredito(solBuscada);
                    nuevaInfo.setcNombres(nombres);
                    nuevaInfo.setcApellidos(apellidos);
                    nuevaInfo.setcIdentificacion(identificacion);
                    nuevaInfo.setcNombreEmpresa(nombreEmpresa);
                    nuevaInfo.setcDireccionResidencia(direccionResi);
                    nuevaInfo.setiCiudad(Long.parseLong(iCiudad));
                    nuevaInfo.setcTelefono(cTelefono);
                    nuevaInfo.setiUsuarioCreador(usuarioBus);
                    
                    InfoCodeudor updateInfoCta = infoDataA.editInfoCodeudor(findInfoCtaBanco);
                    if (updateInfoCta != null && updateInfoCta.getiCodigo()!= null) {
                        rta.setiCodigo(1);
                        rta.setbRta(Boolean.TRUE);
                        rta.setsMsj("La información de la cuenta ha sido actualizada satisfactoriamente.");
                    } else {
                        rta.setiCodigo(0);
                        rta.setbRta(Boolean.FALSE);
                        rta.setsMsj("Se ha presentando un inconveniente al actualizar la información de la cuenta, por favor intente de nuevo.");
                    }
                } else {
                    rta.setiCodigo(0);
                    rta.setbRta(Boolean.FALSE);
                    rta.setsMsj("No Se ha encontrado información de la cuenta relacionada con la solicitud de crédito.Por favor intente de nuevo.");
                }

            } else {
                rta.setiCodigo(0);
                rta.setbRta(Boolean.FALSE);
                rta.setsMsj("Se ha presentando un inconveniente al actualziar la información de la cuenta, por favor intente de nuevo.");
            }

        } catch (Exception e) {
            rta.setiCodigo(0);
            rta.setbRta(Boolean.FALSE);
            rta.setsMsj("Se ha presentando un inconveniente al actualizar la información de la cuenta, por favor intente de nuevo.");
            e.printStackTrace();
        }
        return rta;
    }

    @Override
    public void deleteInfoCodeudor(InfoCodeudor xData) {
        infoDataA.deleteInfoCodeudor(xData);
    }

    @Override
    public InfoCodeudor findById(long xCodigo){
        return infoDataA.findById(xCodigo);
    }

    @Override
    public List<InfoCodeudor> buscarTodos() {
        return infoDataA.buscarTodos();
    }

//    @Override
//    public InfoCodeudor findInfoCodeudorByIdSolCredito(Long idSolCred) {
//        ResponseInfoCodeudor responseInfoCtaBanco = new ResponseInfoCodeudor();
//        InfoCtaBanco infoCtaBanco = infoDataA.findInfoCtaBancoByIdSolCred(idSolCred);
//        if (infoCtaBanco != null && infoCtaBanco.getICodigo() != null) {
//            responseInfoCtaBanco.setbRta(Boolean.TRUE);
//            responseInfoCtaBanco.setsMsj("Se ha encontrado registro de la información de la cuenta.");
//            infoCtaBanco.setISolicitudCredito(null);
//            infoCtaBanco.setIUsuarioCreador(null);
//            infoCtaBanco.setIUsuarioModificador(null);
//            responseInfoCtaBanco.setInfoCtaBanco(infoCtaBanco);
//        } else {
//            responseInfoCtaBanco.setbRta(Boolean.FALSE);
//            responseInfoCtaBanco.setsMsj("No se ha encontrado información de la cuenta.");
//            responseInfoCtaBanco.setInfoCtaBanco(infoCtaBanco);
//        }
//        return responseInfoCtaBanco;
//    }

    @Override
    public ResponseInfoCodeudor findInfoCodeudorByIdSolCred(Long idSolCred) {
         ResponseInfoCodeudor responseInfoCtaBanco = new ResponseInfoCodeudor();
        InfoCodeudor infoCtaBanco = infoDataA.findInfoCodeudorByIdSolCred(idSolCred);
        if (infoCtaBanco != null && infoCtaBanco.getiCodigo()!= null) {
            responseInfoCtaBanco.setbRta(Boolean.TRUE);
            responseInfoCtaBanco.setsMsj("Se ha encontrado registro de la información de la cuenta.");
            infoCtaBanco.setiSolicitudCredito(null);
            infoCtaBanco.setiUsuarioCreador(null);
            infoCtaBanco.setiUsuarioModificador(null);
            responseInfoCtaBanco.setInfoCodeud(infoCtaBanco);
        } else {
            responseInfoCtaBanco.setbRta(Boolean.FALSE);
            responseInfoCtaBanco.setsMsj("No se ha encontrado información de la cuenta.");
            responseInfoCtaBanco.setInfoCodeud(infoCtaBanco);
        }
        return responseInfoCtaBanco;
    }
}
