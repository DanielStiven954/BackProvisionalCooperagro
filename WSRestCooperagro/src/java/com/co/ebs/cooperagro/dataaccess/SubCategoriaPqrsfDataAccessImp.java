/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class SubCategoriaPqrsfDataAccessImp extends WSRestGenericRepositoryJPA<SubCategoriaPqrsf> implements SubCategoriaPqrsfDataAccess {

    private EntityManager em = null;

    @Override
    public SubCategoriaPqrsf saveSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf) {
        return create(subCategoriaPqrsf);
    }

    @Override
    public SubCategoriaPqrsf updateSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf) {
        return update(subCategoriaPqrsf);
    }

    @Override
    public void deleteSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf) {
        delete(subCategoriaPqrsf);
    }

    @Override
    public List<SubCategoriaPqrsf> findAllSubCategoriaPQRSF() {
        return findAllOrderByCampo("ASC", "cNombre");
    }

    @Override
    public SubCategoriaPqrsf findByIdSubCategoriaPQRSF(Long id) {

        SubCategoriaPqrsf subCategoriaPqrsf = new SubCategoriaPqrsf();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM SUB_CATEGORIA_PQRSF WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, SubCategoriaPqrsf.class);
            consultDocument.setParameter(1, id);
            List<SubCategoriaPqrsf> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                for (SubCategoriaPqrsf tipo : listTipo) {
                    if (tipo.getICodigo().longValue() == id) {
                        subCategoriaPqrsf = tipo;
                        break;
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
        return subCategoriaPqrsf;
    }

    public List<SubCategoriaPqrsf> findByCategoria(Long id) {

        List<SubCategoriaPqrsf> listSub = new ArrayList<>();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM SUB_CATEGORIA_PQRSF WHERE I_CATEGORIA = ? ORDER BY C_NOMBRE ASC";
            Query consultDocument = em.createNativeQuery(sSQL, SubCategoriaPqrsf.class);
            consultDocument.setParameter(1, id);
            listSub = consultDocument.getResultList();

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
        return listSub;
    }
}
