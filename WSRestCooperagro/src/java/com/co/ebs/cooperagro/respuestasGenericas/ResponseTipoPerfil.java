/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.TipoPerfil;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class ResponseTipoPerfil {
    private int codigo;
    private boolean flag;
    private String msm;
    List<TipoPerfil> listaTipoPerfil;

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public List<TipoPerfil> getListaTipoPerfil()
    {
        return listaTipoPerfil;
    }

    public void setListaTipoPerfil(List<TipoPerfil> listaTipoPerfil)
    {
        this.listaTipoPerfil = listaTipoPerfil;
    }

    public String getMsm()
    {
        return msm;
    }

    public void setMsm(String msm)
    {
        this.msm = msm;
    }
    
    
}
