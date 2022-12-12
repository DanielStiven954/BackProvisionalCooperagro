package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.PreguntaCreaUsu;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brian Cardenas
 */
public interface PreguntaCreaUsuDataAccess 
{

    List<PreguntaCreaUsu> getPreguntasRegUsuRandom();
    respuestaGenerica  validarIntentosPreguntasRegistroUsuario( int    iTipoIdent, 
                                                                String sNumIdent, 
                                                                String estPreg, 
                                                                String tTipoCanal);
    
    
}
