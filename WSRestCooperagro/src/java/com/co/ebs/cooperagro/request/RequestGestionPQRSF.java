/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.GestionPqrsf;
import java.util.Date;

/**
 *
 * @author YO
 */
public class RequestGestionPQRSF {

    private GestionPqrsf gestionPqrsf;
    private Long nuevoEstado;

    public GestionPqrsf getGestionPqrsf() {
        return gestionPqrsf;
    }

    public void setGestionPqrsf(GestionPqrsf gestionPqrsf) {
        this.gestionPqrsf = gestionPqrsf;
    }

    public Long getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(Long nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    

    @Override
    public String toString() {
        return "RequestGestionPQRSF{" + "gestionPqrsf=" + gestionPqrsf + ", nuevoEstado=" + nuevoEstado + '}';
    }

    
}
