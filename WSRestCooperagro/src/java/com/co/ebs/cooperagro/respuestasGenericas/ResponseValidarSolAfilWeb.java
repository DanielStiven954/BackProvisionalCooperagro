/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;

/**
 *
 * @author JONATHAN RUGE
 */
public class ResponseValidarSolAfilWeb {
    
    private Boolean bRta;
    private String sMsj;
    private Long iCodigoR;
    private SolicitudAfiliacionWeb solAfilWeb;

    public Boolean getbRta()
    {
        return bRta;
    }

    public void setbRta(Boolean bRta)
    {
        this.bRta = bRta;
    }

    public String getsMsj()
    {
        return sMsj;
    }

    public void setsMsj(String sMsj)
    {
        this.sMsj = sMsj;
    }

    public Long getiCodigoR()
    {
        return iCodigoR;
    }

    public void setiCodigoR(Long iCodigoR)
    {
        this.iCodigoR = iCodigoR;
    }

    public SolicitudAfiliacionWeb getSolAfilWeb()
    {
        return solAfilWeb;
    }

    public void setSolAfilWeb(SolicitudAfiliacionWeb solAfilWeb)
    {
        this.solAfilWeb = solAfilWeb;
    }
    
    
    
}
