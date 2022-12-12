package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.PreguntaUsuario;
import java.util.List;

/**
 * 
 * @author Andrés Sierra
 * email: andres.sierra@ebssas.com
 */
public interface PreguntaUsuarioDataAccess 
{
    
    public List<PreguntaUsuario> obtenerPreguntasByUsuario(String usuarioCod, boolean soloActivas);
    
}
