/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseInfoUsuarioSimulador;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseInformacionUsuario;
import com.co.ebs.cooperagro.wscore.wsCygnus;
import com.ebssas.PersonasDTO;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class InformacionPersonaServiceBean implements InformacionPersonaService {

    @Override
    public ResponseInformacionUsuario informacionUsuario(String xCodigo, String tipoIden, String iden) {
        ResponseInformacionUsuario respuestaInformacionUsuario = new ResponseInformacionUsuario();
        List<PersonasDTO> listaPersonas = this.getListaPersonas(xCodigo, tipoIden, iden);
        if (listaPersonas.size() > 0) {
            respuestaInformacionUsuario.setCodigo(1);
            respuestaInformacionUsuario.setFlag(true);
            respuestaInformacionUsuario.setMsm("Información encontrada satisfactoriamente");
            respuestaInformacionUsuario.setPersona(listaPersonas.get(0));
        } else {
            respuestaInformacionUsuario.setCodigo(0);
            respuestaInformacionUsuario.setFlag(false);
            respuestaInformacionUsuario.setMsm("No existe un usuario");
        }
        return respuestaInformacionUsuario;
    }

    public ResponseInfoUsuarioSimulador informacionUsuarioSimulador(String xCodigo) {
        ResponseInfoUsuarioSimulador respuestaInformacionUsuario = new ResponseInfoUsuarioSimulador();
        List<PersonasDTO> listaPersonas = this.getListaPersonas(xCodigo, "", "");
        if (listaPersonas.size() > 0) {

            respuestaInformacionUsuario.setPersonaDTO(listaPersonas.get(0));
            List<PersonasDTO> listaEmpresa = this.getListaPersonas(listaPersonas.get(0).getICodEmp(), "", "");
            if (listaEmpresa.size() > 0) {
                respuestaInformacionUsuario.setiCodigo(1);
                respuestaInformacionUsuario.setbRta(true);
                respuestaInformacionUsuario.setsMjs("Información encontrada satisfactoriamente");
                respuestaInformacionUsuario.setEmpresaDTO(listaEmpresa.get(0));
            } else {
                respuestaInformacionUsuario.setiCodigo(2);
                respuestaInformacionUsuario.setbRta(true);
                respuestaInformacionUsuario.setsMjs("No se encontró información de la emresa");
            }

        } else {
            respuestaInformacionUsuario.setiCodigo(0);
            respuestaInformacionUsuario.setbRta(false);
            respuestaInformacionUsuario.setsMjs("No existe el usuario");
        }
        return respuestaInformacionUsuario;
    }

    public List<PersonasDTO> getListaPersonas(String xCodigo, String xTipoIdent, String xIdent) {
        wsCygnus wsCore = new wsCygnus();
        return wsCore.wcCONSULTARPERSONAS(xCodigo, xTipoIdent, xIdent);
    }

}
