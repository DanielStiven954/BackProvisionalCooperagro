/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.CategoriaPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class CategoriaPQRSFDataAccessImp extends WSRestGenericRepositoryJPA<CategoriaPqrsf> implements CategoriaPQRSFDataAccess{

    private EntityManager em = null;

    @Override
    public CategoriaPqrsf saveCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf) {
        return create(categoriaPqrsf);
    }

    @Override
    public CategoriaPqrsf updateCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf) {
        return update(categoriaPqrsf);
    }

    @Override
    public void deleteCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf) {
        delete(categoriaPqrsf);
    }

    @Override
    public List<CategoriaPqrsf> findAllCategoriaPQRSF() {
        return findAllOrderByCampo("ASC", "cNombre");
        
    }

    @Override
    public CategoriaPqrsf findByIdCategoriaPQRSF(Long id) {

        CategoriaPqrsf categoriaPqrsf = new CategoriaPqrsf();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM CATEGORIA_PQRSF WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, CategoriaPqrsf.class);
            consultDocument.setParameter(1, id);
            List<CategoriaPqrsf> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                for (CategoriaPqrsf tipo : listTipo) {
                    if (tipo.getICodigo().longValue() == id) {
                        categoriaPqrsf = tipo;
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
        return categoriaPqrsf;
    }

}
