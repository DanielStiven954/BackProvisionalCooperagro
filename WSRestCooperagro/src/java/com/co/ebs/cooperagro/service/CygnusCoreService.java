package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorCartera;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorColocacion;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorRetiro;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseIndicadorVinculacion;
import com.ebssas.PersonasDTO;
import com.ebssas.PregseguridadaleatorioDTO;
import com.ebssas.PregseguridadperDTO;
import java.util.List;

/**
 * ETHOS
 *
 * @author Brian Cardenas
 */
public interface CygnusCoreService {

    List<PersonasDTO> wsConsultarPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getEmailPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getTelPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getNombresCompletos(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getGeneroPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    Long getCodigoPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    int getTipoPerson(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    List<PregseguridadperDTO> wsConsultarPregRegistroPersona(String xiTipoIden, String xcIdentificacion, String xcCampo);

    List<PregseguridadaleatorioDTO> wsConsultarPregRegistroPersonaRandom(String xiTipoIden, String xcIdentificacion, String xcCampo);

    ResponseIndicadorVinculacion getIndicadorVinculacion(String sFechaInicio, String sFechaFin);

    ResponseIndicadorRetiro getIndicadorRetiro(String sFechaInicio, String sFechaFin);

    ResponseIndicadorCartera getIndicadorCartera(String sFechaCorte);

    ResponseIndicadorColocacion getIndicadorColocacion(String sFechaInicio, String sFechaFin);
}
