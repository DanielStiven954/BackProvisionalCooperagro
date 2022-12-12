/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.CategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface CategoriaPQRSFDataAccess {
    
    CategoriaPqrsf saveCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf);
    
    CategoriaPqrsf updateCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf);
    
    void deleteCategoriaPQRSF(CategoriaPqrsf categoriaPqrsf);
    
    List<CategoriaPqrsf> findAllCategoriaPQRSF();
    
    CategoriaPqrsf findByIdCategoriaPQRSF(Long id);
    
}
