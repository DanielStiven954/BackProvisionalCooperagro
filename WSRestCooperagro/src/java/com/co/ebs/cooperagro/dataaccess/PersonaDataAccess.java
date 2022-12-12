package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Persona;

/**
 *
 * @author Brian Cardenas
 */
public interface PersonaDataAccess {

    Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION);

    Persona personaWebFindByCIdentificacionAndPerfil(int perfil, int xiTipoIden, String c_identificacion);

    Persona personaWebFindByID(int xiCodPersona);
}
