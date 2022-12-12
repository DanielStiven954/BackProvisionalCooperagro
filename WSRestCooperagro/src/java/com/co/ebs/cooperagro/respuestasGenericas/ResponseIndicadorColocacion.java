/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import java.math.BigDecimal;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseIndicadorColocacion {

    private BigDecimal bdValorMeta;
    private BigDecimal bdValorLogro;
    private BigDecimal bdPorcentajeMeta;
    private BigDecimal bdPorcentajeCumplimiento;

    public BigDecimal getBdValorMeta() {
        return bdValorMeta;
    }

    public void setBdValorMeta(BigDecimal bdValorMeta) {
        this.bdValorMeta = bdValorMeta;
    }

    public BigDecimal getBdValorLogro() {
        return bdValorLogro;
    }

    public void setBdValorLogro(BigDecimal bdValorLogro) {
        this.bdValorLogro = bdValorLogro;
    }

    public BigDecimal getBdPorcentajeMeta() {
        return bdPorcentajeMeta;
    }

    public void setBdPorcentajeMeta(BigDecimal bdPorcentajeMeta) {
        this.bdPorcentajeMeta = bdPorcentajeMeta;
    }

    public BigDecimal getBdPorcentajeCumplimiento() {
        return bdPorcentajeCumplimiento;
    }

    public void setBdPorcentajeCumplimiento(BigDecimal bdPorcentajeCumplimiento) {
        this.bdPorcentajeCumplimiento = bdPorcentajeCumplimiento;
    }

}
