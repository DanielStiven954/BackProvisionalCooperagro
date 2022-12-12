/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.GestionPqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.GestionPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseGestionPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author YO
 */
public class GestionPqrsfServiceBean implements GestionPqrsfService {

    @Override
    public GestionPqrsf registrarGestion(GestionPqrsf gestionPqrsf) {
        GestionPqrsf gestionPqrsf1 = new GestionPqrsf();

        if (gestionPqrsf != null) {
            GestionPqrsfDataAccessImp accessImp = new GestionPqrsfDataAccessImp();
            gestionPqrsf1 = accessImp.create(gestionPqrsf);
            return gestionPqrsf1;
        }
        return null;

    }

    @Override
    public List<GestionPqrsf> obtenerMsjRta(Long codigo) {

        GestionPqrsfDataAccessImp accessImp = new GestionPqrsfDataAccessImp();
        List<GestionPqrsf> listGestionPqrsf;
        listGestionPqrsf = accessImp.obtenerMsjRta(codigo);

        return listGestionPqrsf;
    }

}
