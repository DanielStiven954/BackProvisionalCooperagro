package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.PreguntaCreaUsu;
import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public interface PreguntaCreaUsuService {

//    String PreguntasRegUsuRandom();
    List<PreguntaCreaUsu> PreguntasRegUsuRandom();

    List<PreguntaCreaUsu> askWithAnswerRegUser(int xiTipoIden, String xcIdentificacion);

    respuestaGenerica validarRtasPregRegistroUsuario(String resp, int xiTipoIden, String xcIdentificacion, String iTipoCanal);
    
    respuestaGenerica validarRtasPregRegistroUsuario2(RequestRtaCuestionario requestRtaCuestionario);

    respuestaGenerica validarIntentosPreguntasRegistroUsuario(int iTipoIdent, String sNumIdent, String estPreg, String iTipoCanal);
}
