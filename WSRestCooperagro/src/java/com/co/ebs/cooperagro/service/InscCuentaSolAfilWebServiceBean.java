/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.InscCuentaSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.InscCuentaSolAfilWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

/**
 *
 * @author Brayan Moreno
 */
public class InscCuentaSolAfilWebServiceBean implements InscCuentaSolAfilWebService {
    
    @Override
    public respuestaGenerica saveCuentaSolAfilWeb(InscCuentaSolAfilWeb cuentaSolAfilWeb) {
        respuestaGenerica generica = new respuestaGenerica();
        
        InscCuentaSolAfilWebDataAccessImp accessImp = new InscCuentaSolAfilWebDataAccessImp();
        
        if (cuentaSolAfilWeb != null) {
            InscCuentaSolAfilWeb infoBuscada = accessImp.findInscCuentaByIdSol(cuentaSolAfilWeb.getISolAfiliacionWeb().getICodigo());
            if (infoBuscada != null) {
                cuentaSolAfilWeb.setICodigo(infoBuscada.getICodigo());
                InscCuentaSolAfilWeb cuentaUpdate = accessImp.updateInscCuenta(cuentaSolAfilWeb);
                if (cuentaUpdate != null) {
                    generica.setbRta(Boolean.TRUE);
                    generica.setiCodigo(1);
                    generica.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setiCodigo(0);
                    generica.setsMsj("Se ha presentado un incoveniente al actualizar la información de la cuenta. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                }
            } else {
                InscCuentaSolAfilWeb cuentaSave = accessImp.saveInscCuenta(cuentaSolAfilWeb);
                if (cuentaSave != null) {
                    generica.setbRta(Boolean.TRUE);
                    generica.setiCodigo(1);
                    generica.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setiCodigo(0);
                    generica.setsMsj("Se ha presentado un incoveniente al actualizar la información de la cuenta. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                }
                
            }
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("Por favor verifique la información enviada.");
        }
        return generica;
    }
    
    @Override
    public InscCuentaSolAfilWeb findInscCuentaByIdSol(Long idSolAfilWeb) {
        return new InscCuentaSolAfilWebDataAccessImp().findInscCuentaByIdSol(idSolAfilWeb);
    }
    
}
