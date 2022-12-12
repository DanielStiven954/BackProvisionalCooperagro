package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.request.RequestRtaCuestionario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePreguntaActNoUtilizadas;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;

public interface PreguntasService 
{
    ResponsePreguntaActNoUtilizadas preguntasActivasNoUtilizadas(String xsTipoIdent, String xsIdent, boolean obtenerTodas);
    
    respuestaGenerica actualizarPreguntasSeguridad(RequestRtaCuestionario request);
}