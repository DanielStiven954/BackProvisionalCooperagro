/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.GestionPqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public interface GestionPqrsfDataAccess {
    
    GestionPqrsf registrarGestion(GestionPqrsf gestionPqrsf);
    
    List<GestionPqrsf> obtenerMsjRta(Long codigo);
    
}
