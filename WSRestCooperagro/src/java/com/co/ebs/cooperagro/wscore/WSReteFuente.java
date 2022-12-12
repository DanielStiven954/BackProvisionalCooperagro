/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wscore;

import wsmovimientoscygnus_retefuente.RespuestaCert;
import wsmovimientoscygnus_retefuente.WSMovimientosCygnusRetefuente;
import wsmovimientoscygnus_retefuente.WSMovimientosCygnusRetefuenteSoap;
import com.co.ebs.cooperagro.request.RequestReteFuente;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 *
 * @author YO
 */
public class WSReteFuente {
    
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sURL_WS_Retefuente = parametroServiceBean.obtenerParametroPorNombre("WS_Retefuente");
    
    public RespuestaCert reteFuente(RequestReteFuente requestReteFuente, String psBase, String psUsuario, String psClave) {
        RespuestaCert cert = new RespuestaCert();
        try {
            URL newEndpoint = new URL(sURL_WS_Retefuente);
            QName qname = new QName("WSMovimientosCygnus_retefuente", "WSMovimientosCygnus_Retefuente");
            WSMovimientosCygnusRetefuente cygnusReteFuente = new WSMovimientosCygnusRetefuente(newEndpoint, qname);
            WSMovimientosCygnusRetefuenteSoap cygnusRetefuenteSoap = cygnusReteFuente.getWSMovimientosCygnusRetefuenteSoap();
            cert = cygnusRetefuenteSoap.retefuente(requestReteFuente.getPsIdentificacion(), requestReteFuente.getPsFechaIni(), requestReteFuente.getPsFechaFin(), psBase, psUsuario, psClave);
            
        } catch (Exception e) {
            e.printStackTrace();                      
        }
        return cert;
    }
}
