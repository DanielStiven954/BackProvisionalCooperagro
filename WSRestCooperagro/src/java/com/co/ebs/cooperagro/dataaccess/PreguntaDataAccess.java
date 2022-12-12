package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Pregunta;
import java.util.List;

interface PreguntaDataAccess
{
    List<Pregunta> findPreguntaByNotUsuario(long usuario);
    
    List<Pregunta> findPreguntaByDescripcion(String descripcion);
    
}
