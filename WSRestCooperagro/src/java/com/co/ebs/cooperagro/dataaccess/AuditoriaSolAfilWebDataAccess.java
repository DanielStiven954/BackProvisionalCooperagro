/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AuditoriaSolAfilWeb;
import java.util.List;

/**
 *
 * @author -Brayan Moreno
 */
public interface AuditoriaSolAfilWebDataAccess {
    
    AuditoriaSolAfilWeb saveAuditoriaSolAfilWeb(AuditoriaSolAfilWeb auditoriaSolAfilWeb);
    
    AuditoriaSolAfilWeb updateAuditoriaSolAfilWeb(AuditoriaSolAfilWeb auditoriaSolAfilWeb);
    
    AuditoriaSolAfilWeb findByIdAuditoriaSolAfilWeb(Long id);
    
    List<AuditoriaSolAfilWeb> findAllAuditoriaSolAfilWeb();
    
}
