/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Usuario;

/**
 *
 * @author Brayan F Silva R
 */
public interface UsuarioDataAccess {

     Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    Usuario findUsuarioById(Long id);

    Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent, int TipoPerfil);

    Usuario validaOlvidoClaveForUser(int xiTipoIdent, String xsIdent, int xiTipoPerfil, Long iTipoCanal);
    
    Usuario findUserByPersonaCod(Long codigo, String perfil);

}
