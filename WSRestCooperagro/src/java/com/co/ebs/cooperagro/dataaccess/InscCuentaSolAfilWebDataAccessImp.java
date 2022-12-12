/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AutorizacionSolAfilWeb;
import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan Moreno
 */
public class InscCuentaSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<InscCuentaSolAfilWeb> implements InscCuentaSolAfilWebDataAccess {

    private EntityManager em = null;

    @Override
    public InscCuentaSolAfilWeb saveInscCuenta(InscCuentaSolAfilWeb cuentaSolAfilWeb) {
        return create(cuentaSolAfilWeb);
    }

    @Override
    public InscCuentaSolAfilWeb updateInscCuenta(InscCuentaSolAfilWeb cuentaSolAfilWeb) {
        return update(cuentaSolAfilWeb);
    }

    @Override
    public InscCuentaSolAfilWeb findInscCuentaByIdSol(Long idSolAfilWeb) {
        InscCuentaSolAfilWeb cuentaSolAfilWeb = new InscCuentaSolAfilWeb();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT * FROM INSC_CUENTA_SOL_AFIL_WEB WHERE I_SOL_AFILIACION_WEB = ? ";
            Query consultDocument = em.createNativeQuery(sSQL, InscCuentaSolAfilWeb.class);
            consultDocument.setParameter(1, idSolAfilWeb);
            List<InscCuentaSolAfilWeb> listTipo = consultDocument.getResultList();

            if (listTipo != null && !listTipo.isEmpty()) {
                cuentaSolAfilWeb = listTipo.get(0);
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

        return cuentaSolAfilWeb;
    }

}
