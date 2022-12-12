/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Acceso;
import com.co.ebs.cooperagro.domain.Transaccion;
import com.co.ebs.cooperagro.domain.Usuario;

/**
 *
 * @author Brian Cardenas
 */
public interface AccesoDataAccess {

    Acceso saveAcceso(Acceso acceso);

    Acceso updateAcceso(Acceso acceso);

    Acceso findAccesoById(Long id);

    Acceso findAccesoByIdUser(Usuario usuario);
    
    Acceso findAccesoByIdUser(Long idUser);

    void deleteAcceso(Acceso acceso);

    Acceso findAccesoByIUsuarioAndiTransaccion(Long idUser, int iTransaccion);

    String getLlaveSeguridadAcceso(int tipoIdent, String sIdentificacion, String sTipoTransaccion, int iTipoPerfil, int iTipoCanal);

    Usuario validarPrimeraClave(int tipoIdent, String sIdentificacion, String sClaveEncriptada, int iTipoPerfil, int iTipoCanal);
    
    String getLlaveSeguridad(String llave);
    
}
