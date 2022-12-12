package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.request.RequestFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseServirFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.FotoPerfilServiceBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("WSRestAPI")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestFotoPerfil 
{
    @POST
    @Path("recibirFotoPerfil")
    public respuestaGenerica recibirFotoPerfil(RequestFotoPerfil body) {
        return (new FotoPerfilServiceBean()).actualizarFotoPerfil(body);
    }
    
    @POST
    @Path("servirFotoPerfil")
    public ResponseServirFotoPerfil servirFotoPerfil(@QueryParam("xiTipoIdent") String xiTipoIdent, @QueryParam("xsIdent") String xsIdent) {

        ResponseServirFotoPerfil resultado = new ResponseServirFotoPerfil();
        
        int tipoIdent = 0;
        try { tipoIdent = Integer.parseInt(xiTipoIdent); }
        catch(NumberFormatException ex) {
            resultado.setbRta(Boolean.FALSE);
            resultado.setsMsj("Error: el parametro xiTipoIdent debe ser un número!");
        }
        
        resultado = (new FotoPerfilServiceBean()).obtenerFotoPerfil(tipoIdent, xsIdent);
        return resultado;
    }
    
    @POST
    @Path("nulificarFotoPerfil")
    public respuestaGenerica nulificarFotoPerfil(@QueryParam("xiTipoIdent") String xiTipoIdent, @QueryParam("xsIdent") String xsIdent) {

        respuestaGenerica resultado = new respuestaGenerica();
        
        int tipoIdent = 0;
        try { tipoIdent = Integer.parseInt(xiTipoIdent); }
        catch(NumberFormatException ex) {
            resultado.setbRta(Boolean.FALSE);
            resultado.setsMsj("Error: el parametro xiTipoIdent debe ser un número!");
        }
        
        resultado = (new FotoPerfilServiceBean()).nulificarFotoPerfil(tipoIdent, xsIdent);
        return resultado;
    }
}
