/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.google.gson.Gson;
import java.util.HashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan F Silva R
 */
@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestParametros {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestParametros
     */
    public WSRestParametros() {
    }

    @POST
    @Path("paramRegistroPrimerClave")
    public String getParametrosRegistroPrimeraClave() {
        String sRtaJSON = "";
        HashMap<String, Object> hashMapParametros = new HashMap<>();
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        String sMinPrimeraClave = "", sMaxPrimerClave = "", sCantDigRegUsu = "", sPasswordAlfanumerica = "";
        sMinPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("MIN_PRIMER_PASSWORD");
        sMaxPrimerClave = parametroServiceBean.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
        sCantDigRegUsu = parametroServiceBean.obtenerParametroPorNombre("CANT_DIG_REG_USU");
        sPasswordAlfanumerica = parametroServiceBean.obtenerParametroPorNombre("PASSWORD_ALPHANUMERICO");
        Boolean passwordAlfanumerico = sPasswordAlfanumerica.toLowerCase().equals("si") ? Boolean.TRUE : Boolean.FALSE;
        hashMapParametros.put("sMinPrimerPassword", Integer.parseInt(sMinPrimeraClave));
        hashMapParametros.put("sMaxPrimerPassword", Integer.parseInt(sMaxPrimerClave));
        hashMapParametros.put("sCantDigRegUsu", Integer.parseInt(sCantDigRegUsu));
        hashMapParametros.put("passwordAlfanumerico", passwordAlfanumerico);
        hashMapParametros.put("bRtaConsulta", Boolean.TRUE);
        sRtaJSON = new Gson().toJson(hashMapParametros);
        return sRtaJSON;
    }

    @POST
    @Path("paramLogin")
    public String getParametrosLogin() {
        String sRtaJSON = "";
        HashMap<String, Object> hashMapParametros = new HashMap<>();
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        String sMinPrimeraClave = "", sMaxPrimerClave = "", sPasswordAlfanumerica = "";
        sMinPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("MIN_PRIMER_PASSWORD");
        sMaxPrimerClave = parametroServiceBean.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
        sPasswordAlfanumerica = parametroServiceBean.obtenerParametroPorNombre("PASSWORD_ALPHANUMERICO");
        Boolean passwordAlfanumerico = sPasswordAlfanumerica.toLowerCase().equals("si") ? Boolean.TRUE : Boolean.FALSE;
        hashMapParametros.put("sMinPrimerPassword", Integer.parseInt(sMinPrimeraClave));
        hashMapParametros.put("sMaxPrimerPassword", Integer.parseInt(sMaxPrimerClave));
        hashMapParametros.put("passwordAlfanumerico", passwordAlfanumerico);
        hashMapParametros.put("bRtaConsulta", Boolean.TRUE);
        sRtaJSON = new Gson().toJson(hashMapParametros);
        return sRtaJSON;
    }
}
