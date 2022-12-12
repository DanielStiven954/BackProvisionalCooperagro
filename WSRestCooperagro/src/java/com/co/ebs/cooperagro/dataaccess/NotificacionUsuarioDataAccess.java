/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface NotificacionUsuarioDataAccess {

    Boolean saveNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    Boolean editNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    void deleteNotificacionUsuario(NotificacionUsuario notificacionUsuario);

    List<NotificacionUsuario> findAllNotificaciones();

    List<NotificacionUsuario> listNotUsuarioFindByUserActivas(NotificacionUsuario notificacionUsuario);

    NotificacionUsuario findNotificacionUsuarioById(Long id);

    List<NotificacionUsuario> listNotUsuarioFindByUser(NotificacionUsuario notificacionUsuario);

    List<NotificacionUsuario> notificacionesSinLeer(Usuario usuario);
}
