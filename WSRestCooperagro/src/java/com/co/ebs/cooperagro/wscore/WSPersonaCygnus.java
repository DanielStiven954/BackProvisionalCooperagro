/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

import com.co.ebs.cooperagro.respuestasGenericas.PersonaCygnus;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.net.URL;
import javax.xml.namespace.QName;
import wspersonascygnus.RespuestaCrea;
import wspersonascygnus.WSPersonasCygnus;
import wspersonascygnus.WSPersonasCygnusSoap;


/**
 *
 * @author Administrador
 */
public class WSPersonaCygnus {
 
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sURL_WS_PERSONA_CYGNUS_WSDL = parametroServiceBean.obtenerParametroPorNombre("WS_PERSONAS_CYGNUS");

    public String wsCrearPersonaCygnus(PersonaCygnus personaCygnus) {
        String response = "";
                try {
            URL newEndpoint = new URL(sURL_WS_PERSONA_CYGNUS_WSDL);
            QName qname = new QName("WSPersonasCygnus", "WSPersonasCygnus");
            WSPersonasCygnus personasCygnus = new WSPersonasCygnus(newEndpoint, qname);
            WSPersonasCygnusSoap cygnusSoap = personasCygnus.getWSPersonasCygnusSoap();
            response = cygnusSoap.wcCREARPERSONAS(personaCygnus.getpDfnNatCodigo(), personaCygnus.getpWSTipodepersona(),personaCygnus.getpDfsNatCodaso(), personaCygnus.getPwsIdentific(), personaCygnus.getpDfnNatTipcli(), personaCygnus.getpWNTipoiden(), personaCygnus.getpDfnNatLugexp(), personaCygnus.getpWDFecexp(), personaCygnus.getpDfsNatNombres(), personaCygnus.getpDfsNatApellidos(), personaCygnus.getpDfnNatCiunac(), personaCygnus.getpWDFecnac(), personaCygnus.getpCbsNatResAux(), personaCygnus.getpWDFecres(), personaCygnus.getpWSSexo(), personaCygnus.getpSTesoro(), personaCygnus.getpDfsNatEstciv(), personaCygnus.getpDfnNatPercar(), personaCygnus.getpDfsNatCla(), personaCygnus.getpDfsNatClaint(), personaCygnus.getpDfsNatNroact(), personaCygnus.getpDfNatRut(), personaCygnus.getpDfCodOf(), personaCygnus.getpDfnNacionalidad(), personaCygnus.getpDfnNacionalidad2(), personaCygnus.getpDfnNroHijos(), personaCygnus.getpDfsNatApellido1(), personaCygnus.getpDfsNatApellido2(), personaCygnus.getpCmbEstrato(), personaCygnus.getpCbNatMujerFam(), personaCygnus.getpCbOperacionExt(), personaCygnus.getpWSDireccion(), personaCygnus.getpWNCiudad(), personaCygnus.getpWSTelefono(), personaCygnus.getpWSDirecelec(), personaCygnus.getPsIVinculacLab(), personaCygnus.getPsCAsesorCom(), personaCygnus.getPsNSalario(), personaCygnus.getPsINivelEstudio(), personaCygnus.getPsIProfesion(), personaCygnus.getPsICargo(), personaCygnus.getPsITipoCont(), personaCygnus.getPsNModeloScoring(), personaCygnus.getPwsBd(), personaCygnus.getPwsUsu(), personaCygnus.getPwsPsw());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    
    public RespuestaCrea wsCrearRolPersonas(String codigoPer, String fecha, String bd, String user, String pass) {
        RespuestaCrea response = new RespuestaCrea();
                try {
            URL newEndpoint = new URL(sURL_WS_PERSONA_CYGNUS_WSDL);
            QName qname = new QName("WSPersonasCygnus", "WSPersonasCygnus");
            WSPersonasCygnus personasCygnus = new WSPersonasCygnus(newEndpoint, qname);
            WSPersonasCygnusSoap cygnusSoap = personasCygnus.getWSPersonasCygnusSoap();
            response = cygnusSoap.wcCREARROLPERSONAS(codigoPer, "1", "", bd, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    
}
