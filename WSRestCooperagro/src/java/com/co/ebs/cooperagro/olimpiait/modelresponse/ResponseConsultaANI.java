/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.olimpiait.modelresponse;

import java.math.BigInteger;

/**
 *
 * @author Braya
 */
public class ResponseConsultaANI {
    
    private String idTransaccion;
    private String nuip;
    private String codigoErrorDatosCedula;
    private String primerApellido;
    private String particula;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String municipioExpedicion;
    private String departamentoExpedicion;
    private String fechaExpedicion;
    private BigInteger estadoCedula;
    private String numeroResolucion;
    private String anioResolucion;

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNuip() {
        return nuip;
    }

    public void setNuip(String nuip) {
        this.nuip = nuip;
    }

    public String getCodigoErrorDatosCedula() {
        return codigoErrorDatosCedula;
    }

    public void setCodigoErrorDatosCedula(String codigoErrorDatosCedula) {
        this.codigoErrorDatosCedula = codigoErrorDatosCedula;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getParticula() {
        return particula;
    }

    public void setParticula(String particula) {
        this.particula = particula;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getMunicipioExpedicion() {
        return municipioExpedicion;
    }

    public void setMunicipioExpedicion(String municipioExpedicion) {
        this.municipioExpedicion = municipioExpedicion;
    }

    public String getDepartamentoExpedicion() {
        return departamentoExpedicion;
    }

    public void setDepartamentoExpedicion(String departamentoExpedicion) {
        this.departamentoExpedicion = departamentoExpedicion;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public BigInteger getEstadoCedula() {
        return estadoCedula;
    }

    public void setEstadoCedula(BigInteger estadoCedula) {
        this.estadoCedula = estadoCedula;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public String getAnioResolucion() {
        return anioResolucion;
    }

    public void setAnioResolucion(String anioResolucion) {
        this.anioResolucion = anioResolucion;
    }

    @Override
    public String toString() {
        return "ResponseConsultaANI{" + "idTransaccion=" + idTransaccion + ", nuip=" + nuip + ", codigoErrorDatosCedula=" + codigoErrorDatosCedula + ", primerApellido=" + primerApellido + ", particula=" + particula + ", segundoApellido=" + segundoApellido + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", municipioExpedicion=" + municipioExpedicion + ", departamentoExpedicion=" + departamentoExpedicion + ", fechaExpedicion=" + fechaExpedicion + ", estadoCedula=" + estadoCedula + ", numeroResolucion=" + numeroResolucion + ", anioResolucion=" + anioResolucion + '}';
    }
    
    
    
    
}
