/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.InfoConyugeSolAfilWeb;
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
public class InfoConyugeSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<InfoConyugeSolAfilWeb> implements InfoConyugeSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public InfoConyugeSolAfilWeb saveInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        return create(infoConyugeSolAfilWeb);
    }

    @Override
    public InfoConyugeSolAfilWeb updateInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        return update(infoConyugeSolAfilWeb);
    }

    @Override
    public InfoConyugeSolAfilWeb findInfoConyugeSolAfilWebById(Long id) {
        return find(id);
    }

    @Override
    public InfoConyugeSolAfilWeb findInfoConyugeBySolAfilWeb(Long idSolAfilWeb) {
        InfoConyugeSolAfilWeb icsaw = new InfoConyugeSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            if (idSolAfilWeb != null) {
                Query query = this.em.createNativeQuery(" SELECT I.* FROM INFO_CONYUGE_SOL_AFIL_WEB I WHERE I.I_SOL_AFILIACION_WEB = ? ", InfoConyugeSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<InfoConyugeSolAfilWeb> lstInfoConyugeSolAfilWeb = query.getResultList();
                if (lstInfoConyugeSolAfilWeb != null && !lstInfoConyugeSolAfilWeb.isEmpty()) {
                    for (InfoConyugeSolAfilWeb infoPensionadoSolAfilWeb : lstInfoConyugeSolAfilWeb) {
                        if (infoPensionadoSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            icsaw = infoPensionadoSolAfilWeb;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }
        return icsaw;
    }

    @Override
    public void deleteInfoConyugeSolAfilWeb(InfoConyugeSolAfilWeb infoConyugeSolAfilWeb) {
        delete(infoConyugeSolAfilWeb);
    }

    @Override
    public List<InfoConyugeSolAfilWeb> findAllInfoConyugeSolAfilWeb() {
        return findAll();
    }

}
