/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;
import com.co.ebs.cooperagro.olimpiait.api.ApiFirmamos;
import com.co.ebs.cooperagro.olimpiait.modelapi.ConsultaANI;
import com.co.ebs.cooperagro.olimpiait.modelresponse.ResponseConsultaANI;
import com.google.gson.Gson;

/**
 *
 * @author Brayan F Silva R
 */
public class FirmamosAPIServiceBean implements FirmamosAPIService {

//    private static final Locale localeCO = new Locale("es", "CO");
//    private static final SimpleDateFormat dateFormatDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy", localeCO);
//    private static final SimpleDateFormat dateFormatAnioMesDia = new SimpleDateFormat("yyyy-MM-dd", localeCO);

    @Override
    public ResponseConsultaANI consultaIdentificacionANI(ConsultaANI consultaANI) {
        ResponseConsultaANI responseConsultaANI = new ResponseConsultaANI();
        String sJSONResponse = new ApiFirmamos().consultarANI(consultaANI);
        System.out.println("ResponserFirma " + sJSONResponse);
        if (sJSONResponse != null && !sJSONResponse.equals("")) {
            if (!sJSONResponse.equals("\"Error interno del servicio.\"") && !sJSONResponse.equals("\"El tipo del documento no puede ser vacio y solo se aceptan CC, CE y NIT\"")) {
                responseConsultaANI = new Gson().fromJson(sJSONResponse, ResponseConsultaANI.class);
            }
        }
        System.out.println("REturn "+ responseConsultaANI);
        return responseConsultaANI;
    }
//
//    @Override
//    public ResponseEstadoSolicitudPagare estadoPagare(EstadoSolicitudPagare estadoSolicitudPagare) {
//        ResponseEstadoSolicitudPagare responseEstadoDocumento = new ResponseEstadoSolicitudPagare();
//        String sJSONResponse = new apifirmamos().estadoSolicitudPagare(estadoSolicitudPagare);
//        if (sJSONResponse != null && !sJSONResponse.equals("")) {
//            if (!sJSONResponse.equals("\"Error interno del servicio.\"")) {
//                responseEstadoDocumento = new Gson().fromJson(sJSONResponse, ResponseEstadoSolicitudPagare.class);
//            }
//        }
//        return responseEstadoDocumento;
//    }
//
//    @Override
//    public ResponseEstadoFirmaDocumento estadoFirmaDocumento(EstadoFirmaDocumento estadoFirmaDocumento) {
//        ResponseEstadoFirmaDocumento estadoFirmaDocumento1 = new ResponseEstadoFirmaDocumento();
//        String sJSONResponse = new apifirmamos().estadoFirmaDocumento(estadoFirmaDocumento);
//        if (sJSONResponse != null && !sJSONResponse.equals("")) {
//            if (!sJSONResponse.equals("\"Error interno del servicio.\"")) {
//                estadoFirmaDocumento1 = new Gson().fromJson(sJSONResponse, ResponseEstadoFirmaDocumento.class);
//            }
//        }
//        return estadoFirmaDocumento1;
//    }
//
//    @Override
//    public ResponseRecepArchivoPagare recepcionArchivoPagare(RecepcionArchivoPagare recepcionArchivoPagare) {
//        ResponseRecepArchivoPagare responseRecepArchivoPagare = new ResponseRecepArchivoPagare();
//        String sJSONResponse = new apifirmamos().recepcionArchivoPagare(recepcionArchivoPagare);
//        if (sJSONResponse != null && !sJSONResponse.equals("")) {
//            if (!sJSONResponse.equals("\"Error interno del servicio.\"")) {
//                responseRecepArchivoPagare = new Gson().fromJson(sJSONResponse, ResponseRecepArchivoPagare.class);
//            }
//        }
//        return responseRecepArchivoPagare;
//    }
//
//    @Override
//    public respuestaGenerica isFechaExpDoc(Long xiCodUser, String sFechaExp) {
//        respuestaGenerica rtaValidaFechaExpDoc = new respuestaGenerica();
//        Boolean isFechaExpDoc = Boolean.FALSE;
//        String sMsjRta = "";
//        Usuario findUserById = new UsuarioServiceBean().buscarUsuarioId(xiCodUser);
//        if (findUserById != null && findUserById.getICodigo() != null) {
//            ConsultaANI consultaANI = new ConsultaANI();
//            consultaANI.setIdProcesoCliente(String.valueOf(new Date().getTime()));
//            consultaANI.setDocumento(findUserById.getIPersona().getCIdentificacion());
//            if (findUserById.getIPersona().getITipoIdent().toString().equals("1")) {
//                consultaANI.setTipoDocumento("CC");
//            } else if (findUserById.getIPersona().getITipoIdent().toString().equals("2")) {
//                consultaANI.setTipoDocumento("NIT");
//            } else if (findUserById.getIPersona().getITipoIdent().toString().equals("3")) {
//                consultaANI.setTipoDocumento("CE");
//            }
//
//            ConsultaAniOlimpiait consultaAniOlimpiait = new ConsultaAniOlimpiait();
//            consultaAniOlimpiait.setIIdProceso(new Long(consultaANI.getIdProcesoCliente()));
//            consultaAniOlimpiait.setIUsuario(findUserById);
//            consultaAniOlimpiait.setFFechaConsulta(new Date());
//            ConsultaAniOlimpiait saveAniOlimpiait = new ConsultaAniServiceBean().saveConsultaAniOlimpiait(consultaAniOlimpiait);
//            if (saveAniOlimpiait != null && saveAniOlimpiait.getICodigo() != null) {
//                ResponseConsultaANI responseConsultaANI = this.consultaIdentificacionANI(consultaANI);
//                if (responseConsultaANI != null && responseConsultaANI.getCodigoErrorDatosCedula() != null && !responseConsultaANI.getCodigoErrorDatosCedula().equals("") && responseConsultaANI.getCodigoErrorDatosCedula().equals("0")) {
//                    try {
//                        RespuestaAniOlimpiait rtaAniOlimpiait = new RespuestaAniOlimpiait();
//                        rtaAniOlimpiait.setCIdTransaccion(responseConsultaANI.getIdTransaccion());
//                        rtaAniOlimpiait.setCNuip(responseConsultaANI.getNuip());
//                        rtaAniOlimpiait.setCPrimerNombre(responseConsultaANI.getPrimerNombre());
//                        rtaAniOlimpiait.setCSegundoNombre(responseConsultaANI.getSegundoNombre());
//                        rtaAniOlimpiait.setCPrimerApellido(responseConsultaANI.getPrimerApellido());
//                        rtaAniOlimpiait.setCSegundoApellido(responseConsultaANI.getSegundoApellido());
//                        rtaAniOlimpiait.setCParticula(responseConsultaANI.getParticula());
//                        EstadoCedula findEstadoCedula = new EstadoCedulaServiceBean().findEstadoCedulaByICodVigencia(responseConsultaANI.getEstadoCedula().longValue());
//                        if (findEstadoCedula != null && findEstadoCedula.getICodigo() != null) {
//                            rtaAniOlimpiait.setIEstadoCedula(findEstadoCedula);
//                        }
//                        rtaAniOlimpiait.setCNumeroResolucion(responseConsultaANI.getNumeroResolucion());
//                        rtaAniOlimpiait.setCAnioResolucion(responseConsultaANI.getAnioResolucion());
//                        rtaAniOlimpiait.setCMunicipioExpedicion(responseConsultaANI.getMunicipioExpedicion());
//                        rtaAniOlimpiait.setCDepartamentoExpedicio(responseConsultaANI.getDepartamentoExpedicion());
//                        rtaAniOlimpiait.setCFechaExpedicion(responseConsultaANI.getFechaExpedicion());
//                        Long lCodErrorDatoCedula = new Long(responseConsultaANI.getCodigoErrorDatosCedula());
//                        rtaAniOlimpiait.setICodErroDatosCedula(BigInteger.valueOf(lCodErrorDatoCedula));
//                        rtaAniOlimpiait.setIConsAniOlimpiait(saveAniOlimpiait);
//                        new RespuestaANIServiceBean().saveRespuesta(rtaAniOlimpiait);
//                        if (responseConsultaANI.getEstadoCedula().toString().equals("0")) {
//                            Date dateExpDocFor = this.dateFormatAnioMesDia.parse(sFechaExp);
//                            SimpleDateFormat dateFormatDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy", localeCO);
//                            String sDateExpDoc = dateFormatDiaMesAnio.format(dateExpDocFor);
//                            Date dateFechaExpDoc = this.dateFormatDiaMesAnio.parse(sDateExpDoc);
//                            Date dateExpDocANI = this.dateFormatDiaMesAnio.parse(responseConsultaANI.getFechaExpedicion());
//                            if (dateFechaExpDoc.equals(dateExpDocANI)) {
//                                isFechaExpDoc = Boolean.TRUE;
//                                sMsjRta = "Se ha validado de manera correcta la fecha de expedición ingresada.";
//                            } else {
//                                isFechaExpDoc = Boolean.FALSE;
//                                sMsjRta = "Por favor verifique los datos ingresados, la fecha de expedición ingresada no coincide con la reportada por la registraduria.";
//                            }
//                        } else {
//                            isFechaExpDoc = Boolean.FALSE;
//                            sMsjRta = "El número de documento con el que fue registrado y se esta validando se encuentra reportado como " + findEstadoCedula.getCDescripcion().toUpperCase();
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        isFechaExpDoc = Boolean.FALSE;
//                        sMsjRta = "Se ha presentado un inconveniente en el proceso de validación, intente de nuevo más tarde.";
//                    }
//                } else {
//                    isFechaExpDoc = Boolean.FALSE;
//                    sMsjRta = "No se ha podido realizar el proceso de verificación de identidad de la persona, por favor intente de nuevo.";
//                }
//            } else {
//                isFechaExpDoc = Boolean.FALSE;
//                sMsjRta = "Se ha presentado un inconveniente al intentar procesar la validación de identidad, por favor intente de nuevo.";
//            }
//        }
//        rtaValidaFechaExpDoc.setbRta(isFechaExpDoc);
//        rtaValidaFechaExpDoc.setsMsj(sMsjRta);
//        return rtaValidaFechaExpDoc;
//    }
//    
//    @Override
//    public ResponseVerificacionIdentidad veriIndentidad(String documeneto, String tipoDocumento, String sFechaExp) {
//        ResponseVerificacionIdentidad rtaValidaFechaExpDoc = new ResponseVerificacionIdentidad();
//        Boolean isFechaExpDoc = Boolean.FALSE;
//        String sMsjRta = "";
//        ResponseConsultaANI responseConsultaANI= new ResponseConsultaANI();
//        if (documeneto != "" && tipoDocumento != "" && sFechaExp != "") {
//            ConsultaANI consultaANI = new ConsultaANI();
//            consultaANI.setIdProcesoCliente(String.valueOf(new Date().getTime()));
//            consultaANI.setDocumento(documeneto);
//            if (tipoDocumento.equals("1")) {
//                consultaANI.setTipoDocumento("CC");
//            } else if (tipoDocumento.equals("2")) {
//                consultaANI.setTipoDocumento("NIT");
//            } else if (tipoDocumento.equals("3")) {
//                consultaANI.setTipoDocumento("CE");
//            }
//                responseConsultaANI = this.consultaIdentificacionANI(consultaANI);
//                if (responseConsultaANI != null && responseConsultaANI.getCodigoErrorDatosCedula() != null && !responseConsultaANI.getCodigoErrorDatosCedula().equals("") && responseConsultaANI.getCodigoErrorDatosCedula().equals("0")) {
//                    try {
//                        EstadoCedula findEstadoCedula = new EstadoCedulaServiceBean().findEstadoCedulaByICodVigencia(responseConsultaANI.getEstadoCedula().longValue());
//                        if (responseConsultaANI.getEstadoCedula().toString().equals("0")) {
//                            Date dateExpDocFor = this.dateFormatAnioMesDia.parse(sFechaExp);
//                            SimpleDateFormat dateFormatDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy", localeCO);
//                            String sDateExpDoc = dateFormatDiaMesAnio.format(dateExpDocFor);
//                            Date dateFechaExpDoc = this.dateFormatDiaMesAnio.parse(sDateExpDoc);
//                            Date dateExpDocANI = this.dateFormatDiaMesAnio.parse(responseConsultaANI.getFechaExpedicion());
//                            if (dateFechaExpDoc.equals(dateExpDocANI)) {
//                                isFechaExpDoc = Boolean.TRUE;
//                                sMsjRta = "Se ha validado de manera correcta la fecha de expedición ingresada.";
//                            } else {
//                                isFechaExpDoc = Boolean.FALSE;
//                                sMsjRta = "Por favor verifique los datos ingresados, la fecha de expedición ingresada no coincide con la reportada por la registraduria.";
//                            }
//                        } else {
//                            isFechaExpDoc = Boolean.FALSE;
//                            sMsjRta = "El número de documento con el que fue registrado y se esta validando se encuentra reportado como " + findEstadoCedula.getCDescripcion().toUpperCase();
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        isFechaExpDoc = Boolean.FALSE;
//                        sMsjRta = "Se ha presentado un inconveniente en el proceso de validación, intente de nuevo más tarde.";
//                    }
//                } else {
//                    isFechaExpDoc = Boolean.FALSE;
//                    sMsjRta = "No se ha podido realizar el proceso de verificación de identidad de la persona, por favor intente de nuevo.";
//                }
//        }
//        rtaValidaFechaExpDoc.setResponseConsultaANI(responseConsultaANI);
//        rtaValidaFechaExpDoc.setFlag(isFechaExpDoc);
//        rtaValidaFechaExpDoc.setsMsg(sMsjRta);
//        return rtaValidaFechaExpDoc;
//    }
//
//    @Override
//    public responseEstadoDocumento estadoSolicitudPagare(String xiIdProceso) {
//        responseEstadoDocumento rtaEstadoDocumento = new responseEstadoDocumento();
//        Boolean bRta = Boolean.FALSE;
//        Boolean isFirmaInvolucrados = Boolean.FALSE;
//        String sMsjRta = "";
//        String sMsjValidFirmaInvolucrados = "";
//        Long iEstadoCodigo = null;
//        try {
//            ProcesoPagareOlimpiait findProcesoPagareByIdProceso = new ProcesoPagareServiceBean().findPagareByIdProceso(Long.parseLong(xiIdProceso));
//            if (findProcesoPagareByIdProceso != null && findProcesoPagareByIdProceso.getICodigo() != null) {
//                EstadoFirmaDocumento estadoFirmaDocumento = new EstadoFirmaDocumento();
//                estadoFirmaDocumento.setIdProcesoCliente(String.valueOf(findProcesoPagareByIdProceso.getIIdProceso()));
//                if (findProcesoPagareByIdProceso.getRespuestaProcesoPagareList() != null && !findProcesoPagareByIdProceso.getRespuestaProcesoPagareList().isEmpty()) {
//                    estadoFirmaDocumento.setSerialDocumento(findProcesoPagareByIdProceso.getRespuestaProcesoPagareList().get(0).getCSerialPagare());
//                    ResponseEstadoFirmaDocumento responseEstadoFirmaDocumento = new FirmamosAPIServiceBean().estadoFirmaDocumento(estadoFirmaDocumento);
//                    findProcesoPagareByIdProceso.setIEstadoConsPagare(new EstadoConsultaPagare(responseEstadoFirmaDocumento.getEstadoDocumentoId().longValue()));
//                    ProcesoPagareOlimpiait updatePagareOlimpiait = new ProcesoPagareServiceBean().updateProcesoPagareOlimpiait(findProcesoPagareByIdProceso);
//                    if (updatePagareOlimpiait != null && updatePagareOlimpiait.getICodigo() != null) {
//                        if (responseEstadoFirmaDocumento != null && responseEstadoFirmaDocumento.getEstadoDocumentoId() != null && responseEstadoFirmaDocumento.getEstadoDocumentoId() != 0) {
//                            List<ResponseFirmas> listFirmas = responseEstadoFirmaDocumento.getFirmas();
//                            List<ResponseFirmas> listValidFirmas = responseEstadoFirmaDocumento.getFirmas();
//                            if (listFirmas != null && !listFirmas.isEmpty()) {
//                                EstadoFirmaProcPagare estadoFirmaProcPagare = new EstadoFirmaProcPagare();
//                                for (ResponseFirmas listFirma : listFirmas) {
//                                    estadoFirmaProcPagare.setCTipoInvolucrado(listFirma.getTipoInvolucrado());
//                                    estadoFirmaProcPagare.setCIdentificacionUsuario(listFirma.getIdentificacionUsuario());
//                                    estadoFirmaProcPagare.setCFecha(listFirma.getFecha());
//                                    estadoFirmaProcPagare.setITipoEstadoFirma(new TipoEstadoFirma(listFirma.getEstadoFirmaId().longValue()));
//                                    if (listFirma.getTipoFirma().toUpperCase().equals("FIRMA ELECTRONICA")) {
//                                        estadoFirmaProcPagare.setITipoFirma(new TipoFirma(new Long("1")));
//                                    } else {
//                                        estadoFirmaProcPagare.setITipoFirma(new TipoFirma(new Long("2")));
//                                    }
//                                    estadoFirmaProcPagare.setIProcesoPagare(updatePagareOlimpiait);
//                                    new EstadoFirmaProcPagareServiceBean().saveEstadoFirmaProcPagare(estadoFirmaProcPagare);
//                                    estadoFirmaProcPagare = new EstadoFirmaProcPagare();
//                                }
//                                listValidFirmas.removeIf(firma -> (firma.getEstadoFirmaId().intValue() == 1));
//                                if (listValidFirmas != null && !listValidFirmas.isEmpty()) {
//                                    sMsjValidFirmaInvolucrados = listValidFirmas.stream().map((listValidFirma) -> "La firma del " + listValidFirma.getTipoInvolucrado().toUpperCase() + " con N° de documento " + listValidFirma.getIdentificacionUsuario() + " se encuentra en estado " + listValidFirma.getEstadoFirma() + " \n").reduce(sMsjValidFirmaInvolucrados, String::concat);
//                                    isFirmaInvolucrados = Boolean.FALSE;
//                                } else {
//                                    isFirmaInvolucrados = Boolean.TRUE;
//                                }
//                            }
//                            SolicitudPagare solicitudPagare = findProcesoPagareByIdProceso.getISolicitudPagare();
//                            if (solicitudPagare != null && solicitudPagare.getICodigo() != null) {
//                                if (isFirmaInvolucrados) {
//                                    TipoEstadoSolPagare findTipoEstadoSolPagareById = new TipoEstadoSolPagareServiceBean().findTipoEstadoSolPagareById(new Long(responseEstadoFirmaDocumento.getEstadoDocumentoId()));
//                                    if (responseEstadoFirmaDocumento.getEstadoDocumentoId() == 2 || responseEstadoFirmaDocumento.getEstadoDocumentoId() == 4) {
//                                        solicitudPagare.setITipoEstadoSolPagare(findTipoEstadoSolPagareById);
//                                        solicitudPagare.setFFechaFinProceso(new Date());
//                                    } else if (responseEstadoFirmaDocumento.getEstadoDocumentoId() == 3) {
//                                        solicitudPagare.setITipoEstadoSolPagare(findTipoEstadoSolPagareById);
//                                        solicitudPagare.setFFechaFinProceso(new Date());
//                                    } else {
//                                        solicitudPagare.setITipoEstadoSolPagare(findTipoEstadoSolPagareById);
//                                    }
//                                    SolicitudPagare updateSolicitudesPagare = new SolicitudPagareDataAccessImp().updateSolicitudPagare(solicitudPagare);
//                                    if (updateSolicitudesPagare != null && updateSolicitudesPagare.getICodigo() != null) {
//                                        if (updateSolicitudesPagare.getITipoEstadoSolPagare().getICodigo() == 2 || updateSolicitudesPagare.getITipoEstadoSolPagare().getICodigo() == 4) {
//                                            iEstadoCodigo = findProcesoPagareByIdProceso.getIEstadoConsPagare().getICodigo();
//                                            bRta = Boolean.TRUE;
//                                            sMsjRta = "El estado actual del pagare es " + updateSolicitudesPagare.getITipoEstadoSolPagare().getCDescripcion().toUpperCase() + ", el proceso ha sido culminado.";
//                                        } else if (updateSolicitudesPagare.getITipoEstadoSolPagare().getICodigo() == 3) {
//                                            iEstadoCodigo = findProcesoPagareByIdProceso.getIEstadoConsPagare().getICodigo();
//                                            bRta = Boolean.TRUE;
//                                            sMsjRta = "El estado actual del pagare es " + updateSolicitudesPagare.getITipoEstadoSolPagare().getCDescripcion().toUpperCase() + ", el proceso ha sido culminado.";
//                                        } else {
//                                            solicitudPagare.setITipoEstadoSolPagare(findTipoEstadoSolPagareById);
//                                            iEstadoCodigo = findProcesoPagareByIdProceso.getIEstadoConsPagare().getICodigo();
//                                            bRta = Boolean.FALSE;
//                                            sMsjRta = "El estado actual del pagare es " + updateSolicitudesPagare.getITipoEstadoSolPagare().getCDescripcion().toUpperCase() + ", por favor realice la firma del pagare mediante el link enviado por SMS o EMAIL, en caso de tener codeudores en el pagaré confirme que hayan realizado la firma.";
//                                        }
//
//                                    } else {
//                                        bRta = Boolean.FALSE;
//                                        sMsjRta = "No se pudo realizar la actualizacion de la solicitud de pagaré, por favor intente de nuevo.";
//                                    }
//                                } else {
//                                    TipoEstadoSolPagare findTipoEstadoSolPagareById = new TipoEstadoSolPagareServiceBean().findTipoEstadoSolPagareById(new Long(responseEstadoFirmaDocumento.getEstadoDocumentoId()));
//                                    solicitudPagare.setITipoEstadoSolPagare(findTipoEstadoSolPagareById);
//                                    SolicitudPagare updateSolicitudesPagare = new SolicitudPagareDataAccessImp().updateSolicitudPagare(solicitudPagare);
//                                    if (updateSolicitudesPagare != null && solicitudPagare.getITipoEstadoSolPagare() != updateSolicitudesPagare.getITipoEstadoSolPagare()) {
//                                        iEstadoCodigo = findProcesoPagareByIdProceso.getIEstadoConsPagare().getICodigo();
//                                        bRta = Boolean.FALSE;
//                                        sMsjRta = "El estado actual del pagare es " + updateSolicitudesPagare.getITipoEstadoSolPagare().getCDescripcion().toUpperCase() + "\n\n " + sMsjValidFirmaInvolucrados;
//                                    } else {
//                                        bRta = Boolean.FALSE;
//                                        sMsjRta = "No se pudo realizar la actualizacion de la solicitud de pagaré." + " \n\n " + sMsjValidFirmaInvolucrados;
//                                    }
//                                }
//
//                            } else {
//                                bRta = Boolean.FALSE;
//                                sMsjRta = "Se ha presentnado un inconveniente al intentar consultar la solicitud de pagare.";
//                            }
//                        } else {
//                            iEstadoCodigo = null;
//                            bRta = Boolean.FALSE;
//                            sMsjRta = "Se ha presentado un inconviente al consultar el estado del documento";
//                        }
//                    } else {
//                        iEstadoCodigo = null;
//                        bRta = Boolean.FALSE;
//                        sMsjRta = "Se ha presentado un inconviente al actualizar el estado documento y el estado de las firmas.";
//                    }
//                } else {
//                    iEstadoCodigo = null;
//                    bRta = Boolean.FALSE;
//                    sMsjRta = "Se ha presentado un inconviente al verificar los datos del pagare al momento de obtener el estado de las firmas y del documento.";
//                }
//            } else {
//                iEstadoCodigo = null;
//                bRta = Boolean.FALSE;
//                sMsjRta = "No se puede realizar la actualización, porque no tiene todos los datos completos la solicitud.";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            iEstadoCodigo = null;
//            bRta = Boolean.FALSE;
//            sMsjRta = "Se ha presentado un inconveniente en el proceo de verificación del estado de ls firmas del documento.";
//        }
//
//        rtaEstadoDocumento.setiCodigo(iEstadoCodigo);
//        rtaEstadoDocumento.setbRta(bRta);
//        rtaEstadoDocumento.setsMsj(sMsjRta);
//        return rtaEstadoDocumento;
//    }
//
//    @Override
//    public respuestaProcesoPagare generarPagareInmaterializado(Long xiCodUser) {
//        respuestaProcesoPagare rtaGenerica = new respuestaProcesoPagare();
//        Boolean bRta = Boolean.FALSE;
//        String sMsjRta = "";
//        String idProceso = "";
//        SolicitudPagare findSolicitudPagareByIdUserDeudor = new SolicitudPagareServiceBean().findSolicitudPagareByIdUserDeudor(xiCodUser);
//        if (findSolicitudPagareByIdUserDeudor != null && findSolicitudPagareByIdUserDeudor.getICodigo() != null) {
//            RecepcionArchivoPagare recepcionArchivoPagare = new RecepcionArchivoPagare();
//            try {
//                String sIdProcesoCliente = String.valueOf(new Date().getTime());
//                recepcionArchivoPagare.setIdProcesoCliente(sIdProcesoCliente);
//                String sRutaPlantilla = new ParametroServiceBean().obtenerParametroPorNombre("RUTA_PLANTILLA_PAGARE");
//                byte[] inFileBytes = Files.readAllBytes(Paths.get(sRutaPlantilla));
//                byte[] encoded = Base64.getEncoder().encode(inFileBytes);
//                String pdfInBase64 = new String(encoded);
//
//                recepcionArchivoPagare.setArchivoPagare(pdfInBase64);
//                recepcionArchivoPagare.setTipoPagare(2);
//
//                recepcionArchivoPagare.setTipoPlantilla(1);
//
//                recepcionArchivoPagare.setNumeroAprobacion(sIdProcesoCliente);
//
//                String sEmail = new CygnusCoreServiceBean().getEmailPersona(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCIdentificacion());
//                String sTelefono = new CygnusCoreServiceBean().getTelPersona(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCIdentificacion());
//                String sDireccion = new CygnusCoreServiceBean().getDireccionPersona(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCIdentificacion());
//
//                List<CamposEntradaPlantilla> listCamposEntradaPlantilla = new ArrayList<>();
//                CamposEntradaPlantilla camposEntradaPlantilla = new CamposEntradaPlantilla();
//
//                camposEntradaPlantilla.setNombre("cutv");
//                camposEntradaPlantilla.setTipo(4);
//                camposEntradaPlantilla.setValor(String.valueOf(new Date().getTime()));
//                listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                camposEntradaPlantilla = new CamposEntradaPlantilla();
//                camposEntradaPlantilla.setNombre("Deudor_Nombre");
//                camposEntradaPlantilla.setTipo(4);
//                camposEntradaPlantilla.setValor(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCNombres() + " " + findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCApellidos());
//                listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                camposEntradaPlantilla = new CamposEntradaPlantilla();
//                camposEntradaPlantilla.setNombre("Deudor_Identificacion");
//                camposEntradaPlantilla.setTipo(4);
//                camposEntradaPlantilla.setValor(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCIdentificacion());
//                listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                String nombreCodeudor = "";
//                String apellidoCodeudor = "";
//                String IdentCodeudor = "";
//                String sEmailCodeudor = "";
//                String sTelefonoCodeudor = "";
//                String sDireccionCodeudor = "";
//
//                String nombreCodeudor2 = "";
//                String apellidoCodeudor2 = "";
//                String IdentCodeudor2 = "";
//                String sEmailCodeudor2 = "";
//                String sTelefonoCodeudor2 = "";
//                String sDireccionCodeudor2 = "";
//
//                if (findSolicitudPagareByIdUserDeudor.getCRequiereCodeudor().equals("S")) {
//                    nombreCodeudor = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCNombres();
//                    apellidoCodeudor = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCApellidos();
//                    IdentCodeudor = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCIdentificacion();
//                    sEmailCodeudor = new CygnusCoreServiceBean().getEmailPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                    sTelefonoCodeudor = new CygnusCoreServiceBean().getTelPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                    sDireccionCodeudor = new CygnusCoreServiceBean().getDireccionPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(0).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                    if (findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().size() > 1) {
//                        nombreCodeudor2 = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCNombres();
//                        apellidoCodeudor2 = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCApellidos();
//                        IdentCodeudor2 = findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCIdentificacion();
//                        sEmailCodeudor2 = new CygnusCoreServiceBean().getEmailPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                        sTelefonoCodeudor2 = new CygnusCoreServiceBean().getTelPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                        sDireccionCodeudor2 = new CygnusCoreServiceBean().getDireccionPersona(findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getICodigo().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getITipoIdent().toString(), findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().get(1).getIUsuarioCodeudor().getIPersona().getCIdentificacion());
//                    }
//                }
//
//                if (findSolicitudPagareByIdUserDeudor.getCRequiereCodeudor().equals("S")) {
//                    camposEntradaPlantilla = new CamposEntradaPlantilla();
//                    camposEntradaPlantilla.setNombre("Codeudor1_Nombre");
//                    camposEntradaPlantilla.setTipo(4);
//                    camposEntradaPlantilla.setValor(nombreCodeudor + " " + apellidoCodeudor);
//                    listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                    camposEntradaPlantilla = new CamposEntradaPlantilla();
//                    camposEntradaPlantilla.setNombre("Codeudor1_Identificacion");
//                    camposEntradaPlantilla.setTipo(4);
//                    camposEntradaPlantilla.setValor(IdentCodeudor);
//                    listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                    if (findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().size() > 1) {
//                        camposEntradaPlantilla = new CamposEntradaPlantilla();
//                        camposEntradaPlantilla.setNombre("Codeudor2_Nombre");
//                        camposEntradaPlantilla.setTipo(4);
//                        camposEntradaPlantilla.setValor(nombreCodeudor2 + " " + apellidoCodeudor2);
//                        listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//
//                        camposEntradaPlantilla = new CamposEntradaPlantilla();
//                        camposEntradaPlantilla.setNombre("Codeudor2_Identificacion");
//                        camposEntradaPlantilla.setTipo(4);
//                        camposEntradaPlantilla.setValor(IdentCodeudor2);
//                        listCamposEntradaPlantilla.add(camposEntradaPlantilla);
//                    }
//                }
//                camposEntradaPlantilla = null;
//
//                List<Firmas> listFirmas = new ArrayList<>();
//                Firmas firmas = new Firmas();
//
//                firmas.setNombre(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCNombres());
//                firmas.setApellido(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCApellidos());
//                firmas.setIdentificacion(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getCIdentificacion());
//                firmas.setTipoIdentificacionId(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor().getIPersona().getITipoIdent().intValue());
//                firmas.setCorreo(sEmail);
//                firmas.setCelular(sTelefono);
//                firmas.setCiudad("Bucaramanga");
//                firmas.setDireccion(sDireccion);
//                firmas.setLugarObligacion("Bucaramanga");
//                firmas.setTipoInvolucrado(1);
//                firmas.setCampoFirmaPDF("TXT_FIRMA_DEUDOR");
//                listFirmas.add(firmas);
//                firmas = new Firmas();
//
//                if (findSolicitudPagareByIdUserDeudor.getCRequiereCodeudor().equals("S")) {
//                    firmas.setNombre(nombreCodeudor);
//                    firmas.setApellido(apellidoCodeudor);
//                    firmas.setIdentificacion(IdentCodeudor);
//                    firmas.setTipoIdentificacionId(1);
//                    firmas.setCorreo(sEmailCodeudor);
//                    firmas.setCelular(sTelefonoCodeudor);
//                    firmas.setCiudad("Bucaramanga");
//                    firmas.setDireccion(sDireccionCodeudor);
//                    firmas.setLugarObligacion("Bucaramanga");
//                    firmas.setTipoInvolucrado(2);
//                    firmas.setCampoFirmaPDF("TXT_FIRMA_CODEUDOR_1");
//                    listFirmas.add(firmas);
//                    if (findSolicitudPagareByIdUserDeudor.getCodeudorSolicitudPagareList().size() > 1) {
//                        firmas.setNombre(nombreCodeudor2);
//                        firmas.setApellido(apellidoCodeudor2);
//                        firmas.setIdentificacion(IdentCodeudor2);
//                        firmas.setTipoIdentificacionId(1);
//                        firmas.setCorreo(sEmailCodeudor2);
//                        firmas.setCelular(sTelefonoCodeudor2);
//                        firmas.setCiudad("Bucaramanga");
//                        firmas.setDireccion(sDireccionCodeudor2);
//                        firmas.setLugarObligacion("Bucaramanga");
//                        firmas.setTipoInvolucrado(2);
//                        firmas.setCampoFirmaPDF("TXT_FIRMA_CODEUDOR_2");
//                        listFirmas.add(firmas);
//                    }
//                }
//
//                recepcionArchivoPagare.setFirmas(listFirmas);
//
//                listFirmas = null;
//                firmas = null;
//
//                //Se setean los valores en la clase recepcionArchivoPagare para enviar JSON al API  de OlimpiaIT
//                recepcionArchivoPagare.setCamposEntradaPlantilla(listCamposEntradaPlantilla);
//                listCamposEntradaPlantilla = null;
//                String sIdentComercio = new ParametroServiceBean().obtenerParametroPorNombre("IDENT_COMERCIO");
//                recepcionArchivoPagare.setCorreoElectronico(sEmail);
//                recepcionArchivoPagare.setTelefono(sTelefono);
//                recepcionArchivoPagare.setTipoEndoso(2);
//                recepcionArchivoPagare.setTipoPlantilla(1);
//                recepcionArchivoPagare.setNumeroAprobacion(sIdProcesoCliente);
//                recepcionArchivoPagare.setIdentificacionComercio(sIdentComercio);
//
//                //SE GUARDA LA INFORMACIÓN A ENVIAR AL API DE OLIMPIA
//                ProcesoPagareOlimpiait pagareOlimpiait = new ProcesoPagareOlimpiait();
//                pagareOlimpiait.setITipoPagare(new TipoPagare(recepcionArchivoPagare.getTipoPagare().longValue()));
//                pagareOlimpiait.setIIdProceso(new Long(recepcionArchivoPagare.getIdProcesoCliente()));
//                pagareOlimpiait.setBArchivo(recepcionArchivoPagare.getArchivoPagare());
//                pagareOlimpiait.setCCorreo(recepcionArchivoPagare.getCorreoElectronico());
//                pagareOlimpiait.setCTelefono(recepcionArchivoPagare.getTelefono());
//                pagareOlimpiait.setCIdentComercio(recepcionArchivoPagare.getIdentificacionComercio());
//                pagareOlimpiait.setITipoEndoso(new TipoEndosoPagare(recepcionArchivoPagare.getTipoEndoso().longValue()));
//                pagareOlimpiait.setIEstadoConsPagare(new EstadoConsultaPagare(new Long(1)));
//                pagareOlimpiait.setISolicitudPagare(findSolicitudPagareByIdUserDeudor);
//                ProcesoPagareOlimpiait savePagareOlimpiait = new ProcesoPagareServiceBean().saveProcesoPagareOlimpiait(pagareOlimpiait);
//                if (savePagareOlimpiait != null && savePagareOlimpiait.getICodigo() != null) {
//                    if (recepcionArchivoPagare.getCamposEntradaPlantilla() != null && !recepcionArchivoPagare.getCamposEntradaPlantilla().isEmpty()) {
//                        CampoEntradaPagare campoEntradaPagare = new CampoEntradaPagare();
//                        for (CamposEntradaPlantilla cep : recepcionArchivoPagare.getCamposEntradaPlantilla()) {
//                            campoEntradaPagare.setCNombre(cep.getNombre());
//                            campoEntradaPagare.setITipoEntrada(new TipoEntradaPagare(new Long(cep.getTipo())));
//                            campoEntradaPagare.setCValor(cep.getValor());
//                            campoEntradaPagare.setIProcesoPagare(pagareOlimpiait);
//                            new CampoEntradaPagareServiceBean().saveCampoEntradaPagare(campoEntradaPagare);
//                            campoEntradaPagare = new CampoEntradaPagare();
//                        }
//
//                        FirmaProcesoPagare firmaProcesoPagare = new FirmaProcesoPagare();
//                        if (findSolicitudPagareByIdUserDeudor.getCRequiereCodeudor().equals("N")) {
//                            firmaProcesoPagare.setCLugarObligacion(recepcionArchivoPagare.getFirmas().get(0).getLugarObligacion());
//                            firmaProcesoPagare.setCDireccion(recepcionArchivoPagare.getFirmas().get(0).getDireccion());
//                            firmaProcesoPagare.setIUsuarioFirmante(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor());
//                            firmaProcesoPagare.setITipoInvolucrado(new TipoInvolucradoPagare(new Long(recepcionArchivoPagare.getFirmas().get(0).getTipoInvolucrado())));
//                            firmaProcesoPagare.setCCiudad(recepcionArchivoPagare.getFirmas().get(0).getCiudad());
//                            firmaProcesoPagare.setCCelular(recepcionArchivoPagare.getFirmas().get(0).getCelular());
//                            firmaProcesoPagare.setCCorreo(recepcionArchivoPagare.getFirmas().get(0).getCorreo());
//                            firmaProcesoPagare.setIProcesoPagare(pagareOlimpiait);
//                            new FirmaProcesoPagareBean().saveFirmaProcesoPagare(firmaProcesoPagare);
//                            firmaProcesoPagare = new FirmaProcesoPagare();
//                        } else {
//                            for (Firmas recepcionArchivo : recepcionArchivoPagare.getFirmas()) {
//                                firmaProcesoPagare.setCLugarObligacion(recepcionArchivo.getLugarObligacion());
//                                firmaProcesoPagare.setCDireccion(recepcionArchivo.getDireccion());
//                                firmaProcesoPagare.setIUsuarioFirmante(findSolicitudPagareByIdUserDeudor.getIUsuarioDeudor());
//                                firmaProcesoPagare.setITipoInvolucrado(new TipoInvolucradoPagare(new Long(recepcionArchivo.getTipoInvolucrado())));
//                                firmaProcesoPagare.setCCiudad(recepcionArchivo.getCiudad());
//                                firmaProcesoPagare.setCCelular(recepcionArchivo.getCelular());
//                                firmaProcesoPagare.setCCorreo(recepcionArchivo.getCorreo());
//                                firmaProcesoPagare.setIProcesoPagare(pagareOlimpiait);
//                                new FirmaProcesoPagareBean().saveFirmaProcesoPagare(firmaProcesoPagare);
//                                firmaProcesoPagare = new FirmaProcesoPagare();
//                            }
//                        }
//                        ResponseRecepArchivoPagare resRecepArchivoPagare = this.recepcionArchivoPagare(recepcionArchivoPagare);
//                        if (resRecepArchivoPagare.getCodigoRespuestaOtp() != null && resRecepArchivoPagare.getCodigoRespuestaGenPagare() != null) {
//                            if (resRecepArchivoPagare.getCodigoRespuestaOtp() == 0 && resRecepArchivoPagare.getCodigoRespuestaGenPagare() == 0) {
//                                findSolicitudPagareByIdUserDeudor.setFFechaInicioProceso(new Date());
//                                new SolicitudPagareServiceBean().updateSolicitudPagare(findSolicitudPagareByIdUserDeudor);
//                                idProceso = String.valueOf(savePagareOlimpiait.getIIdProceso());
//                                bRta = Boolean.TRUE;
//                                sMsjRta = "Se ha generado el pagare digital de manera correcta, por favor revise su correo electronico o los SMS de su celular.";
//                            } else {
//                                bRta = Boolean.FALSE;
//                                sMsjRta = "Se ha presentado un inconviente al enviar código OTP o al generar el pagare digital. Por favor intente de nuevo";
//                            }
//                        } else {
//                            bRta = Boolean.FALSE;
//                            sMsjRta = "Se ha presentado un inconviente al generar el pagare digital. Por favor intente de nuevo";
//                        }
//                        RespuestaProcesoPagare rtaProcesoPagare = new RespuestaProcesoPagare();
//                        rtaProcesoPagare.setCIdTransaccionOtp(resRecepArchivoPagare.getIdTransaccionOtp());
//                        rtaProcesoPagare.setCIdTransaccionPagare(resRecepArchivoPagare.getIdTransaccionGenPagare());
//                        rtaProcesoPagare.setICodRtaOtp(resRecepArchivoPagare.getCodigoRespuestaOtp().longValue());
//                        rtaProcesoPagare.setICodRtaGenPagare(resRecepArchivoPagare.getCodigoRespuestaGenPagare().longValue());
//                        rtaProcesoPagare.setCDescRtaOtp(resRecepArchivoPagare.getDescripcionRespuestaOtp());
//                        rtaProcesoPagare.setCDescRtaGenPagare(resRecepArchivoPagare.getDescripcionRespuestaGenPagare());
//                        rtaProcesoPagare.setCUrlAcesor(resRecepArchivoPagare.getUrlAcesor());
//                        rtaProcesoPagare.setCSerialPagare(resRecepArchivoPagare.getSerialPagare());
//                        rtaProcesoPagare.setIProcesoPagare(pagareOlimpiait);
//                        new RespuestaProcPagareServiceBean().saveRespuestaProcesoPagare(rtaProcesoPagare);
//                    }
//                } else {
//                    bRta = Boolean.FALSE;
//                    sMsjRta = "Se ha presentado un inconviente en el proceso de generación de pagare digital. Por favor intente de nuevo.";
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                bRta = Boolean.FALSE;
//                sMsjRta = "Se ha presentado un inconveniente al procesar la solicitud de inicio de firma de pagare, por favor intente de nuevo.";
//            }
//        } else {
//            bRta = Boolean.FALSE;
//            sMsjRta = "No cuenta con un proceso de firma pagare digital que se encuentre pendiente por firmar, por favor consulte con la entidad.";
//        }
//        rtaGenerica.setIdProceso(idProceso);
//        rtaGenerica.setbRta(bRta);
//        rtaGenerica.setsMsj(sMsjRta);
//        return rtaGenerica;
//    }

}
