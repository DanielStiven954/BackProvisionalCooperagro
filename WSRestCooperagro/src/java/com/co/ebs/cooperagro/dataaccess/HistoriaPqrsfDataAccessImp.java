/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.HistoriaPqrsf;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;

/**
 *
 * @author YO
 */
public class HistoriaPqrsfDataAccessImp extends WSRestGenericRepositoryJPA<HistoriaPqrsf> implements HistoriaPqrsfDataAccess{

    @Override
    public HistoriaPqrsf saveHistoriaPqrsf(HistoriaPqrsf historiaPqrsf) {
        return create(historiaPqrsf);
    }
    
}
