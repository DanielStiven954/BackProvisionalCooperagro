/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

/**
 *
 * @author Juan Sebastian F
 */
public class RequestConyuge {
    
    private String Nombre;
    private String Apellido;
    private String I_usuario;
    private String Identificacion_Conyuge;
    private String Direccion;
    private String Telefono;
    private String Celular;

    public RequestConyuge(String Nombre, String Apellido, String I_usuario, String Identificacion_Conyuge, String Direccion, String Telefono, String Celular) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.I_usuario = I_usuario;
        this.Identificacion_Conyuge = Identificacion_Conyuge;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Celular = Celular;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getI_usuario() {
        return I_usuario;
    }

    public void setI_usuario(String I_usuario) {
        this.I_usuario = I_usuario;
    }

    public String getIdentificacion_Conyuge() {
        return Identificacion_Conyuge;
    }

    public void setIdentificacion_Conyuge(String Identificacion_Conyuge) {
        this.Identificacion_Conyuge = Identificacion_Conyuge;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    @Override
    public String toString() {
        return "RequestConyuge{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", I_usuario=" + I_usuario + ", Identificacion_Conyuge=" + Identificacion_Conyuge + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Celular=" + Celular + '}';
    }

    
}
