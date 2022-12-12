/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.domain.TipoAutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.TipoCuentaSolAfilWeb;
import com.co.ebs.cooperagro.domain.TipoRequisitoSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseListaCadena;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.ExtractosAsociadoBean;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.co.ebs.cooperagro.service.TipoAutorizacionSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.TipoCuentaSolAfilWebServiceBean;
import com.co.ebs.cooperagro.service.TipoRequisitoSolAfilWebServiceBean;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Brayan F Silva R
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestCargaDatos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestCargaDatos
     */
    public WSRestCargaDatos() {
    }

    @POST
    @Path("WSCargaDatos/tipoReSolAfilWeb")
    public List<TipoRequisitoSolAfilWeb> obtenerTipoRequisitosSolAfilWeb() {
        TipoRequisitoSolAfilWebServiceBean tipoReqSolAfilWebServiceBean = new TipoRequisitoSolAfilWebServiceBean();
        return tipoReqSolAfilWebServiceBean.tipoRequisitoSolAfilFindAll();
    }
    
    @GET
    @Path("WSCargaDatos/tipoAutoSolAfilWeb")
    public List<TipoAutorizacionSolAfilWeb> obtenerTiposAutorizacionesSolAfilWeb(){
        return new TipoAutorizacionSolAfilWebServiceBean().findAllTipoAutorizacionSolAfilWeb();
    }
    
    @GET
    @Path("WSCargaDatos/tipoCuentaSolAfilWeb")
    public List<TipoCuentaSolAfilWeb> obtenerTiposCuentaSolAfilWeb(){
        return new TipoCuentaSolAfilWebServiceBean().findAllTipoCuenta();
    }
    
    @GET
    @Path("WSCargaDatos/tipoArcPerSolAfilWeb")
    public respuestaGenerica obtenerTiposArchivos(){
        
        respuestaGenerica generica = new respuestaGenerica();
        
        String tipos = new ParametroServiceBean().obtenerParametroPorNombre("TIPOS_ARC_PER_SOL_AFIL_WEB").replaceAll("\\.", "");
        if(!"".equals(tipos)){
            generica.setbRta(Boolean.TRUE);
            generica.setsMsj(tipos);
        }else{
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("No se pudo cargar los tipos de archivos permitidos");
        }
        
        return generica;
    }
    
    @GET
    @Path("WSCargaDatos/mesesExtractos")
    public ResponseListaCadena obtenerMesesExtractos(){
        return  new ExtractosAsociadoBean().obtenerMesesExtractos();
    }
}
