/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "AUDITORIA_SOL_AFIL_WEB")
@XmlRootElement
public class AuditoriaSolAfilWeb implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_AUDITORIA_SOL_AFIL_WEB", sequenceName = "SEQ_AUDITORIA_SOL_AFIL_WEB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUDITORIA_SOL_AFIL_WEB")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @NotNull
    @Size(max = 100)
    @Column(name = "C_IP")
    private String cIp;
    
    @NotNull
    @Size(max = 400)
    @Column(name = "C_NAVEGADOR")
    private String cNavegador;
    
    @Column(name = "F_FECHA_SISTEMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSistema;
    
    @JoinColumn(name = "I_AUTORIZACION_SOL_AFIL_WEB", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AutorizacionSolAfilWeb iAutorizacionSolAfilWeb;

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCIp() {
        return cIp;
    }

    public void setCIp(String cIp) {
        this.cIp = cIp;
    }

    public String getCNavegador() {
        return cNavegador;
    }

    public void setCNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public AutorizacionSolAfilWeb getIAutorizacionSolAfilWeb() {
        return iAutorizacionSolAfilWeb;
    }

    public Date getfFechaSistema() {
        return fFechaSistema;
    }

    public void setfFechaSistema(Date fFechaSistema) {
        this.fFechaSistema = fFechaSistema;
    }
    
    

    public void setIAutorizacionSolAfilWeb(AutorizacionSolAfilWeb iAutorizacionSolAfilWeb) {
        this.iAutorizacionSolAfilWeb = iAutorizacionSolAfilWeb;
    }

    @Override
    public String toString() {
        return "AuditoriaSolAfilWeb{" + "iCodigo=" + iCodigo + ", cIp=" + cIp + ", cNavegador=" + cNavegador + ", iSolAfiliacionWeb=" + iAutorizacionSolAfilWeb + '}';
    }
    
    
}
