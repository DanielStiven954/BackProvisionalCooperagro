/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ResponseSubCategoriaPqrsf {
    
    private int codigo;
    private boolean flag;
    private String msm;
    List<SubCategoriaPqrsf> listaSubCategoriaPqrsf;

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

    public List<SubCategoriaPqrsf> getListaSubCategoriaPqrsf() {
        return listaSubCategoriaPqrsf;
    }

    public void setListaSubCategoriaPqrsf(List<SubCategoriaPqrsf> listaSubCategoriaPqrsf) {
        this.listaSubCategoriaPqrsf = listaSubCategoriaPqrsf;
    }
    
}
