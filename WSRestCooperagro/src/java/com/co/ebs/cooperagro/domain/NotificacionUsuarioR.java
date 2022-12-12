/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Jonathan Ruge
 */
public class NotificacionUsuarioR {
    private Long iCodigo;
    private String cTitulo;
    private String cDescripcion;
    private BigInteger iDuracion;
    private Date fFecha;
    private String cEstado;

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getcTitulo() {
        return cTitulo;
    }

    public void setcTitulo(String cTitulo) {
        this.cTitulo = cTitulo;
    }

    public BigInteger getiDuracion() {
        return iDuracion;
    }

    public void setiDuracion(BigInteger iDuracion) {
        this.iDuracion = iDuracion;
    }

    public Date getfFecha() {
        return fFecha;
    }

    public void setfFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }
    
    
}
