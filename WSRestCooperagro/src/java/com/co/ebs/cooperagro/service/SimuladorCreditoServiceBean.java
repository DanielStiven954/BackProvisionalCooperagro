/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseCupoMaximo;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSimuladorCredito;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSimuladorCreditoAtr;
import com.co.ebs.cooperagro.wscore.WSSimuladorCredito;
import com.ebssas.PersonasDTO;
import com.google.gson.Gson;
import wssimuladorcredito.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Braya
 */
public class SimuladorCreditoServiceBean implements SimuladorCreditoService {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sBDCore = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
    private final String sUserCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
    private final String sPassCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");
    private final WSSimuladorCredito wsSimuladorCredito = new WSSimuladorCredito();
    private AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
    private final utilidad util = new utilidad();
    private final Gson gson = new Gson();

    @Override
    public RespuestaCupo calculoCupos(String pwsIdentific, String pwsFormPeriodic, String pwsCodCredi, String pwsFormPlazo, String pwsformpag) {
        return this.wsSimuladorCredito.calculoCupos(pwsIdentific, pwsFormPeriodic, pwsCodCredi, pwsFormPlazo,pwsformpag, this.sBDCore, this.sUserCore, this.sPassCore);
    }

    @Override
    public ResponseCupoMaximo calcularCupoMaximo(String pwsIdentific, String pwsCodCredi, String pwsFormPeriodic, String codPersona, String pwsformpag) {
        ResponseCupoMaximo responseCupoMaximo = new ResponseCupoMaximo();
        if (pwsCodCredi != null && !pwsCodCredi.equals("")) {
            String descPeriodicidad = this.adminCoreServiceBean.getDescPeriodo(new Long(pwsFormPeriodic));
            RespuestaCupo respuestaCupo = this.calculoCupos(pwsIdentific, descPeriodicidad, pwsCodCredi, descPeriodicidad,pwsformpag);
            try {
                if (respuestaCupo != null && respuestaCupo.getRSMaxMonto() != null && !respuestaCupo.getRSMaxMonto().equals("")) {

                    String sMontoFormat = util.valorPattern(respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setbRta(Boolean.TRUE);
                    responseCupoMaximo.setsMsj("El plazo maximo asignado es de " + respuestaCupo.getRSMaxPlazo() + " meses. El cupo máximo asignado para su solictud es de $" + sMontoFormat);
                    responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());

//		    responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());
                } else {
                    responseCupoMaximo.setbRta(Boolean.FALSE);
                    responseCupoMaximo.setsMsj("El valor de la solicitud esta sujeto a verificación por parte de la entidad.");
                    responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
//		    responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());

                }
            } catch (Exception e) {
                e.printStackTrace();
                responseCupoMaximo.setbRta(Boolean.FALSE);
                responseCupoMaximo.setsMsj("No se ha podido obtener el cupo máximo, por favor intente de nuevo.");
                responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
//		responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());
            }
        } else {
        }

        return responseCupoMaximo;
    }

