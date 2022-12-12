/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class NotificacionUsuarioDataAccessImp extends WSRestGenericRepositoryJPA<NotificacionUsuario> implements NotificacionUsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public Boolean saveNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        Boolean bRtaSave = Boolean.FALSE;
        NotificacionUsuario saveNotificacionUsuario = create(notificacionUsuario);
        if (saveNotificacionUsuario != null && saveNotificacionUsuario.getICodigo() != null) {
            bRtaSave = Boolean.TRUE;
        }
        return bRtaSave;
    }

    @Override
    public Boolean editNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        Boolean bRtaEdit = Boolean.FALSE;
        NotificacionUsuario editNotificacionUsuario = update(notificacionUsuario);
        if (editNotificacionUsuario != null && editNotificacionUsuario.getICodigo() != null) {
            bRtaEdit = Boolean.TRUE;
        }
        return bRtaEdit;
    }

    @Override
    public void deleteNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        delete(notificacionUsuario);
    }

    @Override
    public List<NotificacionUsuario> findAllNotificaciones() {
        return findAll();
    }

    @Override
    public List<NotificacionUsuario> listNotUsuarioFindByUserActivas(NotificacionUsuario notificacionUsuario) {
        List<NotificacionUsuario> listNotificacionesActivas = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<NotificacionUsuario> query = em.createNamedQuery("NotificacionUsuario.findByUserAndAct", NotificacionUsuario.class);
            query.setParameter("iUsuario", notificacionUsuario.getIUsuario());
            query.setParameter("cEstado", "ACT");
            listNotificacionesActivas = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listNotificacionesActivas;
    }

    @Override
    public List<NotificacionUsuario> listNotUsuarioFindByUser(NotificacionUsuario notificacionUsuario) {
        List<NotificacionUsuario> listNotificacionesActivas = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<NotificacionUsuario> query = em.createNamedQuery("NotificacionUsuario.findByUser", NotificacionUsuario.class);
            query.setParameter("iUsuario", notificacionUsuario.getIUsuario());
            listNotificacionesActivas = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listNotificacionesActivas;
    }

    @Override
    public NotificacionUsuario findNotificacionUsuarioById(Long id) {
        NotificacionUsuario notificacionUsuario = new NotificacionUsuario();
        notificacionUsuario = find(id);
        return notificacionUsuario;
    }

    @Override
    public List<NotificacionUsuario> notificacionesSinLeer(Usuario usuario) {
        List<NotificacionUsuario> listNotificacionesActivas = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<NotificacionUsuario> query = em.createNamedQuery("NotificacionUsuario.findByUserAndAct", NotificacionUsuario.class);
            query.setParameter("iUsuario", usuario);
            query.setParameter("cEstado", "ACT");
            listNotificacionesActivas = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listNotificacionesActivas;
    }

}
