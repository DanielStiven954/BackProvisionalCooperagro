/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author Administrador
 */
public class RequestEstadoSolAfilWeb {

    private Long lCodSolicitud;
    private String abreviatura;
    private String observaciones;
    private Long lUsuario;

    public Long getlCodSolicitud() {
        return lCodSolicitud;
    }

    public void setlCodSolicitud(Long lCodSolicitud) {
        this.lCodSolicitud = lCodSolicitud;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getlUsuario() {
        return lUsuario;
    }

    public void setlUsuario(Long lUsuario) {
        this.lUsuario = lUsuario;
    }
    
    

}
