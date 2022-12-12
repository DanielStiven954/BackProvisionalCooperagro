/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.*;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
public class SolicitudCreditoDataAccessImp extends WSRestGenericRepositoryJPA<SolicitudCredito> implements SolicitudCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public SolicitudCredito saveSolicitud(SolicitudCredito xData){
        SolicitudCredito sSolicitudCreditoC = create(xData);
        return sSolicitudCreditoC;
    }

    @Override
    public SolicitudCredito updateSolicitud(SolicitudCredito xData) {
        SolicitudCredito sSolicitudCreditoC = update(xData);
        return sSolicitudCreditoC;
    }

    @Override
    public void deleteSolicitud(SolicitudCredito xData) {
        delete(xData);
    }

    @Override
    public List<SolicitudCredito> findAllSolicitudCredito() {
        return findAll();
    }

    @Override
    public List<SolicitudCredito> findAllSolicitudCreditoOrderByFechaSolCred() {
        return findAllOrderByCampo("DESC", "fFechaSolicitud");
    }

    @Override
    public SolicitudCredito findSolicitudCreditoById(Long id) {
        return find(id);
    }

    @Override
    public List<SolicitudCredito> findSolCreditoByPersona(Long idPersona) {
        List<SolicitudCredito> listaConsulta = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE  SC.I_PERSONA=? ";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idPersona);
            listaConsulta = consulta.getResultList();
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
        return listaConsulta;
    }

    @Override
    public List<SolicitudCredito> findSolicitudByID(long xCodigo) {
        List<SolicitudCredito> listSolCred = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE  SC.I_CODIGO=? ";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, xCodigo);
            try {
                List<SolicitudCredito> listaConsulta = consulta.getResultList();
                if (listaConsulta != null && !listaConsulta.isEmpty()) {
                    SolicitudCredito solcre = new SolicitudCredito();
                    SolicitudCredito solicitudLista = listaConsulta.get(0);
                    //Esto no deberia ir
                    solcre.setICodigo(solicitudLista.getICodigo());
                    solcre.setICodCredito(solicitudLista.getICodCredito());
                    solcre.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                    solcre.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                    solcre.setPlazo(solicitudLista.getPlazo());
                    solcre.setNValorCuota(solicitudLista.getNValorCuota());
                    solcre.setICodPeriodo(solicitudLista.getICodPeriodo());
                    solcre.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                    solcre.setFFechaCreacion(solicitudLista.getFFechaCreacion());
                    solcre.setIUsuarioModificador(solicitudLista.getIUsuarioModificador());
                    solcre.setFFechaModificacion(solicitudLista.getFFechaSolicitud());
                    listSolCred.add(solcre);
                } else {
                    listSolCred = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        return listSolCred;

    }

    @Override
    public List<SolicitudCredito> findAllSolicitud() {
//        List<SolicitudCredito> listSolicitudCreditoC = findAll(); //Esto no esta funcionando, manda error 500 
        List<SolicitudCredito> listSolCred = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);

            try {
                List<SolicitudCredito> listaConsulta = consulta.getResultList();
                if (listaConsulta != null && !listaConsulta.isEmpty()) {
                    for (SolicitudCredito solicitudLista : listaConsulta) {
                        SolicitudCredito solcre = new SolicitudCredito();
                        //Esto no deberia ir
                        solcre.setICodigo(solicitudLista.getICodigo());
                        solcre.setICodCredito(solicitudLista.getICodCredito());
                        solcre.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                        solcre.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                        solcre.setPlazo(solicitudLista.getPlazo());
                        solcre.setNValorCuota(solicitudLista.getNValorCuota());
                        solcre.setICodPeriodo(solicitudLista.getICodPeriodo());
                        solcre.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                        solcre.setFFechaCreacion(solicitudLista.getFFechaCreacion());
                        solcre.setIUsuarioModificador(solicitudLista.getIUsuarioModificador());
                        solcre.setFFechaModificacion(solicitudLista.getFFechaSolicitud());
                        listSolCred.add(solcre);
                    }
                } else {
                    listSolCred = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        return listSolCred;
    }

    @Override
    public List<SolicitudCredito> validarSolicitud(String codPersona, String estadoSol) {
        List<SolicitudCredito> listSolCred = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE  SC.I_PERSONA=? ";
            if (estadoSol != null) {
                sql += "AND SC.I_ESTADO_SOLICITUD=1";
            }

            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, codPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
                SolicitudCredito solcre = new SolicitudCredito();
                SolicitudCredito solicitudLista = listaConsulta.get(0);
                //Esto no deberia ir
                solcre.setICodigo(solicitudLista.getICodigo());
                solcre.setICodCredito(solicitudLista.getICodCredito());
                solcre.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                solcre.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                solcre.setPlazo(solicitudLista.getPlazo());
                solcre.setNValorCuota(solicitudLista.getNValorCuota());
                solcre.setICodPeriodo(solicitudLista.getICodPeriodo());
                solcre.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                solcre.setFFechaCreacion(solicitudLista.getFFechaCreacion());
                solcre.setIUsuarioModificador(solicitudLista.getIUsuarioModificador());
                solcre.setFFechaModificacion(solicitudLista.getFFechaSolicitud());
                listSolCred.add(solcre);
            } else {
                listSolCred = null;
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

        return listSolCred;
//        return sol;
    }

    @Override
    public SolicitudCredito verificarSolCredByPersonaAndLineaCred(Long idPersona, Long idLineaCred) {
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM SOLICITUD_CREDITO SC WHERE  SC.I_COD_CREDITO = ? AND SC.I_PERSONA=? AND SC.I_ESTADO_SOLICITUD=1 ORDER BY F_FECHA_SOLICITUD DESC ";

            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idLineaCred);
            consulta.setParameter(2, idPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
//                SolicitudCredito solcre = new SolicitudCredito();
                SolicitudCredito solicitudLista = listaConsulta.get(0);
                //Esto no deberia ir
                solicitudCredito.setICodigo(solicitudLista.getICodigo());
                solicitudCredito.setICodCredito(solicitudLista.getICodCredito());
                solicitudCredito.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                solicitudCredito.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                solicitudCredito.setPlazo(solicitudLista.getPlazo());
                solicitudCredito.setNValorCuota(solicitudLista.getNValorCuota());
                solicitudCredito.setICodPeriodo(solicitudLista.getICodPeriodo());
                solicitudCredito.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                solicitudCredito.setINumRadic(solicitudLista.getINumRadic());
            } else {
                solicitudCredito = null;
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
        return solicitudCredito;
    }

    @Override
    public SolicitudCredito verificarSolCredByPersonaAndLineaCredRadicado(Long idPersona, Long idLineaCred) {
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM SOLICITUD_CREDITO SC WHERE  SC.I_COD_CREDITO = ? AND SC.I_PERSONA=? AND SC.I_ESTADO_SOLICITUD=2 ORDER BY F_FECHA_SOLICITUD DESC ";

            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idLineaCred);
            consulta.setParameter(2, idPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
//                SolicitudCredito solcre = new SolicitudCredito();
                SolicitudCredito solicitudLista = listaConsulta.get(0);
                //Esto no deberia ir
                solicitudCredito.setICodigo(solicitudLista.getICodigo());
                solicitudCredito.setICodCredito(solicitudLista.getICodCredito());
                solicitudCredito.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                solicitudCredito.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                solicitudCredito.setPlazo(solicitudLista.getPlazo());
                solicitudCredito.setNValorCuota(solicitudLista.getNValorCuota());
                solicitudCredito.setICodPeriodo(solicitudLista.getICodPeriodo());
                solicitudCredito.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                solicitudCredito.setINumRadic(solicitudLista.getINumRadic());
            } else {
                solicitudCredito = null;
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
        return solicitudCredito;
    }

    @Override
    public SolicitudCredito validarSolCredByPersonaAndCodCredito(Long idPersona, Long idLineaCred) {
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM SOLICITUD_CREDITO SC WHERE  SC.I_COD_CREDITO = ? AND SC.I_PERSONA= ? AND SC.I_ESTADO_SOLICITUD IN (2,3,6,7) ORDER BY F_FECHA_SOLICITUD DESC ";

            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idLineaCred);
            consulta.setParameter(2, idPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
//                SolicitudCredito solcre = new SolicitudCredito();
                SolicitudCredito solicitudLista = listaConsulta.get(0);
                //Esto no deberia ir
                solicitudCredito.setICodigo(solicitudLista.getICodigo());
                solicitudCredito.setICodCredito(solicitudLista.getICodCredito());
                solicitudCredito.setFFechaSolicitud(solicitudLista.getFFechaSolicitud());
                solicitudCredito.setNMontoSolicitud(solicitudLista.getNMontoSolicitud());
                solicitudCredito.setPlazo(solicitudLista.getPlazo());
                solicitudCredito.setNValorCuota(solicitudLista.getNValorCuota());
                solicitudCredito.setICodPeriodo(solicitudLista.getICodPeriodo());
                solicitudCredito.setIEstadoSolicitud(solicitudLista.getIEstadoSolicitud());
                solicitudCredito.setINumRadic(solicitudLista.getINumRadic());
            } else {
                solicitudCredito = null;
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
        return solicitudCredito;
    }
    
    @Override
    public SolicitudCredito verificarSolCredByPersonaAndLineaCredDiligenRadic(Long idPersona, Long idLineaCred) {
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM SOLICITUD_CREDITO SC WHERE  SC.I_COD_CREDITO =? AND SC.I_PERSONA=? AND SC.I_ESTADO_SOLICITUD NOT IN (1,2) AND SC.I_TIPO_CANAL=2 AND SC.I_TIPO_PRODUCTO=? ORDER BY F_FECHA_SOLICITUD DESC";

            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idLineaCred);
            consulta.setParameter(2, idPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
                solicitudCredito = listaConsulta.get(0);
            } else {
                solicitudCredito = null;
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
        return solicitudCredito;
    }
}
   