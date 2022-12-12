package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.PreguntaUsuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;



public class PreguntaUsuarioDataAccessImp 
    extends WSRestGenericRepositoryJPA<PreguntaUsuario>
    implements PreguntaUsuarioDataAccess
{

    private EntityManager em;
    
    @Override
    public List<PreguntaUsuario> obtenerPreguntasByUsuario(String usuarioCod, boolean soloActivas) {
        List<PreguntaUsuario> resultado = new ArrayList<PreguntaUsuario>();
        
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            String sql = "select * from pregunta_usuario where i_usuario = ?"+(soloActivas?" and c_estado = 'ACT'":"");
            Query obtenerPreguntasUsu = this.em.createNativeQuery(sql,PreguntaUsuario.class);
            obtenerPreguntasUsu.setParameter(1, usuarioCod);
            resultado = obtenerPreguntasUsu.getResultList();
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        finally {
            connDBJPA.closeEntityManager();
            if(em != null && em.isOpen()) em.close();
        }
        
        return resultado;
    }
    
}
