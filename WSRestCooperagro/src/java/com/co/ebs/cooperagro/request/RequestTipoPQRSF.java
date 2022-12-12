/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author YO
 */
public class RequestTipoPQRSF {
    
    private Long iCodigo;
    private String cDescripcion;
    private String cEstado;

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }
    
    
}
