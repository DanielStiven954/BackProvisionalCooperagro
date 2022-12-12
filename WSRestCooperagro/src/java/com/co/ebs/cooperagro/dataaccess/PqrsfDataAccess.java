/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Pqrsf;
import java.util.List;

/**
 *
 * @author YO
 */
public interface PqrsfDataAccess {
    
    Pqrsf savePqrsf(Pqrsf pqrsf);
    
    Pqrsf updatePqrsf(Pqrsf pqrsf);
    
    void deletePqrsf(Pqrsf pqrsf);
    
    List<Pqrsf> findAllPqrsf();
    
    Pqrsf findById(Long id);
    
}
