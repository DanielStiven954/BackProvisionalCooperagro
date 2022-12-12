/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ConsultaAniOlimpiait;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;

/**
 *
 * @author Brayan Moreno
 */
public class ConsultaANIDataAccessImp extends WSRestGenericRepositoryJPA<ConsultaAniOlimpiait> implements ConsultaANIDataAccess{
  
    @Override
    public ConsultaAniOlimpiait saveConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait){
        return create(consultaAniOlimpiait);
    }

    @Override
    public ConsultaAniOlimpiait updateConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait) {
        return update(consultaAniOlimpiait);
    }

    @Override
    public ConsultaAniOlimpiait findConsultaAniById(Long id) {
        return find(id);
    }
    
}
