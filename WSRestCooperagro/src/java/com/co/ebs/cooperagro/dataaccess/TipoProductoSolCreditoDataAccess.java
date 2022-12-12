/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.*;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface TipoProductoSolCreditoDataAccess {

    List<TipoProductoSolCredito> consTipoProducto();

    TipoProductoSolCredito consTipoProductoByID(Long idTipoProducto);
}
