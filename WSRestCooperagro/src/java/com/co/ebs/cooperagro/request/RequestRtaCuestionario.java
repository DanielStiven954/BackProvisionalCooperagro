/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import java.util.List;

/**
 *
 * @author YO
 */
public class RequestRtaCuestionario {
    
    
    private String sTipoIdentificacion;
    private String sCIdentificacion;
    private String sTipoCanal;
    private List<RequestListPregRta> requestListPregRta;

    public String getsTipoIdentificacion() {
        return sTipoIdentificacion;
    }

    public void setsTipoIdentificacion(String sTipoIdentificacion) {
        this.sTipoIdentificacion = sTipoIdentificacion;
    }

    public String getsCIdentificacion() {
        return sCIdentificacion;
    }

    public void setsCIdentificacion(String sCIdentificacion) {
        this.sCIdentificacion = sCIdentificacion;
    }

    public String getsTipoCanal() {
        return sTipoCanal;
    }

    public void setsTipoCanal(String sTipoCanal) {
        this.sTipoCanal = sTipoCanal;
    }

    public List<RequestListPregRta> getRequestListPregRta() {
        return requestListPregRta;
    }

    public void setRequestListPregRta(List<RequestListPregRta> requestListPregRta) {
        this.requestListPregRta = requestListPregRta;
    }
   
    public String toString() {
        String resultado = "{\n";
        
        resultado += "sTipoIdentificacion: " +this.sTipoIdentificacion+",\n";
        resultado += "sCIdentificacion: "    +this.sCIdentificacion+",\n";
        resultado += "sTipoCanal: "          +this.sTipoCanal+",\n";
        
        resultado += "[\n";
        for(RequestListPregRta pr : this.requestListPregRta)
            resultado += pr.toString()+"\n";
        resultado += "]\n";
        
        return resultado+"}\n";
    }
}
