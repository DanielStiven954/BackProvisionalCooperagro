/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.ebssystem.DatoDTO;
import java.util.List;

/**
 *
 * @author Brayan Moreno
 */
public class ResponseObligacionesTerminadas {
    
    private Boolean bRta;
    private String sMsjRta;
    private List<DatoDTO> listObligacionesTerminadas;

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

    public List<DatoDTO> getListObligacionesTerminadas() {
        return listObligacionesTerminadas;
    }

    public void setListObligacionesTerminadas(List<DatoDTO> listObligacionesTerminadas) {
        this.listObligacionesTerminadas = listObligacionesTerminadas;
    }
    
    
    
}
