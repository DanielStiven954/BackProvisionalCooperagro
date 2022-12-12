/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.net.URL;
import javax.xml.namespace.QName;
import java.util.List;
import com.co.ebs.cooperagro.wscore.*;
//import wsAdminCooperagro.*;
import WSAdminCooperagro.ResponseTiposIdent;
import WSAdminCooperagro.*;

/**
 *
 * @author Brian Cardenas
 */
public class wsAdministracion {

    private String sURL_WS_ADMIN_WSDL = new ParametroServiceBean().obtenerParametroPorNombre("WS_ADMIN");

    public ResponseTiposIdent wsTiposIdent() {

        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            wsAdminCooperagro adminCooperagro = new wsAdminCooperagro(newEndpoint, qname);
//            wsAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
            //responseTiposIdent = WSadminCooperagro.wsTIPOSIDENTIFICACIONI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }

    public ResponseTiposIdent wsTiposIdentById(int codigo) {

        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseTiposIdent = adminCooperagroSoap.wsTIPOSIDENTIFICACIONII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }

    public ResponseNivelesEstudio wsTiposNivEstudio() {

        ResponseNivelesEstudio responseNivEstu = new ResponseNivelesEstudio();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
            //responseNivEstu = adminCooperagroSoap.wsTIPOSNIVESTUDIOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseNivEstu;
    }

    public ResponseNivelesEstudio wsTiposNivEstudioByID(int codigo) {

        ResponseNivelesEstudio responseNivEstu = new ResponseNivelesEstudio();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseNivEstu = adminCooperagroSoap.wsTIPOSNIVESTUDIOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseNivEstu;
    }

    public ResponseTipoEstadoCivil wsTiposEstadoCivil() {

        ResponseTipoEstadoCivil response = new ResponseTipoEstadoCivil();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOESTADOCIVILI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoEstadoCivil wsTiposEstadoCivilByID(String codigo) {

        ResponseTipoEstadoCivil response = new ResponseTipoEstadoCivil();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOESTADOCIVILII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseActividadEconomica wsTiposActEcon() {

        ResponseActividadEconomica response = new ResponseActividadEconomica();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOSACTECONOMICAI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseActividadEconomica wsTiposActEconByID(int codigo) {

        ResponseActividadEconomica response = new ResponseActividadEconomica();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOSACTECONOMICAII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoContrato wsTiposContrato() {

        ResponseTipoContrato response = new ResponseTipoContrato();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOCONTRATOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoContrato wsTiposContratoByID(int codigo) {

        ResponseTipoContrato response = new ResponseTipoContrato();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOCONTRATOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoPago wsTipoPago() {

        ResponseTipoPago response = new ResponseTipoPago();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOFORMAPAGOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseTipoPago wsTipoPagoByID(int codigo) {

        ResponseTipoPago response = new ResponseTipoPago();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsTIPOFORMAPAGOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseCiudad wsCiudad() {

        ResponseCiudad response = new ResponseCiudad();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsCIUDADI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion) {

        ResponseCiudad response = new ResponseCiudad();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            response = adminCooperagroSoap.wsCIUDADII(xiCodigo, nombre, nivel, xi_ind_nal, xi_ind_internal, xi_ubicacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public ResponseLineaCredito wsLineaCredito() {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminCooperagroSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseLineaCredito = adminCooperagroSoap.wsLINEASCREDITO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseLineaCredito;
    }

    public ResponseLineaCredito wsLineaCreditoServicio() {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminSomecSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseLineaCredito = adminSomecSoap.wsLINEASSERVICIO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseLineaCredito;
    }

    public ResponsePeriodo wsPeriodos() {

        ResponsePeriodo responsePeriodo = new ResponsePeriodo();

        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminSomecSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responsePeriodo = adminSomecSoap.wsPERIODO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responsePeriodo;
    }
    
    public String codigoCiudad(String nomCiudad,String nivelCiudad){
        String rta ="0";
        ResponseCiudad r = this.wsCiudad();
//        ResponseCiudad r = this.wsCiudadByParam(null, nomCiudad, nivelCiudad, null, null, null);
        if (r.isBRta()) {
            List<CiudadDTO> lista = r.getListCiudades().getCiudadDTO();
            for (CiudadDTO ciudad: lista) {
                if (ciudad.getCNombre().trim().equals(nomCiudad)) {
                    rta=ciudad.getICodigo();
                    break;
                }
            }
        }
        return rta;
    }

    public ResponseCargo wsCARGOSI() {
        ResponseCargo responseCargo = new ResponseCargo();
        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminSomecSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseCargo = adminSomecSoap.wsCARGOSI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseCargo;
    }

    public ResponseProfesion wsPROFESIONESI() {
        ResponseProfesion responseProfesiones = new ResponseProfesion();
        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminSomecSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseProfesiones = adminSomecSoap.wsPROFESIONESI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseProfesiones;
    }

    public ResponseEntidad wsENTIDADESI() {
        ResponseEntidad responseEntidad = new ResponseEntidad();
        try {
            URL newEndpoint = new URL(sURL_WS_ADMIN_WSDL);
            QName qname = new QName("https://ebssas.com/", "WSAdminCooperagro");

//            WSAdminCooperagro adminCooperagro = new WSAdminCooperagro(newEndpoint, qname);
//            WSAdminCooperagroSoap adminSomecSoap = adminCooperagro.getWSAdminCooperagroSoap();
//            responseEntidad = adminSomecSoap.wsENTIDADESI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseEntidad;
    }
    
    
}
