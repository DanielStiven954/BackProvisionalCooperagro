/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.SessionUsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.SessionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.domain.TipoCanal;
import com.co.ebs.cooperagro.general.utilidad;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Ruge
 */
public class SessionUsuarioServiceBean implements SessionUsuarioService {

    private SessionUsuarioDataAccessImp session = new SessionUsuarioDataAccessImp();
    private utilidad util = new utilidad();

    @Override
    public SessionUsuario saveSession(Usuario sessionUsu, String xcNavegador, TipoCanal tipoCanal) {
        SessionUsuario sessionUsuario = new SessionUsuario();
        try {
            sessionUsuario.setCEstado("ACT");
            sessionUsuario.setCIp(util.getIp());
            sessionUsuario.setCHost(util.getHost());
            sessionUsuario.setFConexion(new Date());
            sessionUsuario.setCNavegador(xcNavegador);
            sessionUsuario.setIUsuario(sessionUsu);
            sessionUsuario.setITipoCanal(tipoCanal);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SessionUsuarioServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return session.saveSession(sessionUsuario);
    }

    @Override
    public SessionUsuario updateSession(SessionUsuario sessionUsuario) {
        return session.updateSession(sessionUsuario);
    }

    @Override
    public SessionUsuario findSessionByUser(Long idUsuario, Long tTipoCanal) {
        return session.findSessionByUser(idUsuario, tTipoCanal);
    }

    @Override
    public SessionUsuario findSessionACTByUser(Long idUsuario) {
        return session.findSessionACTByUser(idUsuario);
    }

    @Override
    public List<SessionUsuario> findListSessionACTByUser(Long idUsuario, Long iTipoCanal) {
        return session.findListSessionACTByUser(idUsuario, iTipoCanal);
    }

    @Override
    public Boolean updateSessionActByUser(Long idUser, Long iTipoCanal) {
        Boolean bRta = Boolean.FALSE;
        try {
            List<SessionUsuario> listSessionUsuarioAct = this.findListSessionACTByUser(idUser, iTipoCanal);
            if (listSessionUsuarioAct != null && !listSessionUsuarioAct.isEmpty()) {
                for (SessionUsuario sessionUsuario : listSessionUsuarioAct) {
                    sessionUsuario.setCEstado("INA");
                    SessionUsuario updateSessionUsuario = this.updateSession(sessionUsuario);
                    if (updateSessionUsuario.getCEstado().equals("INA")) {
                        bRta = Boolean.TRUE;
                    }
                }
            } else {
                bRta = Boolean.TRUE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            bRta = Boolean.TRUE;
        }
        return bRta;
    }
}
