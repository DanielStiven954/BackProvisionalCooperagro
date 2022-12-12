/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AccesoUsuarioDataAccessImp;
import com.co.ebs.cooperagro.dataaccess.UsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.AccesoUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class AccesoUsuarioServiceBean implements AccesoUsuarioService {

    private AccesoUsuarioDataAccessImp accesoUsuarioDataAccessImp = new AccesoUsuarioDataAccessImp();

    @Override
    public AccesoUsuario saveAccesoUsuario(AccesoUsuario accesoUsuario) {
        return accesoUsuarioDataAccessImp.saveAccesoUsuario(accesoUsuario);
    }

    @Override
    public AccesoUsuario updateAccesoUsuario(AccesoUsuario accesoUsuario) {
        return accesoUsuarioDataAccessImp.updateAccesoUsuario(accesoUsuario);
    }

    @Override
    public AccesoUsuario findAccesoUsuarioById(Long id) {
        return accesoUsuarioDataAccessImp.findAccesoUsuarioById(id);
    }

    @Override
    public void deleteAccesoUsuario(AccesoUsuario accesoUsuario) {
        accesoUsuarioDataAccessImp.deleteAccesoUsuario(accesoUsuario);
    }

    @Override
    public List<AccesoUsuario> findAllAccesoUsuario() {
        return accesoUsuarioDataAccessImp.findAllAccesoUsuario();
    }

    public respuestaGenerica desbloquearUsuario(String xCodUsuario){
        respuestaGenerica rta = new respuestaGenerica();
        try{
            UsuarioDataAccessImp usuarioDAO = new UsuarioDataAccessImp();
            Usuario usuarioBuscado =  usuarioDAO.findUsuarioById(Long.parseLong(xCodUsuario));
            if (usuarioBuscado!=null) {
                List<AccesoUsuario> listAcceso = accesoUsuarioDataAccessImp.findAllAccesoUsuarioByUsuario(usuarioBuscado);
                                
                if (!listAcceso.isEmpty()) {
                    
                    for (AccesoUsuario acceso : listAcceso) {
                        if (acceso.getCEstado().equals("ACT")) {
                            acceso.setCEstado("INA");
                            accesoUsuarioDataAccessImp.updateAccesoUsuario(acceso);
                        }
                    }

                    rta.setbRta(Boolean.TRUE);
                    rta.setsMsj("Se ha desbloqueado el usuario de manera correcta");
                }
                else{
                    rta.setbRta(Boolean.FALSE);
                    rta.setsMsj("No se han encontrado accesos para el usuario");
                }
            }
            else{
                rta.setbRta(Boolean.FALSE);
                rta.setsMsj("El usuario no es válido");
            }
        }
        catch(Exception e){
            rta.setbRta(false);
            rta.setsMsj("Ha ocurrido un error al desbloquear el usuario");
        }
        return rta;
    }
}
