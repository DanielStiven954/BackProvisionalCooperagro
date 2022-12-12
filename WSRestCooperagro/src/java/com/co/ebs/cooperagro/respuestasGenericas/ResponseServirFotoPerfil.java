/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import java.util.Date;

/**
 *
 * @author Andrés Sierra
 */
public class ResponseServirFotoPerfil {

    private Boolean bRta;
    private String  sMsj;
    private long    iCodigo;
    private String  cNombre;
    private String  cTipo;
    private long    iTamanio;
    private Date    fSubida;
    private String  cEstado;
    private String  url64Imagen;

    public ResponseServirFotoPerfil() {}

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    public long getiTamanio() {
        return iTamanio;
    }

    public void setiTamanio(long iTamanio) {
        this.iTamanio = iTamanio;
    }

    public Date getfSubida() {
        return fSubida;
    }

    public void setfSubida(Date fSubida) {
        this.fSubida = fSubida;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getUrl64Imagen() {
        return url64Imagen;
    }

    public void setUrl64Imagen(String url64Imagen) {
        this.url64Imagen = url64Imagen;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResponseServirFotoPerfil other = (ResponseServirFotoPerfil) obj;
        if (this.iCodigo != other.iCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "respuestaGenerica{" + "iCodigo=" + iCodigo + '}';
    }

}
