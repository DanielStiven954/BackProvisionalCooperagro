package com.co.ebs.cooperagro.request;

import java.util.Date;

public class RequestFotoPerfil 
{
    public Date     fFechaSubida;     
    public String   cNombre;    
    public int      iTamanio;         
    public String   cTipo;    
    public String   bImgBytes;
    public int      iTipoIdent;
    public String   cIdentificacion;  
    public String   cEstado; 
    
    public RequestFotoPerfil(){}

    public Date getfFechaSubida() {
        return fFechaSubida;
    }

    public void setfFechaSubida(Date fFechaSubida) {
        this.fFechaSubida = fFechaSubida;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public int getiTamanio() {
        return iTamanio;
    }

    public void setiTamanio(int iTamanio) {
        this.iTamanio = iTamanio;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    public String getbImgBytes() {
        return bImgBytes;
    }

    public void setbImgBytes(String bImgBytes) {
        this.bImgBytes = bImgBytes;
    }

    public int getiTipoIdent() {
        return iTipoIdent;
    }

    public void setiTipoIdent(int iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getcIdentificacion() {
        return cIdentificacion;
    }

    public void setcIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }
}
