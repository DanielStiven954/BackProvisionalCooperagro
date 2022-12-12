/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class SolicitudCreditoRta {

    private Long iCodigo;
    private Long iNumRadic;
    private Long iCodCredito;
    private String sDescLineaCredito;
    private Long iCodPersona;
    private String sNombreAsociado;
    private Long iCodigoPeriodicidad;
    private String sDescPeriodo;
    private Long iCodTipoEstadoSolCred;
    private String sDecTipoEstadoSolCred;
    private BigDecimal bdMontoSolCredito;
    private BigInteger bIPlazo;
    private BigDecimal bdValorCuota;
    private String sFechaSolCredito;
    private List<ResponseDocSolCredito> responseDocSolCreditos;

    public SolicitudCreditoRta() {
        this.responseDocSolCreditos = new ArrayList<>();
    }

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getiNumRadic() {
        return iNumRadic;
    }

    public void setiNumRadic(Long iNumRadic) {
        this.iNumRadic = iNumRadic;
    }

    public Long getiCodCredito() {
        return iCodCredito;
    }

    public void setiCodCredito(Long iCodCredito) {
        this.iCodCredito = iCodCredito;
    }

    public String getsDescLineaCredito() {
        return sDescLineaCredito;
    }

    public void setsDescLineaCredito(String sDescLineaCredito) {
        this.sDescLineaCredito = sDescLineaCredito;
    }

    public Long getiCodPersona() {
        return iCodPersona;
    }

    public void setiCodPersona(Long iCodPersona) {
        this.iCodPersona = iCodPersona;
    }

    public String getsNombreAsociado() {
        return sNombreAsociado;
    }

    public void setsNombreAsociado(String sNombreAsociado) {
        this.sNombreAsociado = sNombreAsociado;
    }

    public Long getiCodigoPeriodicidad() {
        return iCodigoPeriodicidad;
    }

    public void setiCodigoPeriodicidad(Long iCodigoPeriodicidad) {
        this.iCodigoPeriodicidad = iCodigoPeriodicidad;
    }

    public String getsDescPeriodo() {
        return sDescPeriodo;
    }

    public void setsDescPeriodo(String sDescPeriodo) {
        this.sDescPeriodo = sDescPeriodo;
    }

    public Long getiCodTipoEstadoSolCred() {
        return iCodTipoEstadoSolCred;
    }

    public void setiCodTipoEstadoSolCred(Long iCodTipoEstadoSolCred) {
        this.iCodTipoEstadoSolCred = iCodTipoEstadoSolCred;
    }

    public String getsDecTipoEstadoSolCred() {
        return sDecTipoEstadoSolCred;
    }

    public void setsDecTipoEstadoSolCred(String sDecTipoEstadoSolCred) {
        this.sDecTipoEstadoSolCred = sDecTipoEstadoSolCred;
    }

    public BigDecimal getBdMontoSolCredito() {
        return bdMontoSolCredito;
    }

    public void setBdMontoSolCredito(BigDecimal bdMontoSolCredito) {
        this.bdMontoSolCredito = bdMontoSolCredito;
    }

    public BigInteger getBIPlazo() {
        return bIPlazo;
    }

    public void setBIPlazo(BigInteger bgPlazo) {
        this.bIPlazo = bgPlazo;
    }

    public BigDecimal getBdValorCuota() {
        return bdValorCuota;
    }

    public void setBdValorCuota(BigDecimal bdValorCuota) {
        this.bdValorCuota = bdValorCuota;
    }

    public String getsFechaSolCredito() {
        return sFechaSolCredito;
    }

    public void setsFechaSolCredito(String sFechaSolCredito) {
        this.sFechaSolCredito = sFechaSolCredito;
    }

    public void setResponseDocSolCreditos(List<ResponseDocSolCredito> responseDocSolCreditos) {
        this.responseDocSolCreditos = responseDocSolCreditos;
    }

    public List<ResponseDocSolCredito> getResponseDocSolCreditos() {
        return responseDocSolCreditos;
    }
}
