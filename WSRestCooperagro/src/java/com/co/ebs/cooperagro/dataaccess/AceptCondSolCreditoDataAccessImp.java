/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AceptCondSolCredito;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan F Silva R
 */
public class AceptCondSolCreditoDataAccessImp extends WSRestGenericRepositoryJPA<AceptCondSolCredito> implements AceptCondSolCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public AceptCondSolCredito saveAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito) {
        return create(aceptCondSolCredito);
    }

    @Override
    public AceptCondSolCredito updateAceptCondSolCredito(AceptCondSolCredito aceptCondSolCredito) {
        return update(aceptCondSolCredito);
    }

    @Override
    public AceptCondSolCredito findAceptCondSolCreditoById(Long id) {
        return find(id);
    }

    @Override
    public List<AceptCondSolCredito> findAllAceptCondSolCredito() {
        return findAll();
    }

    @Override
    public void deleteTipoCanal(AceptCondSolCredito aceptCondSolCredito) {
        delete(aceptCondSolCredito);
    }

    @Override
    public AceptCondSolCredito findAceptCondSolCreditoBySolCredId(Long idSolCred) {
        String sql = "SELECT ACSC.* FROM  ACEPT_COND_SOL_CREDITO ACSC WHERE  ACSC.I_SOLICITUD_CREDITO=? AND ACSC.C_ESTADO = 'ACT' ORDER BY ACSC.F_FECHA_INICIO DESC ";
        connectionDBJPA connDBJPA = new connectionDBJPA();
        AceptCondSolCredito aceptCondSolCredito = new AceptCondSolCredito();
        try {
            em = connDBJPA.getEntityManager();
            Query consulta = em.createNativeQuery(sql, AceptCondSolCredito.class);
            consulta.setParameter(1, idSolCred);

            List<AceptCondSolCredito> listaConsulta = consulta.getResultList();
            if (listaConsulta != null && !listaConsulta.isEmpty()) {
                aceptCondSolCredito = listaConsulta.get(0);
                for (AceptCondSolCredito aceptCondSolCredito1 : listaConsulta) {
                    if (!aceptCondSolCredito1.equals(aceptCondSolCredito)) {
                        aceptCondSolCredito1.setCEstado("INA");
                        this.updateAceptCondSolCredito(aceptCondSolCredito1);
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
        return aceptCondSolCredito;
    }

    @Override
    public void inactivarTokensOld(Long idSolCred, Long idUserMod) {
        connectionDBJPA connDBJPA = new connectionDBJPA();

        try {
            em = connDBJPA.getEntityManager();
            String sql = "UPDATE ACEPT_COND_SOL_CREDITO SET C_ESTADO = 'INA', I_USUARIO_MODIFICADOR = ? , F_FECHA_MODIFICACION = SYSDATE WHERE I_SOLICITUD_CREDITO = ? AND C_ESTADO = 'ACT'";
            Query consulta = em.createNativeQuery(sql);
            consulta.setParameter(1, idUserMod);
            consulta.setParameter(2, idSolCred);
            em.getTransaction().begin();
            int iExecUpdate = consulta.executeUpdate();
            em.getTransaction().commit();

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
    }
}
