/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Brayan F Silva R
 */
public interface RegistroNuevoUsuarioDataAccess {
    
    respuestaGenerica realizarRegistroNuevoUsuario(Persona persona, String sClave, String sLlaveSeg, int iTipoPerfil, int iTipoCanal);
}
