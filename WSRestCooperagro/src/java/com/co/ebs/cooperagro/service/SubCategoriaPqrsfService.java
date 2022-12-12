/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.SubCategoriaPqrsf;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseSubCategoriaPqrsf;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface SubCategoriaPqrsfService{
    
    ResponseSubCategoriaPqrsf findByCategoria(Long id);
    
    SubCategoriaPqrsf findById(Long id);
    
}