    @Override
    public ResponseSimuladorCredito simuladorValorCuota(String pwsMonto, String pwsNroCuotas, String pwsValRecog, String pwsCodCredi, String pwsIdentific, String pwsFormPeriodic,String pwsformapago, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3) {
        ResponseSimuladorCredito responseSimuladorCredito = new ResponseSimuladorCredito();
        String sFechaSol = util.dateToStringFormatFechaMesDiaAnio(new Date());
        String descPeriodicidad = this.adminCoreServiceBean.getDescPeriodo(new Long(pwsFormPeriodic));
        Respuesta respuesta = this.wsSimuladorCredito.liqSimuladorCredito(pwsMonto, pwsNroCuotas, sFechaSol, pwsValRecog, pwsCodCredi, descPeriodicidad, pwsIdentific, descPeriodicidad,pwsformapago, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, sBDCore, sUserCore, sPassCore);
        if (respuesta.getRSMensaje() != null && respuesta.getRSMensaje().equals("")) {
            responseSimuladorCredito.setbRta(Boolean.TRUE);
            responseSimuladorCredito.setsMsj("Se ha realizado correctamente la simulación del valor de la cuota.");
            String sValorCuotaAsoc = respuesta.getRValCuota();
            if (sValorCuotaAsoc != null && !sValorCuotaAsoc.equals("")) {
                if (sValorCuotaAsoc.contains(",")) {
                    sValorCuotaAsoc = sValorCuotaAsoc.replace(",", ".");
                }
            }
            if (respuesta.getRSTasa() != null && respuesta.getRSTasa() != "") {
                responseSimuladorCredito.setsTasa(respuesta.getRSTasa());

            }
            Double dValorCuota = new Double(sValorCuotaAsoc);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(4, RoundingMode.HALF_EVEN);
            responseSimuladorCredito.setBdValorCuota(bdValorCuota);

            respuesta.getRLiquidacion().getLiquidacion().forEach(liquidacion -> {
                liquidacion.setNCapital(liquidacion.getNCapital().replaceAll(",00", ""));
                liquidacion.setNSalIni(liquidacion.getNSalIni().replaceAll(",00", ""));
                liquidacion.setNSalFin(liquidacion.getNSalFin().replaceAll(",00", ""));
                liquidacion.setNTotal(liquidacion.getNTotal().replaceAll(",00", ""));
                liquidacion.setNIntTf(liquidacion.getNIntTf().replaceAll(",00", ""));
            });

            responseSimuladorCredito.setrLiquidacion(respuesta.getRLiquidacion());
        } else {
            responseSimuladorCredito.setbRta(Boolean.FALSE);
            responseSimuladorCredito.setsMsj("No se ha obtenido ningun valor para la cuota. Intente cambiando los valores de periodicidad, plazo y valor de la solicitud.");
            Double dValorCuota = new Double(0.00);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(2, RoundingMode.HALF_EVEN);
            responseSimuladorCredito.setBdValorCuota(bdValorCuota);
            if (respuesta.getRSTasa() != null && respuesta.getRSTasa() != "") {
                responseSimuladorCredito.setsTasa(respuesta.getRSTasa());
            }
        }
        return responseSimuladorCredito;
    }

