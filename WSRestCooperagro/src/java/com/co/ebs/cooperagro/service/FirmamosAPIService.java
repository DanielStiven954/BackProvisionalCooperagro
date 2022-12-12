/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.olimpiait.modelapi.ConsultaANI;
import com.co.ebs.cooperagro.olimpiait.modelresponse.ResponseConsultaANI;

/**
 *
 * @author Brayan F Silva R
 */
public interface FirmamosAPIService {

    ResponseConsultaANI consultaIdentificacionANI(ConsultaANI consultaANI);

//    ResponseEstadoSolicitudPagare estadoPagare(EstadoSolicitudPagare estadoSolicitudPagare);
//
//    ResponseRecepArchivoPagare recepcionArchivoPagare(RecepcionArchivoPagare recepcionArchivoPagare);
//
//    ResponseEstadoFirmaDocumento estadoFirmaDocumento(EstadoFirmaDocumento estadoFirmaDocumento);
//
//    respuestaGenerica isFechaExpDoc(Long xiCodUser, String sFechaExp);
//
//    respuestaProcesoPagare generarPagareInmaterializado(Long xiCodUser);
//
//    responseEstadoDocumento estadoSolicitudPagare(String xiIdProceso);
//
//    ResponseVerificacionIdentidad veriIndentidad(String documeneto, String tipoDocumento, String sFechaExp);
}
