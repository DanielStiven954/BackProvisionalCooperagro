/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan F Silva R
 */
public class OperMonedaExtSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<OperMonedaExtSolAfilWeb> implements OperMonedaExtSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public OperMonedaExtSolAfilWeb saveOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        return create(operMonedaExtSolAfilWeb);
    }

    @Override
    public OperMonedaExtSolAfilWeb updateOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        return update(operMonedaExtSolAfilWeb);
    }

    @Override
    public OperMonedaExtSolAfilWeb findOperMonedaExtSolAfilWebById(Long id) {
        return find(id);
    }

    @Override
    public OperMonedaExtSolAfilWeb findOperMonedaExtBySolAfilWeb(Long idSolAfilWeb) {
        OperMonedaExtSolAfilWeb omesaw = new OperMonedaExtSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            if (idSolAfilWeb != null) {
                Query query = this.em.createNativeQuery("SELECT O.* FROM OPER_MONEDA_EXT_SOL_AFIL_WEB O WHERE O.I_SOL_AFILIACION_WEB = ?", OperMonedaExtSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<OperMonedaExtSolAfilWeb> lstOperMonedaExtSolAfilWeb = query.getResultList();
                if (lstOperMonedaExtSolAfilWeb != null && !lstOperMonedaExtSolAfilWeb.isEmpty()) {
                    for (OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb : lstOperMonedaExtSolAfilWeb) {
                        if (operMonedaExtSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            omesaw = operMonedaExtSolAfilWeb;
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
        return omesaw;
    }

    @Override
    public void deleteOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        delete(operMonedaExtSolAfilWeb);
    }

    @Override
    public List<OperMonedaExtSolAfilWeb> findAllOperMonedaExtSolAfilWeb() {
        return findAll();
    }

}
