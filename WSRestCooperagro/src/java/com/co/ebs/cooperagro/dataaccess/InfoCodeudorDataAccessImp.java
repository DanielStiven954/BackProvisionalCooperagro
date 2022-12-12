/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.*;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jonathan Ruge
 */
public class InfoCodeudorDataAccessImp extends WSRestGenericRepositoryJPA<InfoCodeudor> implements InfoCodeudorDataAccess {

    private EntityManager em = null;

    @Override
    public InfoCodeudor saveInfoCodeudor(InfoCodeudor xData) {
        InfoCodeudor nuevo = create(xData);
        return nuevo;
    }

    @Override
    public InfoCodeudor editInfoCodeudor(InfoCodeudor xData) {
        InfoCodeudor nuevo = update(xData);
        return nuevo;
    }

    @Override
    public void deleteInfoCodeudor(InfoCodeudor xData) {
        delete(xData);
    }

    @Override
    public InfoCodeudor findById(long xCodigo) {
        return find(xCodigo);
    }

    @Override
    public InfoCodeudor findInfoCodeudorByIdSolCred(Long idSolCred) {
        String sql = "SELECT I.* FROM  INFO_CODEUDOR I WHERE  I.I_SOLICITUD_CREDITO = ? ORDER BY F_FECHA_CREACION DESC ";
        InfoCodeudor infoCtaBanco = new InfoCodeudor();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consulta = em.createNativeQuery(sql, InfoCodeudor.class);
            consulta.setParameter(1, idSolCred);
            try {
                List<InfoCodeudor> listaConsulta = consulta.getResultList();
                if (listaConsulta != null && !listaConsulta.isEmpty()) {
                    infoCtaBanco = listaConsulta.get(0);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
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
        return infoCtaBanco;
    }

    @Override
    public List<InfoCodeudor> buscarTodos() {
        return findAll();
    }
}
