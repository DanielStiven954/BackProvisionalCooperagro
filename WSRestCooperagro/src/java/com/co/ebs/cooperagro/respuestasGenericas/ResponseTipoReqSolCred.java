/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ResponseTipoReqSolCred {

    private Boolean bFlag;
    private String sMsj;
    private String sTipoArchivosPermitos;

    private List<TipoRequisitoSolCred> tipoRequisitoSolCredList;

    public Boolean getbFlag() {
        return bFlag;
    }

    public void setbFlag(Boolean bFlag) {
        this.bFlag = bFlag;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public String getsTipoArchivosPermitos() {
        return sTipoArchivosPermitos;
    }

    public void setsTipoArchivosPermitos(String sTipoArchivosPermitos) {
        this.sTipoArchivosPermitos = sTipoArchivosPermitos;
    }

    public List<TipoRequisitoSolCred> getTipoRequisitoSolCredList() {
        return tipoRequisitoSolCredList;
    }

    public void setTipoRequisitoSolCredList(List<TipoRequisitoSolCred> tipoRequisitoSolCredList) {
        this.tipoRequisitoSolCredList = tipoRequisitoSolCredList;
    }

}
