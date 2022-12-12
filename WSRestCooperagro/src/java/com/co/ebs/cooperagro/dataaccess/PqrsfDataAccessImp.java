package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Pqrsf;
import com.co.ebs.cooperagro.domain.Pqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author YO
 */
public class PqrsfDataAccessImp extends WSRestGenericRepositoryJPA<Pqrsf> implements PqrsfDataAccess {

    private EntityManager em = null;

    @Override
    public Pqrsf savePqrsf(Pqrsf pqrsf) {
        return create(pqrsf);
    }

    @Override
    public Pqrsf updatePqrsf(Pqrsf pqrsf) {
        return update(pqrsf);
    }

    @Override
    public void deletePqrsf(Pqrsf pqrsf) {
        delete(pqrsf);
    }

    @Override
    public List<Pqrsf> findAllPqrsf() {
        return findAllOrderByCampo("DESC","fFechaSolictud");
    }

    @Override
    public Pqrsf findById(Long id) {
        
        Pqrsf pqrsf = new Pqrsf();

        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM PQRSF WHERE I_CODIGO = ?";
            Query consultDocument = em.createNativeQuery(sSQL, Pqrsf.class);
            consultDocument.setParameter(1, id);
            List<Pqrsf> listPqrsf = consultDocument.getResultList();

            if (listPqrsf != null && !listPqrsf.isEmpty()) {
                for (Pqrsf p : listPqrsf) {
                    if (p.getICodigo().longValue() == id) {
                        pqrsf = p;
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
        return pqrsf;
    }

}
