/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.AccesoUsuario;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface AccesoUsuarioDataAccess {

    AccesoUsuario saveAccesoUsuario(AccesoUsuario accesoUsuario);

    AccesoUsuario updateAccesoUsuario(AccesoUsuario accesoUsuario);

    AccesoUsuario findAccesoUsuarioById(Long id);

    void deleteAccesoUsuario(AccesoUsuario accesoUsuario);

    List<AccesoUsuario> findAllAccesoUsuario();
}
