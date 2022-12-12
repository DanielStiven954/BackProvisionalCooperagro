/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.domain.TipoPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author YO
 */
public class TipoEstadoPqrsfDataAccessImp extends WSRestGenericRepositoryJPA<TipoEstadoPqrsf> implements TipoEstadoPqrsfDataAccess{

    private EntityManager em = null;
    
    @Override
    public TipoEstadoPqrsf findByIdTipoEstadoPqrsf(Long id) {
        
        TipoEstadoPqrsf tipoEstadoPqrsf = new TipoEstadoPqrsf();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM TIPO_ESTADO_PQRSF WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, TipoEstadoPqrsf.class);
            consultDocument.setParameter(1, id);
            List<TipoEstadoPqrsf> listTipo = consultDocument.getResultList();
            
            if (listTipo != null && !listTipo.isEmpty()) {
                for (TipoEstadoPqrsf tipo : listTipo) {
                    if (tipo.getICodigo().longValue() ==  id) {
                        tipoEstadoPqrsf = tipo;
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
        return tipoEstadoPqrsf;
        
    }

    @Override
    public List<TipoEstadoPqrsf> findAllTipoEstadoPqrsd() {
        return findAll();
    }
    
}
