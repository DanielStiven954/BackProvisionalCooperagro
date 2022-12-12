
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Persona;

/**
 *
 * @author Brian Cardenas
 */
public interface PersonaService {
    
    Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION);
    Persona personaWebFindByCIdentificacionAndPerfil(int iPerfil,int xiTipoIden, String C_IDENTIFICACION);
    Persona personaWebFindByID(int xiCodPersona);
}
