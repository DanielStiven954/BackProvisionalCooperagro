/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.olimpiait.modelapi;

/**
 *
 * @author Brayan F Silva R
 */
public class ConsultaANI {

    private String idProcesoCliente;
    private String documento;
    private String tipoDocumento;

    public String getIdProcesoCliente() {
        return idProcesoCliente;
    }

    public void setIdProcesoCliente(String idProcesoCliente) {
        this.idProcesoCliente = idProcesoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
