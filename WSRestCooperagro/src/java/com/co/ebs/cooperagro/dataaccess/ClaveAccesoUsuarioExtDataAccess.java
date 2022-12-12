/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.ClaveAccesoUsuarioExterno;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface ClaveAccesoUsuarioExtDataAccess {

    Boolean createClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    Boolean updateClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    void deleteClaveAccesoUsuExt(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);

    List<ClaveAccesoUsuarioExterno> findAllClaveAccesoUsuExt();

    ClaveAccesoUsuarioExterno findClaveAccesoUsuExtById(Long id);

    List<ClaveAccesoUsuarioExterno> findClaveAccesoUsuExtByIdent(ClaveAccesoUsuarioExterno claveAccesoUsuarioExterno);
}
