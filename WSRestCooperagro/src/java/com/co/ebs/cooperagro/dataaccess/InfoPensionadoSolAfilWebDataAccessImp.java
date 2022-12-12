/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.InfoPensionadoSolAfilWeb;
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
public class InfoPensionadoSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<InfoPensionadoSolAfilWeb> implements InfoPensionadoSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public InfoPensionadoSolAfilWeb saveInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        return create(infoPensionadoSolAfilWeb);
    }

    @Override
    public InfoPensionadoSolAfilWeb updateInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        return update(infoPensionadoSolAfilWeb);
    }

    @Override
    public InfoPensionadoSolAfilWeb findInfoPensionadoSolAfilWebById(Long id) {
        return find(id);
    }

    @Override
    public InfoPensionadoSolAfilWeb findInfoPensionadoBySolAfilWeb(Long idSolAfilWeb) {
        InfoPensionadoSolAfilWeb ipsaw = new InfoPensionadoSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            if (idSolAfilWeb != null) {
                String sQuery = "SELECT * FROM INFO_PENSIONADOS_SOL_AFIL_WEB I WHERE I.I_SOL_AFILIACION_WEB = ?";
                Query query = this.em.createNativeQuery(sQuery, InfoPensionadoSolAfilWeb.class);
                query.setParameter(1, idSolAfilWeb);
                List<InfoPensionadoSolAfilWeb> lstInfoPensionadoSolAfilWeb = query.getResultList();
                if (lstInfoPensionadoSolAfilWeb != null && !lstInfoPensionadoSolAfilWeb.isEmpty()) {
                    for (InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb : lstInfoPensionadoSolAfilWeb) {
                        if (infoPensionadoSolAfilWeb.getISolAfiliacionWeb().getICodigo().equals(idSolAfilWeb)) {
                            ipsaw = infoPensionadoSolAfilWeb;
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
        return ipsaw;
    }

    @Override
    public void deleteInfoPensionadoSolAfilWeb(InfoPensionadoSolAfilWeb infoPensionadoSolAfilWeb) {
        delete(infoPensionadoSolAfilWeb);
    }

    @Override
    public List<InfoPensionadoSolAfilWeb> findAllInfoPensionadoSolAfilWeb() {
        return findAll();
    }

}
