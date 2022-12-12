/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan Moreno
 */
public class TipoPQRSFDataAccessImp extends WSRestGenericRepositoryJPA<TipoPqrsf> implements TipoPQRSFDataAccess {

    private EntityManager em = null;

    @Override
    public TipoPqrsf saveTipoPQRSF(TipoPqrsf tipoPqrsf) {
        return create(tipoPqrsf);
    }

    @Override
    public TipoPqrsf updateTipoPQRSF(TipoPqrsf tipoPqrsf) {
        return update(tipoPqrsf);
    }

    @Override
    public void deleteTipoPQRSF(TipoPqrsf tipoPqrsf) {
        delete(tipoPqrsf);
    }

    @Override
    public List<TipoPqrsf> findAllTipoPQRSF() {
        return findAll();
    }

    @Override
    public TipoPqrsf findByIdTipoPQRSF(Long id) {

        TipoPqrsf tipoPqrsf = new TipoPqrsf();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM TIPO_PQRSF WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, TipoPqrsf.class);
            consultDocument.setParameter(1, id);
            List<TipoPqrsf> listTipo = consultDocument.getResultList();
            
            if (listTipo != null && !listTipo.isEmpty()) {
                for (TipoPqrsf tipo : listTipo) {
                    if (tipo.getICodigo().longValue() ==  id) {
                        tipoPqrsf = tipo;
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
        return tipoPqrsf;
    }

}
