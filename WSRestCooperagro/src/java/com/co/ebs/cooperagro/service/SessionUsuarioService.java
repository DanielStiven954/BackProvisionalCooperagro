/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.SessionUsuario;
import com.co.ebs.cooperagro.domain.TipoCanal;
import com.co.ebs.cooperagro.domain.Usuario;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface SessionUsuarioService {

    SessionUsuario saveSession(Usuario sessionUsu, String xcNavegador, TipoCanal tipoCanal);

    SessionUsuario updateSession(SessionUsuario sessionUsuario);

    SessionUsuario findSessionByUser(Long idUsuario, Long tTipoCanal);

    SessionUsuario findSessionACTByUser(Long idUsuario);
    
    List<SessionUsuario> findListSessionACTByUser(Long idUsuario, Long iTipoCanal);
    
    Boolean updateSessionActByUser(Long idUser, Long iTipoCanal);

}
