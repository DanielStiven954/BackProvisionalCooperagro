/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.TipoEstadoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public class ResponseTipoEstadoPqrsf {
    
    private int iCodigo;
    private Boolean bRta;
    private List<TipoEstadoPqrsf> lista;

    public int getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public List<TipoEstadoPqrsf> getLista() {
        return lista;
    }

    public void setLista(List<TipoEstadoPqrsf> lista) {
        this.lista = lista;
    }
        
}
