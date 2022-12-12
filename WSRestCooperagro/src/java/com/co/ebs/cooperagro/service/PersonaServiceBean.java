package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.PersonaDataAccessImp;
import com.co.ebs.cooperagro.domain.Persona;

/**
 *
 * @author Brian Cardenas
 */
public class PersonaServiceBean implements PersonaService {

    private PersonaDataAccessImp personaDataAccessImp = new PersonaDataAccessImp();

    @Override
    public Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION) {

        Persona personaWeb = personaDataAccessImp.personaWebFindByCIdentificacion(xiTipoIden, C_IDENTIFICACION);

        return personaWeb;
    }

    @Override
    public Persona personaWebFindByCIdentificacionAndPerfil(int iPerfil,int xiTipoIden, String C_IDENTIFICACION) {

        Persona personaWeb = personaDataAccessImp.personaWebFindByCIdentificacionAndPerfil(iPerfil,xiTipoIden, C_IDENTIFICACION);

        return personaWeb;
    }
    @Override
    public Persona personaWebFindByID(int xiCodPersona){
        Persona personaWeb = personaDataAccessImp.personaWebFindByID(xiCodPersona);
        return personaWeb;
    }
    
    
}
