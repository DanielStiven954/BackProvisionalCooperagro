/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.TipoPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public class ResponseTipoPQRSF {
    
    private int codigo;
    private boolean flag;
    private String msm;
    List<TipoPqrsf> listaTipoPQRSF;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }

    public List<TipoPqrsf> getListaTipoPQRSF() {
        return listaTipoPQRSF;
    }

    public void setListaTipoPQRSF(List<TipoPqrsf> listaTipoPerfil) {
        this.listaTipoPQRSF = listaTipoPerfil;
    }
    
    
}
