/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;

/**
 *
 * @author Brayan Moreno
 */
public interface InscCuentaSolAfilWebDataAccess {
    
    InscCuentaSolAfilWeb saveInscCuenta(InscCuentaSolAfilWeb cuentaSolAfilWeb);
    
    InscCuentaSolAfilWeb updateInscCuenta(InscCuentaSolAfilWeb cuentaSolAfilWeb);
    
    InscCuentaSolAfilWeb findInscCuentaByIdSol(Long idSolAfilWeb);
    
}
