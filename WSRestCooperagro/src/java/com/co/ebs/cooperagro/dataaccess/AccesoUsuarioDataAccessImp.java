/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Acceso;
import com.co.ebs.cooperagro.domain.AccesoUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class AccesoUsuarioDataAccessImp extends WSRestGenericRepositoryJPA<AccesoUsuario> implements AccesoUsuarioDataAccess {

    private EntityManager em = null;
    
    @Override
    public AccesoUsuario saveAccesoUsuario(AccesoUsuario accesoUsuario) {
        AccesoUsuario createAccesoUsuario = create(accesoUsuario);
        return createAccesoUsuario;
    }

    @Override
    public AccesoUsuario updateAccesoUsuario(AccesoUsuario accesoUsuario) {
        AccesoUsuario updateAccesoUsuario = update(accesoUsuario);
        return updateAccesoUsuario;
    }

    @Override
    public AccesoUsuario findAccesoUsuarioById(Long id) {
        AccesoUsuario findAccesoUsuarioById = find(id);
        return findAccesoUsuarioById;
    }

    @Override
    public void deleteAccesoUsuario(AccesoUsuario accesoUsuario) {
        delete(accesoUsuario);
    }

    @Override
    public List<AccesoUsuario> findAllAccesoUsuario() {
        List<AccesoUsuario> listAllAccesoUsuario = findAll();
        return listAllAccesoUsuario;
    }

    public List<AccesoUsuario> findAllAccesoUsuarioByUsuario(Usuario usuario){
        List<AccesoUsuario> listaRTA = new ArrayList<>();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<AccesoUsuario> consultDocument = em.createNamedQuery("AccesoUsuario.findByIUsuario", AccesoUsuario.class);
            consultDocument.setParameter("iUsuario", usuario);
            List<AccesoUsuario> listAcceso = consultDocument.getResultList();
            
            if (listAcceso != null && !listAcceso.isEmpty()) {
                listaRTA = listAcceso;
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
        return listaRTA;
    }
    
    
}
