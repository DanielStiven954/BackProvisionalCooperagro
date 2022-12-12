/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.GestionPqrsf;
import com.co.ebs.cooperagro.domain.Pqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author YO
 */
public class GestionPqrsfDataAccessImp extends WSRestGenericRepositoryJPA<GestionPqrsf> implements GestionPqrsfDataAccess {

    private EntityManager em = null;

    @Override
    public GestionPqrsf registrarGestion(GestionPqrsf gestionPqrsf) {
        return create(gestionPqrsf);
    }

    @Override
    public List<GestionPqrsf> obtenerMsjRta(Long codigo) {

        connectionDBJPA connDBJPA = new connectionDBJPA();
        List<GestionPqrsf> listPqrsf = new ArrayList<>();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT I_CODIGO, C_MSJ_RTA, F_FECHA_REGISTRO, I_USUARIO_CREADOR FROM GESTION_PQRSF WHERE I_PQRSF = ? ORDER BY I_CODIGO ASC";
            Query consultDocument = em.createNativeQuery(sSQL, GestionPqrsf.class);
            consultDocument.setParameter(1, codigo);
            listPqrsf = consultDocument.getResultList();

            for (GestionPqrsf list : listPqrsf) {
                list.setCIp(null);
                list.setCNavegador(null);
                list.setIPqrsf(null);
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
        return listPqrsf;
    }

}
