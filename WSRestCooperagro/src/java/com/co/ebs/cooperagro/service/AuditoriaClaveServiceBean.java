/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AuditoriaClaveDataAccessImp;
import com.co.ebs.cooperagro.domain.AuditoriaClave;

/**
 *
 * @author Brayan F Silva R
 */
public class AuditoriaClaveServiceBean implements AuditoriaClaveService {

    private AuditoriaClaveDataAccessImp auditoriaClaveDataAccessImp = new AuditoriaClaveDataAccessImp();

    @Override
    public AuditoriaClave saveAuditoriaClave(AuditoriaClave auditoriaClave) {
        return auditoriaClaveDataAccessImp.saveAuditoriaClave(auditoriaClave);
    }

    @Override
    public AuditoriaClave updateAuditoriaClave(AuditoriaClave auditoriaClave) {
        return auditoriaClaveDataAccessImp.updateAuditoriaClave(auditoriaClave);
    }

    @Override
    public AuditoriaClave findAuditoriaClaveById(Long id) {
        return auditoriaClaveDataAccessImp.findAuditoriaClaveById(id);
    }

    @Override
    public Boolean bValidaClaveAnterior(Long idUsuario, String sClave, int iNumRegistroVal, int iTransaccion, int iTipoCanal) {
        return auditoriaClaveDataAccessImp.bValidaClaveAnterior(idUsuario, sClave, iNumRegistroVal, iTransaccion, iTipoCanal);
    }

}
