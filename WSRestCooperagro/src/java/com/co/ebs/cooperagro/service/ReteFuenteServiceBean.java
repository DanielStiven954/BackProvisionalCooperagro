/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import wsmovimientoscygnus_retefuente.RespuestaCert;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearPDF;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestReteFuente;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.wscore.WSReteFuente;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;


/**
 *
 * @author Brayan Moreno
 */
public class ReteFuenteServiceBean implements ReteFuenteService {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String psBase = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
    private final String psUsuario = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
    private final String psClave = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");
    private final WSReteFuente wsReteFuente = new WSReteFuente();
    private final UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();

    @Override
    public respuestaGenerica retencionFuentePDF(RequestReteFuente requestReteFuente) {
        
        respuestaGenerica generica = new respuestaGenerica();
        RespuestaCert respuestaCert = new RespuestaCert();
        String encodedString = "";
        Usuario findUserByPersonaIdent = usuarioServiceBean.findUserByPersonaIdent(Integer.parseInt(requestReteFuente.getsTipoIdentificacion()), requestReteFuente.getPsIdentificacion(), 1);
        if (findUserByPersonaIdent != null && findUserByPersonaIdent.getICodigo() != null) {

            String SNombre = cygnusCoreServiceBean.getNombresCompletos("", requestReteFuente.getsTipoIdentificacion(), requestReteFuente.getPsIdentificacion());
            String fechaInicioR = requestReteFuente.getPsFechaIni().replaceAll(",", "-");
            String fechaFinR = requestReteFuente.getPsFechaFin().replaceAll(",", "-");
            String fechaInicio[] = fechaInicioR.split("-");
            String fechaFin[] = fechaFinR.split("-");
            String sFechaInicio = "";
            String sFechaFin = "";
            if (fechaFin.length > 0 && fechaInicio.length > 0 && SNombre != "" && SNombre != null) {
                sFechaInicio = fechaInicio[0] + " de " + this.getMes(Integer.parseInt(fechaInicio[1])) + " de " + fechaInicio[2];
                sFechaFin = fechaFin[0] + " de " + this.getMes(Integer.parseInt(fechaFin[1])) + " de " + fechaFin[2];
                respuestaCert = this.wsReteFuente.reteFuente(requestReteFuente, this.psBase, this.psUsuario, this.psClave);
                if (respuestaCert != null) {
                    crearPDF pdf = new crearPDF();
                    String SGeneroPersona = cygnusCoreServiceBean.getGeneroPersona("", String.valueOf(findUserByPersonaIdent.getIPersona().getITipoIdent()), findUserByPersonaIdent.getIPersona().getCIdentificacion());
                    try {
                        if (pdf.generarReteFuente(respuestaCert, requestReteFuente.getPsIdentificacion(), SNombre, sFechaInicio, sFechaFin, SGeneroPersona)) {

                            byte[] input_file = Files.readAllBytes(Paths.get("D:\\Cooperagro\\Retencion\\" + requestReteFuente.getPsIdentificacion() + ".pdf"));
                            byte[] encodedBytes = Base64.getEncoder().encode(input_file);
                            encodedString = new String(encodedBytes);

                            generica.setbRta(true);
                            generica.setsMsj(encodedString);
                            generica.setiCodigo(1);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        generica.setbRta(false);
                        generica.setsMsj("No se ha podido procesar la solicitud. Por favor intente de nuevo más tarde.");
                        generica.setiCodigo(0);
                    }
                } else {
                    generica.setbRta(false);
                    generica.setsMsj("No se logro obtener información de acuerdo a las fechas ingresadas: Fecha Inicio: " + sFechaInicio + " y Fecha Fin: " + sFechaFin);
                    generica.setiCodigo(0);
                }
            }

        } else {
            generica.setbRta(false);
            generica.setsMsj("No se encontraron registros con el N° de documento: " + requestReteFuente.getPsIdentificacion());
            generica.setiCodigo(0);
        }

        return generica;
    }

    public String getMes(int mes) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(0, mes, 0);
        return new SimpleDateFormat("MMMM").format(calendario.getTime());
    }

}
