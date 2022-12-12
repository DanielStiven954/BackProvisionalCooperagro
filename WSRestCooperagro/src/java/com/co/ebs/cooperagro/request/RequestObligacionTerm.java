/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author Brayan Moreno
 */
public class RequestObligacionTerm {
    
    private String SCodigo;
    private String SNumRadic;
    private String SProducto;

    public String getSCodigo() {
        return SCodigo;
    }

    public void setSCodigo(String SCodigo) {
        this.SCodigo = SCodigo;
    }

    public String getSNumRadic() {
        return SNumRadic;
    }

    public void setSNumRadic(String SNumRadic) {
        this.SNumRadic = SNumRadic;
    }

    public String getSProducto() {
        return SProducto;
    }

    public void setSProducto(String SProducto) {
        this.SProducto = SProducto;
    }
    
}
