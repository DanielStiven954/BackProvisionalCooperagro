package com.co.ebs.cooperagro.request;

/**
 *
 * @author YO
 */
public class RequestListPregRta {

    private String sValueCampo;
    private String sValueRta;

    public String getsValueCampo() {
        return sValueCampo;
    }

    public void setsValueCampo(String sValueCampo) {
        this.sValueCampo = sValueCampo;
    }

    public String getsValueRta() {
        return sValueRta;
    }

    public void setsValueRta(String sValueRta) {
        this.sValueRta = sValueRta;
    }
    
    public String toString() {
        String resultado = "{";
        
        resultado += "sValueCampo: "+this.sValueCampo+",\n";
        resultado += "sValueRta: "+this.sValueRta+"\n";
        
        return resultado+"},\n";
    }
}
