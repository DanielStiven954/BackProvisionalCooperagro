/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

/**
 *
 * @author EBS_OPER_17
 */
public class DatoPersona {
    private Long iCodUsuario;
    private Long iCodPersona;
    private String sNombres;
    private String sApellidos;
    private String cIdentificacion;
    private String cEstado;
    private String cTipoIdentificacion;

    public Long getiCodUsuario() {
        return iCodUsuario;
    }

    public void setiCodUsuario(Long iCodUsuario) {
        this.iCodUsuario = iCodUsuario;
    }

    public Long getiCodPersona() {
        return iCodPersona;
    }

    public void setiCodPersona(Long iCodPersona) {
        this.iCodPersona = iCodPersona;
    }

    public String getsNombres() {
        return sNombres;
    }

    public void setsNombres(String sNombres) {
        this.sNombres = sNombres;
    }

    public String getsApellidos() {
        return sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
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

    public String getcTipoIdentificacion() {
        return cTipoIdentificacion;
    }

    public void setcTipoIdentificacion(String cTipoIdentificacion) {
        this.cTipoIdentificacion = cTipoIdentificacion;
    }
    
    
}
