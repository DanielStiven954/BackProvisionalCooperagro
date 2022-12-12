/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestAPIAuth;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseAuthAPI;
import com.co.ebs.cooperagro.security.JwtTokenHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Braya
 */
@Path("Auth")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestAuth {

    @Context
    private UriInfo context;
    private utilidad util;
    private JwtTokenHelper jwtTokenHelper;

    /**
     * Creates a new instance of WSRestAuth
     */
    public WSRestAuth() {
        this.util = new utilidad();
        this.jwtTokenHelper = new JwtTokenHelper();
    }

    @POST
    public ResponseAuthAPI WSAuthenticate(RequestAPIAuth requestAuth) {
        ResponseAuthAPI responseAuth = new ResponseAuthAPI();
        try {
            String user = "API_COOPERAGRO_2020";
            String pass = "19288f02-9779-424b-a6ed-947426005854";
            String sUserDecode = "", sPassDecode = "";
            if (requestAuth != null) {
                if (requestAuth.getsUser() != null && !requestAuth.getsUser().equals("") && requestAuth.getsPass() != null && !requestAuth.getsPass().equals("")) {
                    sUserDecode = util.decodeBase64(requestAuth.getsUser());
                    sPassDecode = util.decodeBase64(requestAuth.getsPass());
                    if (sUserDecode.equals(user) && sPassDecode.equals(pass)) {
                        String token = jwtTokenHelper.issueTokenAuth();
                        responseAuth.setbRta(Boolean.TRUE);
                        responseAuth.setsToken("Bearer" + token);
                        responseAuth.setsMsg("Se ha generado el token correctamente");
                    } else {
                        responseAuth.setbRta(Boolean.FALSE);
                        responseAuth.setsMsg("Datos incorrectos!");
                    }
                } else {
                    responseAuth.setbRta(Boolean.FALSE);
                    responseAuth.setsMsg("Sin datos para validar.");
                }
            } else {
                responseAuth.setbRta(Boolean.FALSE);
                responseAuth.setsMsg("Sin datos para validar.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseAuth.setbRta(Boolean.FALSE);
            responseAuth.setsMsg("Se ha presentado un inconveniente al generar el token.");
        }
        return responseAuth;
    }
}
