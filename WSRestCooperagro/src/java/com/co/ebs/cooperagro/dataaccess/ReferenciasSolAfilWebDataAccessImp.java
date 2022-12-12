/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb;
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
 * @author Brayan F Silva R
 */
public class ReferenciasSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<ReferenciasSolAfilWeb> implements ReferenciasSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public ReferenciasSolAfilWeb saveReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        return create(referenciasSolAfilWeb);
    }

    @Override
    public ReferenciasSolAfilWeb updateReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        return update(referenciasSolAfilWeb);
    }

    @Override
    public ReferenciasSolAfilWeb findReferenciasSolAfilWebById(Long id) {
        return find(id);
    }

    @Override
    public ReferenciasSolAfilWeb findReferenciasBySolAfilWeb(Long idSolAfilWeb) {
        ReferenciasSolAfilWeb rsaw = new ReferenciasSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            if (idSolAfilWeb != null) {
                String sql ="SELECT R.* FROM REFERENCIAS_SOL_AFIL_WEB R WHERE R.I_SOL_AFILIACION_WEB = ?";
                this.em = connDBJPA.getEntityManager();
                Query query = this.em.createNativeQuery(sql, ReferenciasSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<ReferenciasSolAfilWeb> lstReferenciasSolAfilWeb = query.getResultList();
                if (lstReferenciasSolAfilWeb != null && !lstReferenciasSolAfilWeb.isEmpty()) {
                    for (ReferenciasSolAfilWeb infoPensionadoSolAfilWeb : lstReferenciasSolAfilWeb) {
                        if (infoPensionadoSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            rsaw = infoPensionadoSolAfilWeb;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }
        return rsaw;
    }

    @Override
    public void deleteReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        delete(referenciasSolAfilWeb);
    }

    @Override
    public List<ReferenciasSolAfilWeb> findAllReferenciasSolAfilWeb() {
        return findAll();
    }

}
