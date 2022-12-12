/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.DocumentoPqrsfDataAccessImp;
import com.co.ebs.cooperagro.domain.DocumentoPqrsf;

/**
 *
 * @author Administrador
 */
public class DocumentoPqrsfServiceBean implements DocumentoPqrsfService{

    @Override
    public DocumentoPqrsf saveDocumentoPqrsf(DocumentoPqrsf documentoPqrsf) {
        return new DocumentoPqrsfDataAccessImp().saveDocumentoPqrsf(documentoPqrsf);
    }

    @Override
    public DocumentoPqrsf findByIdPqrsf(Long id) {
        return new DocumentoPqrsfDataAccessImp().findByIdPqrsf(id);
    }
    
   
}
