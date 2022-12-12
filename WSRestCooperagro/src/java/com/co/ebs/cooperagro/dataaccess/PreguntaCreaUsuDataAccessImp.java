package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.PreguntaCreaUsu;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Brian Cardenas
 */
public class PreguntaCreaUsuDataAccessImp extends WSRestGenericRepositoryJPA<PreguntaCreaUsu> implements PreguntaCreaUsuDataAccess {

    private EntityManager em = null;

    
    // Obtenemos 3 preguntas aleatorias de la tabla pregunta_crea_usu
    @Override
    public List<PreguntaCreaUsu> getPreguntasRegUsuRandom() {

        List<PreguntaCreaUsu> listPreguntasRegUsu = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("PKG_CONSULTA.PRC_CONS_PREGUNTA_REGISTRO_USU");
            query.registerStoredProcedureParameter(1, PreguntaCreaUsu.class, ParameterMode.REF_CURSOR);
            query.execute();
            PreguntaCreaUsu preguntaCreaUsu = new PreguntaCreaUsu();
            List<Object[]> objects = query.getResultList();
            for (Object[] object : objects) {
                String sCodigo = String.valueOf(object[0]);
                Long lCodigo = new Long(sCodigo);
                String sDescPreg = (String) object[1];
                String sCampo = (String) object[2];
                String sAct = (String) object[3];
                preguntaCreaUsu.setICodigo(lCodigo);
                preguntaCreaUsu.setCDescripcion(sDescPreg);
                preguntaCreaUsu.setCCampo(sCampo);
                preguntaCreaUsu.setCEstado(sAct);
                listPreguntasRegUsu.add(preguntaCreaUsu);
                preguntaCreaUsu = new PreguntaCreaUsu();
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
        return listPreguntasRegUsu;
    }

    @Override
    public respuestaGenerica validarIntentosPreguntasRegistroUsuario(int iTipoIdent, String sNumIdent, String estPreg, String iTipoCanal) {
        respuestaGenerica rtaSP = new respuestaGenerica();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_VALIDACION.PRC_VAL_INT_PREG_SEG_EXT");
            storedProcedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.OUT);

            storedProcedureQuery.setParameter(1, iTipoIdent);
            storedProcedureQuery.setParameter(2, sNumIdent);
            storedProcedureQuery.setParameter(3, iTipoCanal);
            storedProcedureQuery.setParameter(4, estPreg);

            storedProcedureQuery.execute();
            int cod_mensaje = 0;
            String mensaje = "";
            
            if (storedProcedureQuery.getOutputParameterValue(5) != null) {
                cod_mensaje = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(5).toString());
            } else {
                cod_mensaje = 0;
            }

            if (storedProcedureQuery.getOutputParameterValue(6) != null) {
                mensaje = storedProcedureQuery.getOutputParameterValue(6).toString();
            } else {
                mensaje = "No se pudo verificar los intentos de registro mediantes las preguntas.";
            }
            if (cod_mensaje == 1) {
                rtaSP.setbRta(Boolean.TRUE);
            } else {
                rtaSP.setbRta(Boolean.FALSE);
            }
            rtaSP.setiCodigo(cod_mensaje);
            rtaSP.setsMsj(mensaje);
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

        return rtaSP;
    }

}
