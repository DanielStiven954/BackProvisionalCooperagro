/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AuditoriaClave;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class AuditoriaClaveDataAccessImp extends WSRestGenericRepositoryJPA<AuditoriaClave> implements AuditoriaClaveDataAccess {

    private EntityManager em = null;

    @Override
    public AuditoriaClave saveAuditoriaClave(AuditoriaClave auditoriaClave) {
        AuditoriaClave createAuditoriaClave = create(auditoriaClave);
        return createAuditoriaClave;
    }

    @Override
    public AuditoriaClave updateAuditoriaClave(AuditoriaClave auditoriaClave) {
        AuditoriaClave updateAuditoriaClave = update(auditoriaClave);
        return updateAuditoriaClave;
    }

    @Override
    public AuditoriaClave findAuditoriaClaveById(Long id) {
        AuditoriaClave findAuditoriaClaveById = find(id);
        return findAuditoriaClaveById;
    }

    @Override
    public Boolean bValidaClaveAnterior(Long idUsuario, String sClave, int iNumRegistroVal, int iTransaccion, int iTipoCanal) {
        Boolean bRtaValidacion = Boolean.FALSE;
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_VALIDACION.PRC_VAL_AUDITORIA_CLAVE");
            //REGISTRO PARAMETROS DE ENTRADA
            storedProcedureQuery.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
            //REGISTRO PARAMETROS DE SALIDA
            storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(7, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(8, String.class, ParameterMode.OUT);

            //SE ENVIAN LOS VALORES AL SP
            storedProcedureQuery.setParameter(1, idUsuario);
            storedProcedureQuery.setParameter(2, sClave);
            storedProcedureQuery.setParameter(3, iTransaccion);
            storedProcedureQuery.setParameter(4, iTipoCanal);
            storedProcedureQuery.setParameter(5, iNumRegistroVal);

            storedProcedureQuery.execute();

            int iTotalRegistros = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(6).toString());
            int cod_mensaje = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(7).toString());
            String mensaje = storedProcedureQuery.getOutputParameterValue(8).toString();
            if (cod_mensaje == 1 && Boolean.parseBoolean(mensaje)) {
                if (iTotalRegistros == 0) {
                    bRtaValidacion = Boolean.TRUE;
                } else {
                    bRtaValidacion = Boolean.FALSE;
                }
            } else {
                bRtaValidacion = Boolean.FALSE;
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
        return bRtaValidacion;
    }

}
