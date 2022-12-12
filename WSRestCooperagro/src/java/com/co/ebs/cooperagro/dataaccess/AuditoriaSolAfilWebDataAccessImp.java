/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AuditoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.TipoAutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan Moreno
 */
public class AuditoriaSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<AuditoriaSolAfilWeb> implements AuditoriaSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public AuditoriaSolAfilWeb saveAuditoriaSolAfilWeb(AuditoriaSolAfilWeb auditoriaSolAfilWeb) {
        return create(auditoriaSolAfilWeb);
    }

    @Override
    public AuditoriaSolAfilWeb updateAuditoriaSolAfilWeb(AuditoriaSolAfilWeb auditoriaSolAfilWeb) {
        return update(auditoriaSolAfilWeb);
    }

    @Override
    public AuditoriaSolAfilWeb findByIdAuditoriaSolAfilWeb(Long id) {
        AuditoriaSolAfilWeb afilWeb = new AuditoriaSolAfilWeb();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM AUDITORIA_SOL_AFIL_WEB WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, AuditoriaSolAfilWeb.class);
            consultDocument.setParameter(1, id);
            List<AuditoriaSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                for (AuditoriaSolAfilWeb tipo : listTipo) {
                    if (tipo.getICodigo().longValue() == id) {
                        afilWeb = tipo;
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

        return afilWeb;
    }

    @Override
    public List<AuditoriaSolAfilWeb> findAllAuditoriaSolAfilWeb() {
        return findAll();
    }

}
