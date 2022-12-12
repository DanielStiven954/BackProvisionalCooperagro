package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Pregunta;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import javax.persistence.EntityManager;

import java.util.List;
import javax.persistence.Query;

public class PreguntaDataAccessImp extends WSRestGenericRepositoryJPA<Pregunta> implements PreguntaDataAccess
{
    private EntityManager em;
    
    @Override
    public List<Pregunta> findPreguntaByNotUsuario(long usuario) {
        
        List<Pregunta> resultado = null;
        
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            
            String sql = ""+
                    "select * \n" +
                    "from pregunta \n" +
                    "where i_codigo not in (\n" +
                    "    select i_pregunta from pregunta_usuario where i_usuario = ?\n" +
                    ")";
            
            Query obtenerPreguntas = em.createNativeQuery(sql, Pregunta.class);
            obtenerPreguntas.setParameter(1, usuario);
            
            resultado = obtenerPreguntas.getResultList();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        finally {
            connDBJPA.closeEntityManager();
            if(em != null && em.isOpen()) em.close();
        }
        
        return resultado;
    }

    @Override
    public List<Pregunta> findPreguntaByDescripcion(String descripcion) {
        
        List<Pregunta> resultado = new ArrayList<>();
        
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            
            String sql = ""+
                    "select * \n" +
                    "from pregunta \n" +
                    "where c_descripcion = ? ";
            
            Query obtenerPreguntas = em.createNativeQuery(sql, Pregunta.class);
            obtenerPreguntas.setParameter(1, descripcion);
            
            resultado = obtenerPreguntas.getResultList();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        finally {
            connDBJPA.closeEntityManager();
            if(em != null && em.isOpen()) em.close();
        }
        
        return resultado;
    }
}
