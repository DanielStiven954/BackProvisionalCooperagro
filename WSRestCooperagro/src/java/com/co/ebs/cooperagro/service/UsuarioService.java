/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseOlvidoClave;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Brayan F Silva R
 */
public interface UsuarioService {

    Usuario findUsuarioById(Long id);

    Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent, int TipoPerfil);

    ResponseOlvidoClave validaOlvidoClave(String xsData, Long iTipoCanal);

    respuestaGenerica generarClaveNueva(String xsData);
    
    Usuario findUserByPersonaCodigo(Long codigo, String perfil);
}
