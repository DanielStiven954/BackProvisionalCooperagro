package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.request.RequestFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseServirFotoPerfil;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

public interface FotoPerfilService 
{
    /**
     * Método de interface que Actualiza la foto de perfil
     * 
     * @param request 
     * @return respuestaGenerica
     */
    respuestaGenerica actualizarFotoPerfil(RequestFotoPerfil request);
    
    /**
     * Método de interface para obtener la foto de perfil
     * 
     * @param xiTipoIdent tipo de identificación
     * @param xsIdent identificacion
     */
    ResponseServirFotoPerfil obtenerFotoPerfil(int xiTipoIdent, String xsIdent);
    
    /**
     * Método de interface para actualizar a NULL la foto de perfil
     * 
     * @param xiTipoIdent tipo de identificación
     * @param xsIdent identificacion
     */
    respuestaGenerica nulificarFotoPerfil(int xiTipoIdent, String xsIdent);
}