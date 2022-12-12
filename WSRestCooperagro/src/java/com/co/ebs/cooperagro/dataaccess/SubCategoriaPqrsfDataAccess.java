/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface SubCategoriaPqrsfDataAccess {
    
    SubCategoriaPqrsf saveSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf);
    
    SubCategoriaPqrsf updateSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf);
    
    void deleteSubCategoriaPQRSF(SubCategoriaPqrsf subCategoriaPqrsf);
    
    List<SubCategoriaPqrsf> findAllSubCategoriaPQRSF();
    
    SubCategoriaPqrsf findByIdSubCategoriaPQRSF(Long id);
    
}
