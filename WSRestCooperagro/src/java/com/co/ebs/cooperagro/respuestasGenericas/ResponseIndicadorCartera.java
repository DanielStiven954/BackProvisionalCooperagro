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
public class ResponseIndicadorCartera {

    private BigDecimal bdValorMeta;
    private BigDecimal bdValorLogro;
    private Double dPorcentajeCumplimiento;
    private Double bdPorcentajeMeta;

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

    public Double getdPorcentajeCumplimiento() {
        return dPorcentajeCumplimiento;
    }

    public void setdPorcentajeCumplimiento(Double dPorcentajeCumplimiento) {
        this.dPorcentajeCumplimiento = dPorcentajeCumplimiento;
    }

    public Double getBdPorcentajeMeta() {
        return bdPorcentajeMeta;
    }

    public void setBdPorcentajeMeta(Double bdPorcentajeMeta) {
        this.bdPorcentajeMeta = bdPorcentajeMeta;
    }
}
