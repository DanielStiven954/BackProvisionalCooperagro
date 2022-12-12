/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.GestionPqrsf;
import com.co.ebs.cooperagro.domain.Pqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public class ResponsePqrsf {

    private int iCodigo;
    private Boolean bRta;
    private String sMsjRta;
    private Pqrsf pqrsf;
    private List<GestionPqrsf> listGestionPqrsf;

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

    public String getsMsjRta() {
        return sMsjRta;
    }

    public void setsMsjRta(String sMsjRta) {
        this.sMsjRta = sMsjRta;
    }

    public Pqrsf getPqrsf() {
        return pqrsf;
    }

    public void setPqrsf(Pqrsf pqrsf) {
        this.pqrsf = pqrsf;
    }

    public List<GestionPqrsf> getListGestionPqrsf() {
        return listGestionPqrsf;
    }

    public void setListGestionPqrsf(List<GestionPqrsf> listGestionPqrsf) {
        this.listGestionPqrsf = listGestionPqrsf;
    }

    
}
