/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SessionUsuario;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface SessionUsuarioDataAccess {

    SessionUsuario saveSession(SessionUsuario sessionUsuario);

    SessionUsuario updateSession(SessionUsuario sessionUsuario);

    SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal);

    SessionUsuario findSessionACTByUser(Long idUsuario);

    List<SessionUsuario> findListSessionACTByUser(Long idUsuario, Long iTipoCanal);

}
