/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.request;

import com.co.ebs.cooperagro.domain.ActEconomicaSolAfilWeb;
import com.co.ebs.cooperagro.domain.OperMonedaExtSolAfilWeb;

/**
 *
 * @author Administrador
 */
public class RequestEconomica {

    private ActEconomicaSolAfilWeb actEconomicaSolAfilWeb;
    private OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb;

    public ActEconomicaSolAfilWeb getActEconomicaSolAfilWeb() {
        return actEconomicaSolAfilWeb;
    }

    public void setActEconomicaSolAfilWeb(ActEconomicaSolAfilWeb actEconomicaSolAfilWeb) {
        this.actEconomicaSolAfilWeb = actEconomicaSolAfilWeb;
    }

    public OperMonedaExtSolAfilWeb getOperMonedaExtSolAfilWeb() {
        return operMonedaExtSolAfilWeb;
    }

    public void setOperMonedaExtSolAfilWeb(OperMonedaExtSolAfilWeb operMonedaExtSolAfilWeb) {
        this.operMonedaExtSolAfilWeb = operMonedaExtSolAfilWeb;
    }

    @Override
    public String toString() {
        return "RequestEconomica{" + "actEconomicaSolAfilWeb=" + actEconomicaSolAfilWeb + ", operMonedaExtSolAfilWeb=" + operMonedaExtSolAfilWeb + '}';
    }

    
}
