/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.ConsultaAniOlimpiait;

/**
 *
 * @author Brayan Moreno
 */
public interface ConsultaAniService {

    ConsultaAniOlimpiait saveConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait);

    ConsultaAniOlimpiait updateConsultaAniOlimpiait(ConsultaAniOlimpiait consultaAniOlimpiait);

    ConsultaAniOlimpiait findConsultaAniByid(Long id);
}
