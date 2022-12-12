package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brian Cardenas
 */
public class PersonaDataAccessImp extends WSRestGenericRepositoryJPA<Persona> implements PersonaDataAccess {

    private EntityManager em = null;

    @Override
    public Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION) {
        Persona personaFind = new Persona();
        BigInteger iTipoIden = new BigInteger(String.valueOf(xiTipoIden));
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Persona> consultDocument = em.createNamedQuery("Persona.findByCIdentificacion", Persona.class);
            consultDocument.setParameter("cIdentificacion", C_IDENTIFICACION);
            consultDocument.setParameter("iTipoIdent", iTipoIden);
            List<Persona> listPersona = consultDocument.getResultList();
            if (listPersona != null && !listPersona.isEmpty()) {
                for (Persona personaFindByIdent : listPersona) {
                    if (personaFindByIdent.getCIdentificacion().equals(C_IDENTIFICACION)) {
                        personaFind = personaFindByIdent;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return personaFind;
    }

    @Override
    public Persona personaWebFindByID(int xiCodPersona) {
        Persona personaFind = new Persona();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Persona> consultDocument = em.createNamedQuery("Persona.findByICodigo", Persona.class);
            consultDocument.setParameter("iCodigo", xiCodPersona);
            List<Persona> listPersona = consultDocument.getResultList();
            if (listPersona != null && !listPersona.isEmpty()) {
                personaFind = listPersona.get(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return personaFind;
    }

    @Override
    public Persona personaWebFindByCIdentificacionAndPerfil(int perfil, int xiTipoIden, String c_identificacion) {
        Persona personaFind = new Persona();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query query = em.createNativeQuery("select p.* from persona p ,usuario u \n"
                    + "	where p.I_CODIGO = u.I_PERSONA\n"
                    + "		AND u.I_PERFIL=?  \n"
                    + "		AND p.I_TIPO_IDENT =?  \n"
                    + "		AND p.C_IDENTIFICACION =? ", Persona.class);
            query.setParameter(1, perfil);
            query.setParameter(2, xiTipoIden);
            query.setParameter(3, c_identificacion);
            List<Persona> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                personaFind = result.get(0);
            } else {
                personaFind = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return personaFind;
    }
}
