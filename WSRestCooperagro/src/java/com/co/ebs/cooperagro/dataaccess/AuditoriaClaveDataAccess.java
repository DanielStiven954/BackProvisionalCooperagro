/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AuditoriaClave;

/**
 *
 * @author Brayan F Silva R
 */
public interface AuditoriaClaveDataAccess {

    AuditoriaClave saveAuditoriaClave(AuditoriaClave auditoriaClave);

    AuditoriaClave updateAuditoriaClave(AuditoriaClave auditoriaClave);

    AuditoriaClave findAuditoriaClaveById(Long id);

    Boolean bValidaClaveAnterior(Long idUsuario, String sClave, int iNumRegistroVal, int iTransaccion, int iTipoCanal);
}