    public ResponseSimuladorCreditoAtr simuladorValorCuotaAtr(String pwsMonto, String pwsNroCuotas, String pwsValRecog, String pwsCodCredi, String pwsIdentific, String pwsFormPeriodic, String pwsformapago, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3) {
        ResponseSimuladorCreditoAtr responseSimuladorCredito = new ResponseSimuladorCreditoAtr();
        String sFechaSol = util.dateToStringFormatFechaMesDiaAnio(new Date());
        String descPeriodicidad = this.adminCoreServiceBean.getDescPeriodo(new Long(pwsFormPeriodic));
            
       
        System.err.println("pwsMonto: "+pwsMonto);
        System.err.println("pwsNroCuotas: "+pwsNroCuotas);
        System.err.println("sFechaSol: "+sFechaSol);
        System.err.println("pwsValRecog: "+pwsValRecog);
        System.err.println("pwsCodCredi: "+pwsCodCredi);
        System.err.println("descPeriodicidad: "+descPeriodicidad);
        System.err.println("pwsformapago: "+pwsformapago);
        System.err.println("pwsValTf1: "+pwsValTf1);
        System.err.println("pwsFecTf1: "+pwsFecTf1);
        System.err.println("pwsValTf2: "+pwsValTf2);
        System.err.println("pwsFecTf2: "+pwsFecTf2);
        System.err.println("pwsValTf3: "+pwsValTf3);
        System.err.println("pwsFecTf3: "+pwsFecTf3);
        System.err.println("sBDCore: "+sBDCore);
        System.err.println("sUserCore: "+sUserCore);
        System.err.println("sPassCore: "+sPassCore);    
        RespuestaAtr respuesta = this.wsSimuladorCredito.liqSimuladorCreditoAtr(pwsMonto, pwsNroCuotas, sFechaSol, pwsValRecog, pwsCodCredi, descPeriodicidad, pwsIdentific, descPeriodicidad,pwsformapago, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, sBDCore, sUserCore, sPassCore);
        System.err.println("sPassCore: "+respuesta.getRLiquidacion().getLiquidacionAtr().isEmpty()); 
        System.err.println("sPassCore: "+respuesta.getRLiquidacion().getLiquidacionAtr().size());         
        if (!respuesta.getRLiquidacion().getLiquidacionAtr().isEmpty() && respuesta.getRLiquidacion().getLiquidacionAtr().size() == Integer.parseInt(pwsNroCuotas)) {
            responseSimuladorCredito.setbRta(Boolean.TRUE);
            responseSimuladorCredito.setsMsj("Se ha realizado correctamente la simulación del valor de la cuota.");
            String sValorCuotaAsoc = respuesta.getRValCuota();
            if (sValorCuotaAsoc != null && !sValorCuotaAsoc.equals("")) {
                if (sValorCuotaAsoc.contains(",")) {
                    sValorCuotaAsoc = sValorCuotaAsoc.replace(",", ".");
                }
            }

            Double dValorCuota = new Double(sValorCuotaAsoc);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(4, RoundingMode.HALF_EVEN);

            responseSimuladorCredito.setBdValorCuota(bdValorCuota);

            String sValorTasa = respuesta.getRSTasa();

            if (sValorTasa != null && sValorTasa != "") {
                if (sValorTasa.contains(",")) {
                    sValorTasa = sValorTasa.replace(",", ".");
                }

            }
            Double dValorTasa = new Double(sValorTasa);
            BigDecimal bdValorTasa = new BigDecimal(dValorTasa);
            bdValorTasa = bdValorTasa.setScale(2, RoundingMode.FLOOR);
            responseSimuladorCredito.setsTasa(String.valueOf(bdValorTasa));

            respuesta.getRLiquidacion().getLiquidacionAtr().forEach(liquidacion -> {
                liquidacion.setNCapital(liquidacion.getNCapital().replaceAll(",00", ""));
                liquidacion.setNSalIni(liquidacion.getNSalIni().replaceAll(",00", ""));
                liquidacion.setNSalFin(liquidacion.getNSalFin().replaceAll(",00", ""));
                liquidacion.setNTotal(liquidacion.getNTotal().replaceAll(",00", ""));
                liquidacion.setNIntTf(liquidacion.getNIntTf().replaceAll(",00", ""));
                liquidacion.setNInt1(liquidacion.getNInt1().replaceAll(",00", ""));
                liquidacion.setNInt2(liquidacion.getNInt2().replaceAll(",00", ""));
                liquidacion.setNInt3(liquidacion.getNInt3().replaceAll(",00", ""));
            });

            responseSimuladorCredito.setrLiquidacion(respuesta.getRLiquidacion());
        } else {
            responseSimuladorCredito.setbRta(Boolean.FALSE);
            responseSimuladorCredito.setsMsj("No se ha obtenido ningun valor para la cuota. Intente cambiando los valores de periodicidad, plazo y valor de la solicitud.");
            Double dValorCuota = new Double(0.00);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(4, RoundingMode.HALF_EVEN);
            responseSimuladorCredito.setBdValorCuota(bdValorCuota);
            if (respuesta.getRSTasa() != null && respuesta.getRSTasa() != "") {
                responseSimuladorCredito.setsTasa(respuesta.getRSTasa());
            }
        }
        return responseSimuladorCredito;
    }

    @Override
    public String docAutorizacionDesembolsoToJSON(String pwsNumRadic, Long idSolCred) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String docCartaInstruccionesToJSON(String pwsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String docPagareCreditoToJSON(String pwsNumRadi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String docPlanPagosToJSON(String pwsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Object> crearCreditoCygnus(String pwsMonto, String pwsNroCuotas, String pwsCodCredi, String pwsFormPeriodic, String pwsIdentific, String pwsNumSolicitud, String pwsEstadoCredito, String pwsEstadoSolicitud, String pwsDescripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
