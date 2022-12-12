package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorCartera;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorColocacion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorRetiro;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorVinculacion;
import com.co.ebs.cooperagro.wscore.wsCygnus;
import com.ebssas.IndicadorCarteraDTO;
import com.ebssas.IndicadorColocacionDTO;
import com.ebssas.IndicadorRetiroDTO;
import com.ebssas.IndicadorVinculacionDTO;
import com.ebssas.PersonasDTO;
import com.ebssas.PregseguridadaleatorioDTO;
import com.ebssas.PregseguridadperDTO;
import com.ebssas.ResponseIndicadores;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public class CygnusCoreServiceBean implements CygnusCoreService {

    private final wsCygnus wsCygnusCore = new wsCygnus();

    private final utilidad util = new utilidad();

    @Override
    public List<PersonasDTO> wsConsultarPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        List<PersonasDTO> response = new ArrayList<>();
        try {
            response = wsCygnusCore.wcCONSULTARPERSONAS(xiCodigo, xiTipoIden, xcIdentificacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public String getEmailPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sEmailPersona = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    sEmailPersona = personasDTO.getCEMail();
                    break;
                }
            }
        }
        return sEmailPersona;
    }

    @Override
    public String getTelPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sTelPersona = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    sTelPersona = personasDTO.getCTelefono();
                    break;
                }
            }
        }
        return sTelPersona;
    }

    @Override
    public String getNombresCompletos(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sNombresCompletos = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    String sNombres = personasDTO.getCNombres() != null && !personasDTO.getCNombres().equals("") ? personasDTO.getCNombres() : "";
                    String sApellidos = personasDTO.getCApellidos() != null && !personasDTO.getCApellidos().equals("") ? personasDTO.getCApellidos() : "";
                    sNombresCompletos = sNombres + " " + sApellidos;
                    break;
                }
            }
        }
        return sNombresCompletos;
    }

    @Override
    public String getGeneroPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sGeneroPersona = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    sGeneroPersona = personasDTO.getCSexo();
                    break;
                }
            }
        }
        return sGeneroPersona;
    }

    @Override
    public Long getCodigoPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        Long lCodigoPersona = null;
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    lCodigoPersona = Long.parseLong(personasDTO.getICodigo());
                    break;
                }
            }
        }
        return lCodigoPersona;
    }

    @Override
    public int getTipoPerson(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        int iTipoPerson = 0;
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    String sTipoPerson = personasDTO.getCTipoPerson();
                    if (sTipoPerson.equals("N")) {
                        iTipoPerson = 2;
                    } else if (sTipoPerson.equals("J")) {
                        iTipoPerson = 3;
                    }
                    break;
                }
            }
        }
        return iTipoPerson;
    }

    @Override
    public List<PregseguridadperDTO> wsConsultarPregRegistroPersona(String xiTipoIden, String xcIdentificacion, String xcCampo) {
        List<PregseguridadperDTO> listPregSegRta = new ArrayList<>();
        try {
            listPregSegRta = wsCygnusCore.wsCONSULTARPREGSEGURIDADPER(xiTipoIden, xcIdentificacion, xcCampo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPregSegRta;
    }

    @Override
    public List<PregseguridadaleatorioDTO> wsConsultarPregRegistroPersonaRandom(String xiTipoIden, String xcIdentificacion, String xcCampo) {
        List<PregseguridadaleatorioDTO> listPregSegRta = new ArrayList<>();
        try {
            listPregSegRta = wsCygnusCore.wsCONSULTARPREGSEGURIDADALEATORIO(xiTipoIden, xcIdentificacion, xcCampo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPregSegRta;
    }

    @Override
    public ResponseIndicadorVinculacion getIndicadorVinculacion(String sFechaInicio, String sFechaFin) {
        ResponseIndicadores responseIndicadorVinculacion = new ResponseIndicadores();
        ResponseIndicadorVinculacion indicadorVinculacion = new ResponseIndicadorVinculacion();
        if (sFechaInicio != null && !sFechaInicio.equals("") && sFechaFin != null && !sFechaFin.equals("")) {
            responseIndicadorVinculacion = wsCygnusCore.wsGetIndicadorVinculacion(sFechaInicio, sFechaFin);
        } else {
            responseIndicadorVinculacion = wsCygnusCore.wsGetIndicadorVinculacion(util.getPrimerDiaMes(), util.getUltimoDiaMes());
        }

        Long lCountVinculacion = new Long("0");
        Long lValorMeta = new Long("0");

        if (responseIndicadorVinculacion != null && responseIndicadorVinculacion.isBRta()) {
            //lValorMeta = new Long(responseIndicadorVinculacion.getLstIndicadorVinculacion().getIndicadorVinculacionDTO().get(0).getIMeta());

            for (IndicadorVinculacionDTO indicadorVinculacionDTO : responseIndicadorVinculacion.getLstIndicadorVinculacion().getIndicadorVinculacionDTO()) {
                lCountVinculacion = indicadorVinculacionDTO.getICountVinculacion() + lCountVinculacion;
                //indicadorVinculacionDTO.getIMeta();
            }

            indicadorVinculacion.setlValorMeta(lValorMeta);
            indicadorVinculacion.setlValorLogro(lCountVinculacion);

            Double dPorcentajeCumplimiento = ((lCountVinculacion.doubleValue() / lValorMeta.doubleValue()) * 100);
            indicadorVinculacion.setdPorcentajeCumplimiento(dPorcentajeCumplimiento);

        } else {

        }
        return indicadorVinculacion;
    }

    @Override
    public ResponseIndicadorRetiro getIndicadorRetiro(String sFechaInicio, String sFechaFin) {
        ResponseIndicadores responseIndicadorRetiro = new ResponseIndicadores();
        ResponseIndicadorRetiro indicadorRetiro = new ResponseIndicadorRetiro();

        if (sFechaInicio != null && !sFechaInicio.equals("") && sFechaFin != null && !sFechaFin.equals("")) {
            responseIndicadorRetiro = wsCygnusCore.wsGetIndicadorRetiro(sFechaInicio, sFechaFin);
        } else {
            responseIndicadorRetiro = wsCygnusCore.wsGetIndicadorRetiro(util.getPrimerDiaMes(), util.getUltimoDiaMes());
        }

        Long lValorMeta = new Long("0");
        Long lCountIndicadorRetiro = new Long("0");
        if (responseIndicadorRetiro != null && responseIndicadorRetiro.isBRta()) {
            //lValorMeta = new Long(responseIndicadorRetiro.getLstIndicadorRetiro().getIndicadorRetiroDTO().get(0).getIMeta());
            for (IndicadorRetiroDTO indicadorRetiroDTO : responseIndicadorRetiro.getLstIndicadorRetiro().getIndicadorRetiroDTO()) {
                lCountIndicadorRetiro = indicadorRetiroDTO.getICountRetiro() + lCountIndicadorRetiro;
            }
            indicadorRetiro.setlValorMeta(lValorMeta);
            indicadorRetiro.setlValorLogro(lCountIndicadorRetiro);
        } else {
            indicadorRetiro.setlValorMeta(lValorMeta);
            indicadorRetiro.setlValorLogro(new Long("-1"));
        }

        return indicadorRetiro;
    }

    @Override
    public ResponseIndicadorCartera getIndicadorCartera(String sFechaCorte) {
        ResponseIndicadores responseIndicadorCartera = new ResponseIndicadores();
        ResponseIndicadorCartera indicadorCartera = new ResponseIndicadorCartera();
        if (sFechaCorte != null && !sFechaCorte.equals("")) {
            responseIndicadorCartera = wsCygnusCore.wsGetIndicadorCartera(sFechaCorte);
        } else {
            responseIndicadorCartera = wsCygnusCore.wsGetIndicadorCartera(util.getUltimoDiaMes());
        }

        BigDecimal bdValorMeta = new BigDecimal(BigInteger.ZERO);
        BigDecimal bdValorLogro = new BigDecimal(BigInteger.ZERO);
        bdValorMeta = new BigDecimal(0, MathContext.UNLIMITED);
        BigDecimal bdPorcMeta = new BigDecimal(BigInteger.ZERO);
        bdPorcMeta = new BigDecimal(100, MathContext.UNLIMITED);
        bdPorcMeta = bdPorcMeta.setScale(5, RoundingMode.HALF_EVEN);
        if (responseIndicadorCartera != null && responseIndicadorCartera.isBRta()) {
            double dSuma = 0;
            //bdValorMeta = new BigDecimal(responseIndicadorCartera.getLstIndicadorCartera().getIndicadorCarteraDTO().get(0).getIMeta(), MathContext.UNLIMITED);
            for (IndicadorCarteraDTO indicadorCarteraDTO : responseIndicadorCartera.getLstIndicadorCartera().getIndicadorCarteraDTO()) {
                dSuma = indicadorCarteraDTO.getDSuma() + dSuma;
            }
            bdValorLogro = new BigDecimal(dSuma);
            bdValorLogro = bdValorLogro.setScale(5, RoundingMode.HALF_UP);
            indicadorCartera.setBdValorMeta(bdValorMeta);
            indicadorCartera.setBdValorLogro(bdValorLogro);
            Double dPorcentajeCump = (bdValorLogro.doubleValue() * 100) / bdValorMeta.doubleValue();
            indicadorCartera.setdPorcentajeCumplimiento(dPorcentajeCump);
            Double dPorcentajeMeta = (bdPorcMeta.doubleValue() - dPorcentajeCump);
            indicadorCartera.setBdPorcentajeMeta(dPorcentajeMeta);
        } else {
            indicadorCartera.setBdValorLogro(BigDecimal.ZERO);
            indicadorCartera.setBdValorMeta(BigDecimal.ZERO);
            indicadorCartera.setdPorcentajeCumplimiento(Double.NaN);
            indicadorCartera.setBdPorcentajeMeta(Double.NaN);
        }

        return indicadorCartera;
    }

    @Override
    public ResponseIndicadorColocacion getIndicadorColocacion(String sFechaInicio, String sFechaFin) {
        ResponseIndicadores responseIndicadorColocacion = new ResponseIndicadores();
        ResponseIndicadorColocacion indicadorColocacion = new ResponseIndicadorColocacion();
        if (sFechaInicio != null && !sFechaInicio.equals("") && sFechaFin != null && !sFechaFin.equals("")) {
            responseIndicadorColocacion = wsCygnusCore.wsGetIndicadorColocacion(sFechaInicio, sFechaFin);
        } else {
            responseIndicadorColocacion = wsCygnusCore.wsGetIndicadorColocacion(util.getPrimerDiaMes(), util.getUltimoDiaMes());
        }
        BigDecimal bdValorMeta = new BigDecimal(BigInteger.ZERO);
        BigDecimal bdValorLogro = new BigDecimal(BigInteger.ZERO);
        bdValorMeta = new BigDecimal(0, MathContext.DECIMAL32);
        BigDecimal bdPorcMeta = new BigDecimal(BigInteger.ZERO);
        bdPorcMeta = new BigDecimal(100, MathContext.UNLIMITED);
        bdPorcMeta = bdPorcMeta.setScale(5, RoundingMode.HALF_EVEN);
        if (responseIndicadorColocacion != null && responseIndicadorColocacion.isBRta()) {
            //bdValorMeta = new BigDecimal(responseIndicadorColocacion.getLstIndicadorColocacion().getIndicadorColocacionDTO().get(0).getIMeta(), MathContext.UNLIMITED);
            double dSuma = 0;
            for (IndicadorColocacionDTO indicadorColocacionDTO : responseIndicadorColocacion.getLstIndicadorColocacion().getIndicadorColocacionDTO()) {
                dSuma = indicadorColocacionDTO.getDSuma() + dSuma;
            }
            bdValorLogro = new BigDecimal(dSuma);
            bdValorLogro = bdValorLogro.setScale(5, RoundingMode.HALF_UP);
            indicadorColocacion.setBdValorMeta(bdValorMeta);
            indicadorColocacion.setBdValorLogro(bdValorLogro);
            BigDecimal bdPorcentajeCump = (bdValorLogro.multiply(new BigDecimal("100"))).divide(bdValorMeta, 5, RoundingMode.HALF_UP);
            bdPorcentajeCump = bdPorcentajeCump.setScale(5, RoundingMode.HALF_UP);
            indicadorColocacion.setBdPorcentajeCumplimiento(bdPorcentajeCump);
            indicadorColocacion.setBdPorcentajeMeta(bdPorcMeta.subtract(bdPorcentajeCump));
        } else {
            indicadorColocacion.setBdValorLogro(BigDecimal.ZERO);
            indicadorColocacion.setBdValorMeta(BigDecimal.ZERO);
            indicadorColocacion.setBdPorcentajeCumplimiento(BigDecimal.ZERO);
            indicadorColocacion.setBdPorcentajeMeta(BigDecimal.ZERO);
        }
        return indicadorColocacion;
    }
    
    public String getNombre(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sNombresCompletos = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    String sNombres = personasDTO.getCNombres() != null && !personasDTO.getCNombres().equals("") ? personasDTO.getCNombres() : "";
                    String sApellidos = personasDTO.getCApellidos() != null && !personasDTO.getCApellidos().equals("") ? personasDTO.getCApellidos() : "";
                    sNombresCompletos = sNombres + "-" + sApellidos;
                    break;
                }
            }
        }
        return sNombresCompletos;
    }
    

}
