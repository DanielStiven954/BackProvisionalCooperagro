/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.respuestasGenericas;

import com.ebssystem.DatoDTO;
import java.util.List;

/**
 *
 * @author Braya
 */
public class ResponseEstadoCuenta {

    private Boolean consultaExitosa;
    private String sMsgProceso;
    private String deudaCreditos;
    private String misAportes;
    private List<DatoDTO> listCreditos;
    private List<DatoDTO> listAportes;
    private List<DatoDTO> listServicios;

    public Boolean getConsultaExitosa() {
        return consultaExitosa;
    }

    public void setConsultaExitosa(Boolean consultaExitosa) {
        this.consultaExitosa = consultaExitosa;
    }

    public String getsMsgProceso() {
        return sMsgProceso;
    }

    public void setsMsgProceso(String sMsgProceso) {
        this.sMsgProceso = sMsgProceso;
    }

    public String getDeudaCreditos() {
        return deudaCreditos;
    }

    public void setDeudaCreditos(String deudaCreditos) {
        this.deudaCreditos = deudaCreditos;
    }

    public String getMisAportes() {
        return misAportes;
    }

    public void setMisAportes(String misAportes) {
        this.misAportes = misAportes;
    }

    public List<DatoDTO> getListCreditos() {
        return listCreditos;
    }

    public void setListCreditos(List<DatoDTO> listCreditos) {
        this.listCreditos = listCreditos;
    }

    public List<DatoDTO> getListAportes() {
        return listAportes;
    }

    public void setListAportes(List<DatoDTO> listAportes) {
        this.listAportes = listAportes;
    }

    public List<DatoDTO> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<DatoDTO> listServicios) {
        this.listServicios = listServicios;
    }
}
