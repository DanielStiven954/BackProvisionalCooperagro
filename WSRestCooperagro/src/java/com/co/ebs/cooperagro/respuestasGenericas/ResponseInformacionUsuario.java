/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.ebssas.PersonasDTO;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class ResponseInformacionUsuario {
    private int codigo;
    private boolean flag;
    private String msm;
    private PersonasDTO persona;
    private List<DatoPersona> listUsuarios;

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

    public PersonasDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonasDTO persona) {
        this.persona = persona;
    }

    public List<DatoPersona> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<DatoPersona> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
    
    
}
