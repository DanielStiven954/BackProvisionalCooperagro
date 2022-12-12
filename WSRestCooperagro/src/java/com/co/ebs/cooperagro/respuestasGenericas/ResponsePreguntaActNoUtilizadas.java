package com.co.ebs.cooperagro.respuestasGenericas;

import com.co.ebs.cooperagro.domain.Pregunta;
import java.util.List;

public class ResponsePreguntaActNoUtilizadas 
{
    private int iCodigo;
    private Boolean bRta;
    private String sMsjRta;
    private List<Pregunta> preguntasActNoUtilizadas;

    public int getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsjRta() {
        return sMsjRta;
    }

    public void setsMsjRta(String sMsjRta) {
        this.sMsjRta = sMsjRta;
    }

    public List<Pregunta> getPreguntasActNoUtilizadas() {
        return preguntasActNoUtilizadas;
    }

    public void setPreguntasActNoUtilizadas(List<Pregunta> preguntasActNoUtilizadas) {
        this.preguntasActNoUtilizadas = preguntasActNoUtilizadas;
    }
    
    
}
