/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class RegistroNuevoUsuarioDataAccessImp implements RegistroNuevoUsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public respuestaGenerica realizarRegistroNuevoUsuario(Persona persona, String sClave, String sLlaveSeg, int iTipoPerfil, int iTipoCanal) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("PKG_OPERACION.PRC_OPER_REGISTRO_USUARIO");
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, BigInteger.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(10, Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);

            query.setParameter(1, persona.getICodigo());
            query.setParameter(2, persona.getITipoIdent());
            query.setParameter(3, persona.getCIdentificacion());
            query.setParameter(4, persona.getCNombres());
            query.setParameter(5, persona.getCApellidos());
            query.setParameter(6, sClave);
            query.setParameter(7, sLlaveSeg);
            query.setParameter(8, iTipoPerfil);
            query.setParameter(9, iTipoCanal);

            query.execute();

            int iCodRtaSP = Integer.parseInt(query.getOutputParameterValue(10).toString());
            String sMsjRtaSP = query.getOutputParameterValue(11).toString();

            if (iCodRtaSP == 1) {
                rtaGenerica.setiCodigo(iCodRtaSP);
                rtaGenerica.setbRta(Boolean.TRUE);
                rtaGenerica.setsMsj(sMsjRtaSP);
            } else {
                rtaGenerica.setiCodigo(iCodRtaSP);
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setsMsj("No se ha podido generar el registro del nuevo usuario. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
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
        return rtaGenerica;
    }

}
