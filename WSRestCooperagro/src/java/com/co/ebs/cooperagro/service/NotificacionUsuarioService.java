/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseNotificacionUsuario;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface NotificacionUsuarioService {
    Boolean saveNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    Boolean editNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    void deleteNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    List<NotificacionUsuario> findAllNotificaciones();

    ResponseNotificacionUsuario listNotUsuarioFindByUser(Long codUsuario);

    NotificacionUsuario findNotificacionUsuarioById(Long id);
    
    int notificacionesSinLeer(Usuario usuario);
}
