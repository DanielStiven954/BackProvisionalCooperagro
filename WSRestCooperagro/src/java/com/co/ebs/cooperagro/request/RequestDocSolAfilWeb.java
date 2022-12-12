/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.DocumentoSolAfilWeb;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RequestDocSolAfilWeb {
    
    private String CCursoCooperativismo;
    private String CDeclaracionRenta;
    private List<DocumentoSolAfilWeb> listaDocumentos;

    public String getCCursoCooperativismo() {
        return CCursoCooperativismo;
    }

    public void setCCursoCooperativismo(String CCursoCooperativismo) {
        this.CCursoCooperativismo = CCursoCooperativismo;
    }

    public String getCDeclaracionRenta() {
        return CDeclaracionRenta;
    }

    public void setCDeclaracionRenta(String CDeclaracionRenta) {
        this.CDeclaracionRenta = CDeclaracionRenta;
    }

    public List<DocumentoSolAfilWeb> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<DocumentoSolAfilWeb> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    

    @Override
    public String toString() {
        return "RequestDocSolAfilWeb{" + "CCursoCooperativismo=" + CCursoCooperativismo + ", CDeclaracionRenta=" + CDeclaracionRenta + ", ListaDocumentos=" + listaDocumentos + '}';
    }
    
    
    
}
