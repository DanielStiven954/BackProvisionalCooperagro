/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.ebssystem.DatoDTO;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseObligacionesTerminadas;
import java.util.List;
import com.co.ebs.cooperagro.wscore.wsEstadoCuenta;

/**
 *
 * @author Brayan Moreno
 */
public class PazySalvoServiceBean implements PazYSalvoService {

    private final UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();
    private final wsEstadoCuenta wsEstadoCuentaCore = new wsEstadoCuenta();

    @Override
    public ResponseObligacionesTerminadas obligacionesTerminadas(String xiCodigo, String xcProducto) {

        ResponseObligacionesTerminadas obligacionesTerminadas = new ResponseObligacionesTerminadas();
        
        Usuario usuario = usuarioServiceBean.findUsuarioById(Long.parseLong(xiCodigo));

        if (usuario != null && usuario.getIPersona().getICodigo() != 0) {
            //WSCuentaCygnus cuentaCygnus = new WSCuentaCygnus();
            List<DatoDTO> list = wsEstadoCuentaCore.wsConsultarObligacionesTerminadas(usuario.getIPersona().getICodigo()+"", xcProducto);
            if (!list.isEmpty()) {
                obligacionesTerminadas.setbRta(Boolean.TRUE);
                obligacionesTerminadas.setsMsjRta("La persona cuenta con obligaciones terminadas.");
                obligacionesTerminadas.setListObligacionesTerminadas(list);
            } else {
                obligacionesTerminadas.setbRta(Boolean.FALSE);
                obligacionesTerminadas.setsMsjRta("La persona no cuenta con obligaciones terminadas.");
                obligacionesTerminadas.setListObligacionesTerminadas(list);
            }
        } else {
            obligacionesTerminadas.setbRta(Boolean.FALSE);
            obligacionesTerminadas.setsMsjRta("La persona no se encuentra registrada en el sistema.");
        }

        return obligacionesTerminadas;

    }

    
}
