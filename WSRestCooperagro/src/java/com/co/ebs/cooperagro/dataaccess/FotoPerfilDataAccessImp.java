package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.FotoPerfil;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FotoPerfilDataAccessImp extends WSRestGenericRepositoryJPA<FotoPerfil> implements FotoPerfilDataAccess
{
    EntityManager em;
    
    public FotoPerfilDataAccessImp() {}
    
    /**
     * Método de DAO que busca por usuario
     * 
     * @param usuario
     * @return List<FotoPerfil>
     */
    @Override
    public List<FotoPerfil> buscarPorUsuario(Usuario usuario) {
        List<FotoPerfil> resultado = new ArrayList<>();
        
        connectionDBJPA conn = new connectionDBJPA();
        
        this.em = conn.getEntityManager();
        String sql = "SELECT * FROM FOTO_PERFIL WHERE I_USUARIO = ?";
        Query consulta = em.createNativeQuery(sql, FotoPerfil.class);
        consulta.setParameter(1, usuario.getICodigo());
        
        resultado = consulta.getResultList();
        
        conn.closeEntityManager();
        if(em != null && em.isOpen())
            em.close();
        
        return resultado;
    }
}