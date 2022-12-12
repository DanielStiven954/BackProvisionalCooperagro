/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.ConsultaANIDataAccessImp;
import com.co.ebs.cooperagro.domain.ConsultaAniOlimpiait;

/**
 *
 * @author Brayan Moreno
 */
public class ConsultaAniServiceBean implements ConsultaAniService {

    @Override
    public ConsultaAniOlimpiait saveConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait) {
        return new ConsultaANIDataAccessImp().create(consultaAniOlimpiait);
    }

    @Override
    public ConsultaAniOlimpiait updateConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait) {
        return new ConsultaANIDataAccessImp().updateConsultaAniOlimpiait(consultaAniOlimpiait);
    }

    @Override
    public ConsultaAniOlimpiait findConsultaAniByid(Long id) {
        return new ConsultaANIDataAccessImp().findConsultaAniById(id);
    }

}
