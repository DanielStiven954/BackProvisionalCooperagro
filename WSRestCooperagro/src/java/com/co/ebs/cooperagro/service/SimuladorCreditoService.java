/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.*;
import wssimuladorcredito.*;
import java.util.HashMap;

/**
 *
 * @author Brayan F Silva R
 */
public interface SimuladorCreditoService {

    RespuestaCupo calculoCupos(String pwsIdentific, String pwsFormPeriodic, String pwsCodCredi, String pwsFormPlazo, String pwsformpag);

    ResponseCupoMaximo calcularCupoMaximo(String pwsIdentific, String pwsCodCredi, String pwsFormPeriodic, String codPersona, String pwsformpag);

    ResponseSimuladorCredito simuladorValorCuota(String pwsMonto, String pwsNroCuotas, String pwsValRecog, String pwsCodCredi, String pwsIdentific, String pwsFormPeriodic,String pwsformapago, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3);

    String docAutorizacionDesembolsoToJSON(String pwsNumRadic, Long idSolCred);

    String docCartaInstruccionesToJSON(String pwsNumRadic);

    String docPagareCreditoToJSON(String pwsNumRadi);

    String docPlanPagosToJSON(String pwsNumRadic);
    
    HashMap<String, Object> crearCreditoCygnus(String pwsMonto, String pwsNroCuotas, String pwsCodCredi, String pwsFormPeriodic, String pwsIdentific, String pwsNumSolicitud,
            String pwsEstadoCredito,
            String pwsEstadoSolicitud,
            String pwsDescripcion);
}
