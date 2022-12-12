/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseNotificacionUsuario;
import com.co.ebs.cooperagro.service.NotificacionUsuarioServiceBean;
import com.co.ebs.cooperagro.service.UsuarioServiceBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import com.co.ebs.cooperagro.request.RequestConsultaPersona;

/**
 *
 * @author Jonathan Ruge
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestNotificacion {

    @Context
    private UriInfo context;

    @POST
    @Path("WSRestNotificacion/getNotificacionByCodUser")
    public ResponseNotificacionUsuario getNotificacionByCodUser(RequestConsultaPersona requestConsultaPersona) {
        NotificacionUsuarioServiceBean notUsuServBean = new NotificacionUsuarioServiceBean();
        UsuarioServiceBean usuServBean = new UsuarioServiceBean();
        Usuario usuario = usuServBean.findUserByPersonaIdent(requestConsultaPersona);
        return notUsuServBean.listNotUsuarioFindByUser(usuario.getICodigo());
    }

    @POST
    @Path("WSRestNotificacion/notificacionLeida")
    public ResponseNotificacionUsuario notificacionLeida(@QueryParam("xiCodNotifica") String codNotificacion) {
        ResponseNotificacionUsuario respuestaNot = new ResponseNotificacionUsuario();
        NotificacionUsuarioServiceBean notUsuServBean = new NotificacionUsuarioServiceBean();
        NotificacionUsuario notificacionAleer = notUsuServBean.findNotificacionUsuarioById(Long.parseLong(codNotificacion));
        notificacionAleer.setCEstado("INA");
        boolean actualizar = notUsuServBean.editNotificacionUsuario(notificacionAleer);
        if (actualizar == true) {
            respuestaNot.setiCodigo(1);
            respuestaNot.setbRta(true);
            respuestaNot.setsMsj("El mensaje ha sido leido corectamente");
        } else {
            respuestaNot.setiCodigo(0);
            respuestaNot.setbRta(false);
            respuestaNot.setsMsj("El mensaje no pudo ser leido");
        }
        return respuestaNot;
    }

}
