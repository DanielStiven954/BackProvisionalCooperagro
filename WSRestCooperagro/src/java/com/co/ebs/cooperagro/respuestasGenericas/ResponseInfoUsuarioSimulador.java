/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.ebssas.PersonasDTO;

/**
 *
 * @author Administrador
 */
public class ResponseInfoUsuarioSimulador {

    private Boolean bRta;
    private String sMjs;
    private int iCodigo;
    private PersonasDTO personaDTO;
    private PersonasDTO empresaDTO;

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMjs() {
        return sMjs;
    }

    public void setsMjs(String sMjs) {
        this.sMjs = sMjs;
    }

    public int getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    public PersonasDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonasDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public PersonasDTO getEmpresaDTO() {
        return empresaDTO;
    }

    public void setEmpresaDTO(PersonasDTO empresaDTO) {
        this.empresaDTO = empresaDTO;
    }

}
