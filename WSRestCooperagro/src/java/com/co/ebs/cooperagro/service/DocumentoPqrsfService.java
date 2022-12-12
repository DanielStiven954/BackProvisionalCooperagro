/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.DocumentoPqrsf;

/**
 *
 * @author Administrador
 */
public interface DocumentoPqrsfService {
    
    DocumentoPqrsf saveDocumentoPqrsf(DocumentoPqrsf documentoPqrsf);
    
    DocumentoPqrsf findByIdPqrsf(Long id);
    
}
