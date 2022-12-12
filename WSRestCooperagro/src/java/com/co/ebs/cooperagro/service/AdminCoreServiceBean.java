package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.wscore.*;
import WSAdminCooperagro.*;
import WSAdminCooperagro.ResponseTiposIdent;
//import wsAdminCooperagro.*;
import WSAdminCooperagro.WSTIPOSNIVESTUDIOI;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public class AdminCoreServiceBean implements AdminCoreService {

    private final wsAdministracion wsAdminCore;

    public AdminCoreServiceBean() {
        this.wsAdminCore = new wsAdministracion();
    }

    @Override
    public ResponseTiposIdent wsTiposIdent() {
        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();
        try {
            responseTiposIdent = wsAdminCore.wsTiposIdent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("response " + responseTiposIdent);
        return responseTiposIdent;
    }

    public ResponseTiposIdent wsTiposIdentHabilitados() {
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        ResponseTiposIdent tiposIdentHabilitadas = new ResponseTiposIdent();
        ArrayOfTipoIdentificacionDTO arrayOfTipoIdentificacionDTO = new ArrayOfTipoIdentificacionDTO();
        try {
            String sTiposIdentHabParam = parametroServiceBean.obtenerParametroPorNombre("TIPOS_IDEN_HABILES");
            if (sTiposIdentHabParam != null && !sTiposIdentHabParam.equals("")) {
                String sSplitTiposIdentHab[] = sTiposIdentHabParam.split(",");
                
                
                
                if (sSplitTiposIdentHab != null && sSplitTiposIdentHab.length > 0) {
                    for (int i = 0; i < sSplitTiposIdentHab.length; i++) {
                        String sCodTipoIden = sSplitTiposIdentHab[i];
                        System.out.println("sCodTipoIden" + sCodTipoIden);
                        
                        ResponseTiposIdent responseTiposIdent = this.wsTiposIdentByID(Integer.parseInt(sCodTipoIden));
                        if (responseTiposIdent != null && responseTiposIdent.isBRta()) {
                            List<TipoIdentificacionDTO> lstTipoIdent = responseTiposIdent.getLstTiposIdent().getTipoIdentificacionDTO();
                            if (lstTipoIdent != null && !lstTipoIdent.isEmpty()) {
                                for (TipoIdentificacionDTO tipoIdentificacionDTO : lstTipoIdent) {
                                    if (String.valueOf(tipoIdentificacionDTO.getICodigo()).equals(sCodTipoIden)) {
                                        arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().add(tipoIdentificacionDTO);
                                    }
                                }
                            }
                        }
                    }
                    
                    
                    
                    if (arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().isEmpty()) {
                        tiposIdentHabilitadas.setBRta(true);
                        tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente. WS " + sTiposIdentHabParam);
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    } else {
                        tiposIdentHabilitadas.setBRta(true);
                        tiposIdentHabilitadas.setSMsjConsulta("Los datos de la periodicidad fueron cargadas correctamente.");
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            tiposIdentHabilitadas.setBRta(false);
            tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente.");
            tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
        }

        return tiposIdentHabilitadas;
    }
    
    public ResponseTiposIdent wsTiposIdentHabilitadosSolAfil() {
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        ResponseTiposIdent tiposIdentHabilitadas = new ResponseTiposIdent();
        ArrayOfTipoIdentificacionDTO arrayOfTipoIdentificacionDTO = new ArrayOfTipoIdentificacionDTO();
        try {
            String sTiposIdentHabParam = parametroServiceBean.obtenerParametroPorNombre("TIPOS_IDEN_HABILES_SOL_AFIL");
            if (sTiposIdentHabParam != null && !sTiposIdentHabParam.equals("")) {
                String sSplitTiposIdentHab[] = sTiposIdentHabParam.split(",");
                if (sSplitTiposIdentHab != null && sSplitTiposIdentHab.length > 0) {
                    for (int i = 0; i < sSplitTiposIdentHab.length; i++) {
                        String sCodTipoIden = sSplitTiposIdentHab[i];
                        ResponseTiposIdent responseTiposIdent = this.wsTiposIdentByID(Integer.parseInt(sCodTipoIden));
                        if (responseTiposIdent != null && responseTiposIdent.isBRta()) {
                            List<TipoIdentificacionDTO> lstTipoIdent = responseTiposIdent.getLstTiposIdent().getTipoIdentificacionDTO();
                            if (lstTipoIdent != null && !lstTipoIdent.isEmpty()) {
                                for (TipoIdentificacionDTO tipoIdentificacionDTO : lstTipoIdent) {
                                    if (String.valueOf(tipoIdentificacionDTO.getICodigo()).equals(sCodTipoIden)) {
                                        arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().add(tipoIdentificacionDTO);
                                    }
                                }
                            }
                        }
                    }
                    if (arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().isEmpty()) {
                        tiposIdentHabilitadas.setBRta(true);
                        tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente. WS " + sTiposIdentHabParam);
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    } else {
                        tiposIdentHabilitadas.setBRta(true);
                        tiposIdentHabilitadas.setSMsjConsulta("Los datos de la periodicidad fueron cargadas correctamente.");
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            tiposIdentHabilitadas.setBRta(false);
            tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente.");
            tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
        }

        return tiposIdentHabilitadas;
    }

    public ResponseTiposIdent wsTiposIdentByID(int codigo) {
        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();
        try {
            responseTiposIdent = wsAdminCore.wsTiposIdentById(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }

    public ResponseNivelesEstudio wsTiposNivEstudio() {
        ResponseNivelesEstudio response = new ResponseNivelesEstudio();
        try {
            response = wsAdminCore.wsTiposNivEstudio();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseNivelesEstudio wsTiposNivEstudioById(int codigo) {
        ResponseNivelesEstudio response = new ResponseNivelesEstudio();
        try {
            response = wsAdminCore.wsTiposNivEstudioByID(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoEstadoCivil wsTipoEstadoCivil() {
        ResponseTipoEstadoCivil response = new ResponseTipoEstadoCivil();
        try {
            response = wsAdminCore.wsTiposEstadoCivil();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoEstadoCivil wsTipoEstadoCivilByID(String codigo) {
        ResponseTipoEstadoCivil response = new ResponseTipoEstadoCivil();
        try {
            response = wsAdminCore.wsTiposEstadoCivilByID(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseActividadEconomica wsTipoActEco() {
        ResponseActividadEconomica response = new ResponseActividadEconomica();
        try {
            response = wsAdminCore.wsTiposActEcon();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseActividadEconomica wsTipoActEcoByID(int codigo) {
        ResponseActividadEconomica response = new ResponseActividadEconomica();
        try {
            response = wsAdminCore.wsTiposActEconByID(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoContrato wsTipoContrato() {
        ResponseTipoContrato response = new ResponseTipoContrato();
        try {
            response = wsAdminCore.wsTiposContrato();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoContrato wsTipoContratoByID(int codigo) {
        ResponseTipoContrato response = new ResponseTipoContrato();
        try {
            response = wsAdminCore.wsTiposContratoByID(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoPago wsTipoPagoByID() {
        ResponseTipoPago response = new ResponseTipoPago();
        try {
            response = wsAdminCore.wsTipoPago();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoPago wsTipoPagoByID(int codigo) {
        ResponseTipoPago response = new ResponseTipoPago();
        try {
            response = wsAdminCore.wsTipoPagoByID(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseCiudad wsCiudad() {
        ResponseCiudad response = new ResponseCiudad();
        try {
            response = wsAdminCore.wsCiudad();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion) {
        ResponseCiudad response = new ResponseCiudad();
        try {
            response = wsAdminCore.wsCiudadByParam(xiCodigo, nombre, nivel, xi_ind_nal, xi_ind_internal, xi_ubicacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponsePeriodo wsPeriodos() {
        return wsAdminCore.wsPeriodos();
    }

    
    public ResponsePeriodo obtenerPeriodicidadHabilitadasSolCred() {
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        ResponsePeriodo responsePeriodo = wsAdminCore.wsPeriodos();
        ResponsePeriodo periodicidadHabilitadas = new ResponsePeriodo();
        if (responsePeriodo != null && responsePeriodo.isBRta()) {
            String sPeriodicidadHabParam = parametroServiceBean.obtenerParametroPorNombre("PERIODICIDAD_HAB_SOL_CRED");
            if (sPeriodicidadHabParam != null && !sPeriodicidadHabParam.equals("")) {
                String sSplitPerHab[] = sPeriodicidadHabParam.split(",");
                if (sSplitPerHab != null && sSplitPerHab.length > 0) {
                    ArrayOfPeriodoDTO arrayOfPeriodoDTO = new ArrayOfPeriodoDTO();
                    for (int i = 0; i < sSplitPerHab.length; i++) {
                        PeriodoDTO periodoDTO = null;
                        periodoDTO = responsePeriodo.getListPerido().getPeriodoDTO().get(i);
                        if (String.valueOf(periodoDTO.getICodigo()).equals(sSplitPerHab[i])) {
                            arrayOfPeriodoDTO.getPeriodoDTO().add(periodoDTO);
                            periodoDTO = new PeriodoDTO();
                        }
                    }
                    periodicidadHabilitadas.setBRta(true);
                    periodicidadHabilitadas.setSMsj("Los datos de la periodicidad fueron cargadas correctamente.");
                    periodicidadHabilitadas.setListPerido(arrayOfPeriodoDTO);
                }
            }
        }
        return periodicidadHabilitadas;
    }

//    @Override
//    public ResponseEntidad obtenerEntidadesBancarias() {
//        return wsAdminCore.wsEntidadesI();
//    }
    @Override
    public ResponseLineaCredito wsLineaCredito() {
        ParametroServiceBean paramDao = new ParametroServiceBean();
        ResponseLineaCredito responseLinea = wsAdminCore.wsLineaCredito();
        ResponseLineaCredito lineasCreditoHabiles = new ResponseLineaCredito();
        if (responseLinea != null && responseLinea.isBRta()) {
            String sPeriodicidadHabParam = paramDao.obtenerParametroPorNombre("LINEA_CREDITO_HABILITADA");
            if (sPeriodicidadHabParam != null && !sPeriodicidadHabParam.equals("")) {
                String sSplitPerHab[] = sPeriodicidadHabParam.split(",");
                if (sSplitPerHab != null && sSplitPerHab.length > 0) {
                    ArrayOfLineaCreditoDTO arrayOfPeriodoDTO = new ArrayOfLineaCreditoDTO();
                    for (int i = 0; i < sSplitPerHab.length; i++) {
//                        LineaCreditoDTO lineasCreditoDto = null;
                        List<LineaCreditoDTO> lineasCreditoDto = responseLinea.getListLineaCredito().getLineaCreditoDTO();
                        for (LineaCreditoDTO lineaCreditoDTO : lineasCreditoDto) {
                            if (String.valueOf(lineaCreditoDTO.getICodigo()).equals(sSplitPerHab[i])) {
                                arrayOfPeriodoDTO.getLineaCreditoDTO().add(lineaCreditoDTO);
                            }
                        }

                    }
                    lineasCreditoHabiles.setBRta(true);
                    lineasCreditoHabiles.setSMsj("Los datos de las lineas de crédito fueron cargadas correctamente.");
                    lineasCreditoHabiles.setListLineaCredito(arrayOfPeriodoDTO);
                }
            }
        }
        return lineasCreditoHabiles;
    }

    
    public ResponseLineaCredito findLineaCreditoById(Long codigo) {
        ResponseLineaCredito responseLineaCredito = wsAdminCore.wsLineaCredito();
        if (responseLineaCredito.isBRta()) {
            ArrayOfLineaCreditoDTO arrayOfLineaCreditoDTO = responseLineaCredito.getListLineaCredito();
            if (arrayOfLineaCreditoDTO != null) {
                if (arrayOfLineaCreditoDTO.getLineaCreditoDTO() != null && !arrayOfLineaCreditoDTO.getLineaCreditoDTO().isEmpty()) {
                    List<LineaCreditoDTO> listLineaCredito = arrayOfLineaCreditoDTO.getLineaCreditoDTO();
                    listLineaCredito.removeIf(lc -> (lc.getICodigo() != codigo));
                    arrayOfLineaCreditoDTO.getLineaCreditoDTO().clear();
                    arrayOfLineaCreditoDTO.getLineaCreditoDTO().addAll(listLineaCredito);
                }
            } else {
                responseLineaCredito.setBRta(false);
            }
        }
        return responseLineaCredito;
    }
    
    public LineaCreditoDTO findLineaCreditoByCodigo(Long codigo) {
        LineaCreditoDTO lineaCreditoDTO = new LineaCreditoDTO();
        ResponseLineaCredito responseLineaCredito = wsAdminCore.wsLineaCredito();
        if (responseLineaCredito.isBRta()) {
            ArrayOfLineaCreditoDTO arrayOfLineaCreditoDTO = responseLineaCredito.getListLineaCredito();
            if (arrayOfLineaCreditoDTO != null) {
                if (arrayOfLineaCreditoDTO.getLineaCreditoDTO() != null && !arrayOfLineaCreditoDTO.getLineaCreditoDTO().isEmpty()) {
                    List<LineaCreditoDTO> listLineaCredito = arrayOfLineaCreditoDTO.getLineaCreditoDTO();
                    for(LineaCreditoDTO linea : listLineaCredito){
                        if(linea.getICodigo() == codigo){
                            lineaCreditoDTO = linea;
                        }
                    }
                }
            } else {
                responseLineaCredito.setBRta(false);
            }
        }
        return lineaCreditoDTO;
    }

    public ResponseLineaCredito wsLineaCreditoServicio() {
        ParametroServiceBean paramDao = new ParametroServiceBean();
        ResponseLineaCredito responseLinea = wsAdminCore.wsLineaCreditoServicio();
        ResponseLineaCredito lineasCreditoHabiles = new ResponseLineaCredito();
        if (responseLinea != null && responseLinea.isBRta()) {
            String sPeriodicidadHabParam = paramDao.obtenerParametroPorNombre("LINEA_CREDITO_SERVICIO_HABILITADA");
            if (sPeriodicidadHabParam != null && !sPeriodicidadHabParam.equals("")) {
                String sSplitPerHab[] = sPeriodicidadHabParam.split(",");
                if (sSplitPerHab != null && sSplitPerHab.length > 0) {
                    ArrayOfLineaCreditoDTO arrayOfPeriodoDTO = new ArrayOfLineaCreditoDTO();
                    for (int i = 0; i < sSplitPerHab.length; i++) {
//                        LineaCreditoDTO lineasCreditoDto = null;
                        List<LineaCreditoDTO> lineasCreditoDto = responseLinea.getListLineaCredito().getLineaCreditoDTO();
                        for (LineaCreditoDTO lineaCreditoDTO : lineasCreditoDto) {
                            if (String.valueOf(lineaCreditoDTO.getICodigo()).equals(sSplitPerHab[i])) {
                                arrayOfPeriodoDTO.getLineaCreditoDTO().add(lineaCreditoDTO);
                            }
                        }

                    }
                    lineasCreditoHabiles.setBRta(true);
                    lineasCreditoHabiles.setSMsj("Los datos de las lineas de crédito fueron cargadas correctamente.");
                    lineasCreditoHabiles.setListLineaCredito(arrayOfPeriodoDTO);
                }
            }
        }
        return lineasCreditoHabiles;
    }

    public ResponseLineaCredito findLineaCreditoServicioById(Long codigo) {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();
        responseLineaCredito = this.wsLineaCreditoServicio();
        if (responseLineaCredito.isBRta()) {
            if (responseLineaCredito.getListLineaCredito().getLineaCreditoDTO() != null && !responseLineaCredito.getListLineaCredito().getLineaCreditoDTO().isEmpty()) {
                responseLineaCredito.getListLineaCredito().getLineaCreditoDTO().removeIf(lc -> (lc.getICodigo() != codigo));
            }
        }
        return responseLineaCredito;
    }

    
    public ResponsePeriodo findPeriodoById(Long codigo) {
        ResponsePeriodo responsePeriodo = new ResponsePeriodo();
        responsePeriodo = this.wsPeriodos();
        if (responsePeriodo.isBRta()) {
            if (responsePeriodo.getListPerido().getPeriodoDTO() != null && !responsePeriodo.getListPerido().getPeriodoDTO().isEmpty()) {
                responsePeriodo.getListPerido().getPeriodoDTO().removeIf(p -> (p.getICodigo() != codigo));
            }
        }
        return responsePeriodo;
    }

    @Override
    public String getNombreLineaCredito(Long lCodigo) {
        String sDescLin = "";
        ResponseLineaCredito responseLineaCredito = this.findLineaCreditoById(lCodigo);
        if (responseLineaCredito != null && responseLineaCredito.isBRta()) {
            if (responseLineaCredito.getListLineaCredito().getLineaCreditoDTO() != null && !responseLineaCredito.getListLineaCredito().getLineaCreditoDTO().isEmpty()) {
                sDescLin = responseLineaCredito.getListLineaCredito().getLineaCreditoDTO().get(0).getSDescripcion();
            } else {
                sDescLin = "";
            }
        }
        return sDescLin;
    }
    
    public String getNombreLineaCreditoByCodigo(Long lCodigo) {
        String sDescLin = "";
        LineaCreditoDTO responseLineaCredito = this.findLineaCreditoByCodigo(lCodigo);
        if (responseLineaCredito != null) {
            sDescLin = responseLineaCredito.getSDescripcion();
        }
        return sDescLin;
    }

    @Override
    public String getDescPeriodo(Long lcodigo) {
        String sDescPeriodo = "";
        ResponsePeriodo responsePeriodo = this.findPeriodoById(lcodigo);
        if (responsePeriodo != null && responsePeriodo.isBRta()) {
            sDescPeriodo = responsePeriodo.getListPerido().getPeriodoDTO().get(0).getSDescripcion();
        }
        return sDescPeriodo;
    }

    @Override
    public ResponseEntidad wsEntidades() {
        ResponseEntidad response = new ResponseEntidad();
        try {
            response = wsAdminCore.wsENTIDADESI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseProfesion wsProfesiones() {
        ResponseProfesion response = new ResponseProfesion();
        try {
            response = wsAdminCore.wsPROFESIONESI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseCargo wsCargos() {
        ResponseCargo response = new ResponseCargo();
        try {
            response = wsAdminCore.wsCARGOSI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

}
