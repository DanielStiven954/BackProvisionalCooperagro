package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearPDF;
import com.co.ebs.cooperagro.request.RequestDetalle;
import com.co.ebs.cooperagro.request.RequestObligacionTerm;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseEstadoCuenta;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.wscore.wsEstadoCuenta;
import com.ebssystem.DatoDTO;
import com.ebssystem.Movimiento;
import com.ebssystem.DetalleCta;
import com.ebssystem.Movimiento;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public class EstadoCuentaCoreServiceBean implements EstadoCuentaCoreService {

    private final wsEstadoCuenta wsEstadoCuentaCore = new wsEstadoCuenta();
    private final UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();

    @Override
    public List<DatoDTO> wsConsultarEstadoCuenta(String xiTipoIden, String xcIdentificacion, String xcProducto) {
        List<DatoDTO> response = new ArrayList<>();
        try {
            response = wsEstadoCuentaCore.wsConsultarEstadoCuenta(xiTipoIden, xcIdentificacion, xcProducto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public List<DatoDTO> wsConsultarEstadoCuenta(int xiCodUser, String xcProducto) {
        List<DatoDTO> listCuentasByPersona = new ArrayList<>();
        String sCodUser = String.valueOf(xiCodUser);
        Long lCodUser = new Long(sCodUser);

        Usuario findUsuarioById = usuarioServiceBean.findUsuarioById(lCodUser);
        if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
            BigInteger bgITipoIdent = findUsuarioById.getIPersona().getITipoIdent();
            String sITipoIdent = String.valueOf(bgITipoIdent);
            String sIdentPersona = findUsuarioById.getIPersona().getCIdentificacion();
            listCuentasByPersona = wsEstadoCuentaCore.wsConsultarEstadoCuenta(sITipoIdent, sIdentPersona, xcProducto);
        }
        return listCuentasByPersona;
    }

//    @Override
//    public DetalleCta wsConsultaDetalleCtaCredito(String xsNumRadic) {
//        DetalleCta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, "1");
//        detalleCtaCredito.setSDescFormaPago(detalleCtaCredito.getSDescFormaPago().equals("Nomina") ? "Nómina" : detalleCtaCredito.getSDescFormaPago());
//        return detalleCtaCredito;
//    }

    /*@Override
    public Detallecta wsConsultaDetalleCta(String xsNumRadic, String xcProducto) {
        Detallecta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, xcProducto);
        return detalleCtaCredito;
    }*/

   /* @Override
    public DetalleCta wsConsultaDetalleCtaAporte(String xsNumRadic) {
        DetalleCta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, "2");
        detalleCtaCredito.setSDescFormaPago(detalleCtaCredito.getSDescFormaPago().equals("Nomina") ? "Nómina" : detalleCtaCredito.getSDescFormaPago());
        return detalleCtaCredito;
    }

    public RequestDetalle wsConsultaDetalleCtaAporteAmp(String xsNumRadic) {
        RequestDetalle detalleAporte = new RequestDetalle();
        DetalleCta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, "2");
        detalleCtaCredito.setSDescFormaPago(detalleCtaCredito.getSDescFormaPago().equals("Nomina") ? "Nómina" : detalleCtaCredito.getSDescFormaPago());
        detalleAporte.setDetalleCta(detalleCtaCredito);
        if (detalleCtaCredito.getINumAparados() != 0) {
            List<Detallemov> detalleAmparado = wsEstadoCuentaCore.wsConsultarDatosAmparadosBeneficiario(xsNumRadic, "2");
            detalleAporte.setDetalleAmparadoBenef(detalleAmparado);
        }
        return detalleAporte;
    }*/

    /*@Override
    public Detallecta wsConsultaDetalleCtaServicio(String xsNumRadic) {
        Detallecta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, "8");
        detalleCtaCredito.setSDescFormaPago(detalleCtaCredito.getSDescFormaPago().equals("Nomina") ? "Nómina" : detalleCtaCredito.getSDescFormaPago());
        return detalleCtaCredito;
    }*/
/*    
    public RequestDetalle wsConsultaDetalleCtaServicioBenef(String xsNumRadic) {
        RequestDetalle detalleAporte = new RequestDetalle();
        Detallecta detalleCtaCredito = wsEstadoCuentaCore.wsConsultarDetalleCuenta(xsNumRadic, "8");
        detalleCtaCredito.setSDescFormaPago(detalleCtaCredito.getSDescFormaPago().equals("Nomina") ? "Nómina" : detalleCtaCredito.getSDescFormaPago());
        detalleAporte.setDetalleCta(detalleCtaCredito);
        if (detalleCtaCredito.getINumBeneficiarios()!= 0) {
            List<Detallemov> detalleAmparado = wsEstadoCuentaCore.wsConsultarDatosAmparadosBeneficiario(xsNumRadic, "8");
            detalleAporte.setDetalleAmparadoBenef(detalleAmparado);
        }
        return detalleAporte;
    }
*/
/*    @Override
    public LstMovimientos wsConsultaMovimientosCtaCredito(String xiCodUser) {
        LstMovimientos movimientoCtaCredito = wsEstadoCuentaCore.wsConsultaMovimientos(xiCodUser, "1");

        movimientoCtaCredito.getLstMovimientos().getDatoDTO().forEach(movimiento -> {
            movimiento.setConcepto(movimiento.getConcepto().equals("Pago crédito listas") ? "Pago" : movimiento.getConcepto());
        });
        return movimientoCtaCredito;
    }

    @Override
    public LstMovimientos wsConsultaMovimientosCtaAporte(String xiCodUser) {
        LstMovimientos movimientoCtaCredito = wsEstadoCuentaCore.wsConsultaMovimientos(xiCodUser, "2");
        movimientoCtaCredito.getLstMovimientos().getDatoDTO().forEach(movimiento -> {
            movimiento.setConcepto(movimiento.getConcepto().equals("Pago Aportes Nómina") ? "Cuota de aportes" : movimiento.getConcepto());
        });
        return movimientoCtaCredito;
    }
*/
/*    @Override
    public LstMovimientos wsConsultaMovimientosCtaServicio(String xiCodUser) {
        LstMovimientos movimientoCtaCredito = wsEstadoCuentaCore.wsConsultaMovimientos(xiCodUser, "8");
        movimientoCtaCredito.getLstMovimientos().getDatoDTO().forEach(movimiento -> {
            movimiento.setConcepto(movimiento.getConcepto().equals("Pago crédito listas") ? "Pago" : movimiento.getConcepto());
        });
        return movimientoCtaCredito;
    }

    @Override
    public Movimiento wsConsultaDetalleMovCtaCredito(String xsNumRadic, String codOperation) {
        Movimiento movimientoCtaCredito = wsEstadoCuentaCore.wsConsultaDetalleMovimientos(xsNumRadic, codOperation, "1");
        return movimientoCtaCredito;
    }

    @Override
    public LstMovimientos wsConsultaDetalleMovCtaServicio(String xsNumRadic, String codOperation) {
        LstMovimientos movimientoCtaCredito = wsEstadoCuentaCore.wsConsultaDetalleMovimientos(xsNumRadic, codOperation, "1");
        return movimientoCtaCredito;
    }
*/
    @Override
    public ResponseEstadoCuenta obtenerEstaCuentaByUser(int xiCodUser) {
        ResponseEstadoCuenta responseEstadoCuenta = new ResponseEstadoCuenta();
        try {

            List<DatoDTO> listCreditosByPersona = new ArrayList<>();
            List<DatoDTO> listAportesByPersona = new ArrayList<>();
            List<DatoDTO> listServicioByPersona = new ArrayList<>();
            String sCodUser = String.valueOf(xiCodUser);
            Long lCodUser = new Long(sCodUser);

            Usuario findUsuarioById = usuarioServiceBean.findUsuarioById(lCodUser);
            if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
                BigInteger bgITipoIdent = findUsuarioById.getIPersona().getITipoIdent();
                String sITipoIdent = String.valueOf(bgITipoIdent);
                String sIdentPersona = findUsuarioById.getIPersona().getCIdentificacion();
                listCreditosByPersona = wsEstadoCuentaCore.wsConsultarEstadoCuenta(sITipoIdent, sIdentPersona, "1");
                listAportesByPersona = wsEstadoCuentaCore.wsConsultarEstadoCuenta(sITipoIdent, sIdentPersona, "2");
                listServicioByPersona = wsEstadoCuentaCore.wsConsultarEstadoCuenta(sITipoIdent, sIdentPersona, "8");

                responseEstadoCuenta.setConsultaExitosa(Boolean.TRUE);
                responseEstadoCuenta.setsMsgProceso("Se ha obtenido la información del estado de cuenta de manera correcta.");
                responseEstadoCuenta.setListCreditos(listCreditosByPersona);
                responseEstadoCuenta.setListAportes(listAportesByPersona);
                responseEstadoCuenta.setListServicios(listServicioByPersona);
                Double dValorTotal = new Double(0);
                for (DatoDTO datoDTO : listCreditosByPersona) {
                    String sSaldoCapital = datoDTO.getSaldocapital() != null && !datoDTO.getSaldocapital().equals("") ? datoDTO.getSaldocapital() : "0";
                    Double dSaldoCap = Double.valueOf(sSaldoCapital);
                    dValorTotal += dSaldoCap;
                }
                BigDecimal bdDeudaCredito = new BigDecimal(dValorTotal);
                bdDeudaCredito = bdDeudaCredito.setScale(2, RoundingMode.HALF_EVEN);
                responseEstadoCuenta.setDeudaCreditos(bdDeudaCredito.toString());

                Double dAcumuladoAportes = new Double(0);
                for (DatoDTO datoDTO : listAportesByPersona) {
                    String sSaldoCapital = datoDTO.getSaldocapital() != null && !datoDTO.getSaldocapital().equals("") ? datoDTO.getSaldocapital() : "0";
                    Double dSaldoCap = Double.valueOf(sSaldoCapital);
                    dAcumuladoAportes += dSaldoCap;
                }
                BigDecimal bdAcumuladoAportes = new BigDecimal(dAcumuladoAportes);
                bdAcumuladoAportes = bdAcumuladoAportes.setScale(2, RoundingMode.HALF_EVEN);
                responseEstadoCuenta.setMisAportes(bdAcumuladoAportes.toString());
            } else {
                responseEstadoCuenta.setConsultaExitosa(Boolean.FALSE);
                responseEstadoCuenta.setsMsgProceso("No se ha podido verificar la información del usuario para obtener el estado de cuenta.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseEstadoCuenta.setConsultaExitosa(Boolean.FALSE);
            responseEstadoCuenta.setsMsgProceso("Se ha presentando un inconveniente al obtener la información del estado de cuenta.");

        }
        return responseEstadoCuenta;
    }

    public respuestaGenerica estadoCuentaPDF(int xiCodUser) {
        String sCodUser = String.valueOf(xiCodUser);
        Long lCodUser = new Long(sCodUser);
        respuestaGenerica generica = new respuestaGenerica();
        String encodedString = "";

        Usuario findUsuarioById = usuarioServiceBean.findUsuarioById(lCodUser);
        if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
            try {
                String SNombre = cygnusCoreServiceBean.getNombresCompletos("", String.valueOf(findUsuarioById.getIPersona().getITipoIdent()), findUsuarioById.getIPersona().getCIdentificacion());
                crearPDF pdf = new crearPDF();
                ResponseEstadoCuenta responseEstadoCuenta = this.obtenerEstaCuentaByUser(xiCodUser);
                if (responseEstadoCuenta.getConsultaExitosa()) {
                    if (pdf.generarEstadoCuenta(this.obtenerEstaCuentaByUser(xiCodUser), findUsuarioById.getIPersona().getCIdentificacion(), SNombre)) {
                        byte[] input_file = Files.readAllBytes(Paths.get("D:\\cooperagro\\cuenta" + findUsuarioById.getIPersona().getCIdentificacion() + ".pdf"));
                        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
                        encodedString = new String(encodedBytes);

                        generica.setbRta(true);
                        generica.setsMsj(encodedString);
                        generica.setiCodigo(1);
                    } else {
                        generica.setbRta(false);
                        generica.setsMsj("No se ha podido procesar la solicitud del estado de cuenta. Por favor intente de nuevo más tarde.");
                        generica.setiCodigo(0);
                    }
                } else {
                    generica.setbRta(false);
                    generica.setsMsj("No se ha podido procesar la solicitud del estado de cuenta. Por favor intente de nuevo más tarde.");
                    generica.setiCodigo(0);
                }

            } catch (Exception e) {
                e.printStackTrace();
                generica.setbRta(false);
                generica.setsMsj("No se ha podido procesar la solicitud del estado de cuenta. Por favor intente de nuevo más tarde.");
                generica.setiCodigo(0);
            }

        } else {
            generica.setbRta(false);
            generica.setsMsj("No se ha podido verificar la información del usuario para obtener el estado de cuenta.");
            generica.setiCodigo(0);

        }

        return generica;

    }

    public respuestaGenerica generarPazSalvoObligacion(RequestObligacionTerm obligacionTerm) {

        Long lCodUser = new Long(obligacionTerm.getSCodigo());
        respuestaGenerica generica = new respuestaGenerica();
        String encodedString = "";

        Usuario findUsuarioById = usuarioServiceBean.findUsuarioById(lCodUser);
        if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {

            //Detallecta detalleCta = this.wsConsultaDetalleCta(obligacionTerm.getSNumRadic(), obligacionTerm.getSProducto());

          /*  if (detalleCta != null && detalleCta.isBRtaConsulta()) {
                try {
                    String SNombre = cygnusCoreServiceBean.getNombresCompletos("", String.valueOf(findUsuarioById.getIPersona().getITipoIdent()), findUsuarioById.getIPersona().getCIdentificacion());
                    //Long SCodPersona = cygnusCoreServiceBean.getCodigoPersona("", String.valueOf(findUsuarioById.getIPersona().getITipoIdent()), findUsuarioById.getIPersona().getCIdentificacion());
                    String SGeneroPersona = cygnusCoreServiceBean.getGeneroPersona("", String.valueOf(findUsuarioById.getIPersona().getITipoIdent()), findUsuarioById.getIPersona().getCIdentificacion());
                    crearPDF pdf = new crearPDF();
                    if (pdf.generarPazySalvo(detalleCta, findUsuarioById.getIPersona().getCIdentificacion(), SNombre, SGeneroPersona)) {
                        byte[] input_file = Files.readAllBytes(Paths.get("D:\\cooperagro\\certificadoPaz_Salvo" + findUsuarioById.getIPersona().getCIdentificacion() + ".pdf"));
                        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
                        encodedString = new String(encodedBytes);

                        generica.setbRta(true);
                        generica.setsMsj(encodedString);
                        generica.setiCodigo(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    generica.setbRta(false);
                    generica.setsMsj("No se ha podido procesar la solicitud del certificado de Paz y Salvo. Por favor intente de nuevo más tarde.");
                    generica.setiCodigo(0);
                }
            } else {
                generica.setbRta(false);
                generica.setsMsj("No se ha podido procesar la solicitud del certificado de Paz y Salvo. Por favor intente de nuevo más tarde.");
                generica.setiCodigo(0);
            }
*/
        } else {
            generica.setbRta(false);
            generica.setsMsj("No se ha podido verificar la información del usuario para obtener el estado de cuenta.");
            generica.setiCodigo(0);

        }

        return generica;

    }

    @Override
    public Movimiento wsConsultaDetalleCtaCredito(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaDetalleCtaAporte(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaDetalleCtaServicio(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaMovimientosCtaCredito(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaMovimientosCtaAporte(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaMovimientosCtaServicio(String xsNumRadic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaDetalleMovCtaCredito(String xsNumRadic, String codOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaDetalleMovCtaServicio(String xsNumRadic, String codOperation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento wsConsultaDetalleCta(String xsNumRadic, String xcProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
