/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.respuestasGenericas.PersonaCygnus;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.wscore.WSPersonaCygnus;
import wspersonascygnus.RespuestaCrea;

/**
 *
 * @author Administrador
 */
public class PersonaCygnusServiceBean implements PersonaCygnusService {

    @Override
    public String crearPersonaCygnus(PersonaCygnus personaCygnus) {
        String response = "";
        try {
            response = new WSPersonaCygnus().wsCrearPersonaCygnus(personaCygnus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public RespuestaCrea crearRolPersonaCygnus(String codigoPer, String fecha, String bd, String user, String pass) {
        RespuestaCrea response = new RespuestaCrea();
        try {
            response = new WSPersonaCygnus().wsCrearRolPersonas(codigoPer,fecha, bd, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
