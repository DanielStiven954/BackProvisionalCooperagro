/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.HistoriaSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.domain.TipoEstadoSolAfilWeb;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import java.util.Date;

/**
 *
 * @author JONATHAN RUGE
 */
public class HistoriaSolAfilWebDataAccessImp extends WSRestGenericRepositoryJPA<HistoriaSolAfilWeb> implements HistoriaSolAfilWebDataAccess{

    
    @Override
    public HistoriaSolAfilWeb crear(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb)
    {
        HistoriaSolAfilWeb hisSolAfiWebTemporal = new HistoriaSolAfilWeb();
    
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            String fecha2 = simpleDateFormat.format(new Date());
//            Date date = simpleDateFormat.parse(fecha2);
        hisSolAfiWebTemporal.setFFechaRegistro(new Date());
        hisSolAfiWebTemporal.setCObservacionRegistro("Se inicio el proceso");
        hisSolAfiWebTemporal.setIEstadoSolicitud(tipoEstSolAfilWeb);
        hisSolAfiWebTemporal.setISolAfiliacionWeb(solAfilWeb);
        HistoriaSolAfilWeb hisSolAfiWeb = create(hisSolAfiWebTemporal);

        return hisSolAfiWeb;
        
    }

    @Override
    public HistoriaSolAfilWeb update(TipoEstadoSolAfilWeb tipoEstSolAfilWeb,SolicitudAfiliacionWeb solAfilWeb)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoriaSolAfilWeb crearDesdeCero(HistoriaSolAfilWeb historiaSolAfilWeb) {
        return create(historiaSolAfilWeb);
    }
    
}
