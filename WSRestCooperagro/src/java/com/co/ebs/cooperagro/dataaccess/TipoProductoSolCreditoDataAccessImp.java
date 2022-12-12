/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.TipoProductoSolCredito;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class TipoProductoSolCreditoDataAccessImp extends WSRestGenericRepositoryJPA<TipoProductoSolCredito> implements TipoProductoSolCreditoDataAccess {

    @Override
    public List<TipoProductoSolCredito> consTipoProducto() {
        List<TipoProductoSolCredito> lisTipoProducto = findAll();
        return lisTipoProducto;
    }

    @Override
    public TipoProductoSolCredito consTipoProductoByID(Long idTipoProducto) {
        TipoProductoSolCredito tipoPerfBuscado = find(idTipoProducto);
        return tipoPerfBuscado;
    }

}
