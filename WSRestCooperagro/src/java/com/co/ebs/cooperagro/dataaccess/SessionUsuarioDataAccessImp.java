/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SessionUsuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Jonathan Ruge
 */
public class SessionUsuarioDataAccessImp extends WSRestGenericRepositoryJPA<SessionUsuario> implements SessionUsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public SessionUsuario saveSession(SessionUsuario sessionUsuario) {
        SessionUsuario createSession = create(sessionUsuario);
        return createSession;
    }

    @Override
    public SessionUsuario updateSession(SessionUsuario sessionUsuario) {
        SessionUsuario updateSession = update(sessionUsuario);
        return updateSession;
    }

    public SessionUsuario buscarSessionByCodUser(Long idUsuario) {
        SessionUsuario ultimaSession = new SessionUsuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT s.* FROM SESSION_USUARIO s WHERE I_USUARIO=? ORDER BY F_CONEXION DESC", SessionUsuario.class);

            consultDocument.setParameter(1, idUsuario);

            List<SessionUsuario> listSession = consultDocument.getResultList();
            if (listSession != null && !listSession.isEmpty()) {
                ultimaSession = listSession.get(0);
            } else {
                ultimaSession = null;
            }
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
        return ultimaSession;
    }

    @Override
    public SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal) {
        SessionUsuario ultimaSession = new SessionUsuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_CONSULTA.PRC_CONS_ULTIMA_SESSION");
            storedProcedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(5, SessionUsuario.class, ParameterMode.REF_CURSOR);

            storedProcedureQuery.setParameter(1, Integer.parseInt(String.valueOf(idUsuario)));
            storedProcedureQuery.setParameter(2, Integer.parseInt(String.valueOf(iTipoCanal)));
            boolean execute = storedProcedureQuery.execute();
            if (execute) {
                if (storedProcedureQuery.getOutputParameterValue(4).toString().equals("TRUE")) {
                    List listaSesiones = storedProcedureQuery.getResultList();
                    if (listaSesiones.size() > 0) {
                        Object[] sesionFinal = (Object[]) listaSesiones.get(0);
                        Long codigoS = Long.parseLong(String.valueOf(sesionFinal[0]));
                        String ip = String.valueOf(sesionFinal[2]);
                        String host = String.valueOf(sesionFinal[3]);
                        String navegador = String.valueOf(sesionFinal[4]);
                        String fecha = String.valueOf(sesionFinal[5]);
                        Date fechaConexion = null;
                        try {
                            fechaConexion = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(fecha);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        String estado = String.valueOf(sesionFinal[6]);
                        ultimaSession.setICodigo(codigoS);
                        ultimaSession.setCIp(ip);
                        ultimaSession.setCHost(host);
                        ultimaSession.setCNavegador(navegador);
                        ultimaSession.setCEstado(estado);
                        ultimaSession.setFConexion(fechaConexion);
                    } else {
                        ultimaSession = null;
                    }

                }
            }
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
        return ultimaSession;
    }

    @Override
    public SessionUsuario findSessionACTByUser(Long idUsuario) {
        SessionUsuario sessionUpd = new SessionUsuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("select * from session_usuario \n"
                    + "where i_usuario=? and \n"
                    + "c_estado='ACT' \n"
                    + "order by f_conexion DESC", SessionUsuario.class);

            consultDocument.setParameter(1, idUsuario);
            List<SessionUsuario> listSession = consultDocument.getResultList();

            if (listSession != null && !listSession.isEmpty()) {
                sessionUpd = listSession.get(0);
            }
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
        return sessionUpd;
    }

    @Override
    public List<SessionUsuario> findListSessionACTByUser(Long idUsuario, Long iTipoCanal) {
        List<SessionUsuario> listSession = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("select * from session_usuario \n"
                    + " where i_usuario=?  \n"
                    + " and c_estado='ACT' \n"
                    + " and i_tipo_canal = ? "
                    + " order by f_conexion DESC", SessionUsuario.class);

            consultDocument.setParameter(1, idUsuario);
            consultDocument.setParameter(2, iTipoCanal);
            listSession = consultDocument.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            listSession = null;
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listSession;
    }
}
