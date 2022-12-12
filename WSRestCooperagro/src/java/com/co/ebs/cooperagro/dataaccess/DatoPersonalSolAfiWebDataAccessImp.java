/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.DatoPersonalSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author JONATHAN RUGE
 */
public class DatoPersonalSolAfiWebDataAccessImp extends WSRestGenericRepositoryJPA<DatoPersonalSolAfilWeb> implements DatoPersonalSolAfiWebDataAccess {

    private EntityManager em = null;

    @Override
    public DatoPersonalSolAfilWeb crear(Long tipoIdent, String cIdentificacion, SolicitudAfiliacionWeb solAfiWeb) {
        DatoPersonalSolAfilWeb datoPersonalSolAfilWebTemporal = new DatoPersonalSolAfilWeb();
        datoPersonalSolAfilWebTemporal.setITipoIdent(tipoIdent);
        datoPersonalSolAfilWebTemporal.setCIdentificacion(cIdentificacion);
        datoPersonalSolAfilWebTemporal.setISolAfiliacionWeb(solAfiWeb);
        DatoPersonalSolAfilWeb datoPersonalSolAfilWeb = create(datoPersonalSolAfilWebTemporal);
        return datoPersonalSolAfilWeb;
    }

    public DatoPersonalSolAfilWeb crearReg(DatoPersonalSolAfilWeb xData) {
        return create(xData);
    }

    @Override
    public List<DatoPersonalSolAfilWeb> listaDatoPersonal() {

        connectionDBJPA connDBJPA = new connectionDBJPA();
        List<DatoPersonalSolAfilWeb> saws = new ArrayList<>();
        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(" select dp.* from solicitud_afiliacion_web sa \n"
                    + "inner join tipo_estado_sol_Afil_web tipoE on tipoE.I_CODIGO = sa.I_ESTADO_SOLICITUD\n"
                    + "inner join datos_personales_sol_afil_web dp on dp.I_SOL_AFILIACION_WEB = sa.i_codigo\n"
                    + "where tipoE.C_ABREVIATURA = 'RAD' or tipoE.C_ABREVIATURA = 'APR' or tipoE.C_ABREVIATURA = 'APL' or tipoE.C_ABREVIATURA = 'PRE' or tipoE.C_ABREVIATURA = 'NEG' ", DatoPersonalSolAfilWeb.class);
            saws = query.getResultList();

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
        return saws;
        //return findAll();
    }

    @Override
    public SolicitudAfiliacionWeb validarSolAfi(int iTipoIdent, String ident) {
        SolicitudAfiliacionWeb validarSolicitudAfiliacionWeb = null;
        String sql = "SELECT SA.* FROM DATOS_PERSONALES_SOL_AFIL_WEB DP,\n"
                + "				SOLICITUD_AFILIACION_WEB SA,\n"
                + "				TIPO_ESTADO_SOL_AFIL_WEB ES WHERE\n"
                + "				DP.I_SOL_AFILIACION_WEB = SA.I_CODIGO AND\n"
                + "				SA.I_ESTADO_SOLICITUD = ES.I_CODIGO AND\n"
                + "				DP.I_TIPO_IDENT = ? AND\n"
                + "				DP.C_IDENTIFICACION = ? \n"
                + "                             order by SA.F_FECHA_SOLICITUD DESC";
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();
            Query consulta = this.em.createNativeQuery(sql, SolicitudAfiliacionWeb.class);
            consulta.setParameter(1, iTipoIdent);
            consulta.setParameter(2, ident);
            List<SolicitudAfiliacionWeb> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && listaConsulta.size() > 0) {
                validarSolicitudAfiliacionWeb = listaConsulta.get(0); //Escoge el registro con la fecha más reciente
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

        return validarSolicitudAfiliacionWeb;
    }

    @Override
    public DatoPersonalSolAfilWeb updateDatoPersonalSolAfilWeb(DatoPersonalSolAfilWeb datoPersonalSolAfilWeb) {
        return update(datoPersonalSolAfilWeb);
    }

    @Override
    public DatoPersonalSolAfilWeb findDatoPersonalSolAfilWebById(Long Id) {
        return find(Id);
    }

    @Override
    public DatoPersonalSolAfilWeb findDatoPersonalBySolAfilWeb(Long idSolAfilWeb) {
        DatoPersonalSolAfilWeb personalSolAfilWeb = new DatoPersonalSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();
            if (idSolAfilWeb != null) {
                Query query = this.em.createNativeQuery(" SELECT d.* FROM DATOS_PERSONALES_SOL_AFIL_WEB D WHERE D.I_SOL_AFILIACION_WEB = ? ", DatoPersonalSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<DatoPersonalSolAfilWeb> lstDatoPersonalSolAfilWeb = query.getResultList();
                if (lstDatoPersonalSolAfilWeb != null && !lstDatoPersonalSolAfilWeb.isEmpty()) {
                    for (DatoPersonalSolAfilWeb datoPersonalSolAfilWeb : lstDatoPersonalSolAfilWeb) {
                        if (datoPersonalSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            personalSolAfilWeb = datoPersonalSolAfilWeb;
                            break;
                        }
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

        return personalSolAfilWeb;
    }

    @Override
    public boolean updateCursoCooperativo(String curso, Long idSolAfilWeb) {
        connectionDBJPA connDBJPA = new connectionDBJPA();
        boolean bandera = false;

        try {
            this.em = connDBJPA.getEntityManager();
            if (curso != null && idSolAfilWeb != null) {
                this.em.getTransaction().begin();

                Query query = this.em.createNativeQuery(" UPDATE DATOS_PERSONALES_SOL_AFIL_WEB SET C_CURSO_COOPERATIVISMO = ? WHERE I_SOL_AFILIACION_WEB = ? ");
                query.setParameter(1, curso);
                query.setParameter(2, idSolAfilWeb);
                query.executeUpdate();
                this.em.getTransaction().commit();

                bandera = true;

            }
        } catch (Exception e) {
            bandera = false;
            if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
            throw new RuntimeException(e.getMessage());

        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return bandera;
    }

    @Override
    public DatoPersonalSolAfilWeb findDatoPersonalByCedula(String Cedula) {
        DatoPersonalSolAfilWeb personalSolAfilWeb = new DatoPersonalSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();       
        try {
            this.em = connDBJPA.getEntityManager();
            if (Cedula != null) {
                Query query = this.em.createNativeQuery(" SELECT d.* FROM DATOS_PERSONALES_SOL_AFIL_WEB D WHERE D.C_IDENTIFICACION = ? ", DatoPersonalSolAfilWeb.class);
                query.setParameter(1, Cedula);
                List<DatoPersonalSolAfilWeb> lstDatoPersonalSolAfilWeb = query.getResultList();
                if (lstDatoPersonalSolAfilWeb != null && !lstDatoPersonalSolAfilWeb.isEmpty()) {                   
                    for (DatoPersonalSolAfilWeb datoPersonalSolAfilWeb : lstDatoPersonalSolAfilWeb) {                                          
                        String cCedula=String.valueOf(Cedula);
                        if (datoPersonalSolAfilWeb.getCIdentificacion().equals(cCedula)) {                           
                            personalSolAfilWeb = datoPersonalSolAfilWeb;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Entro4");
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return personalSolAfilWeb;
    }
}
