/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.TipoRequisitoSolCredDataAccessImp;
import com.co.ebs.cooperagro.domain.TipoRequisitoSolCred;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseTipoReqSolCred;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Braya
 */
public class TipoRequisitoSolCredServiceBean implements TipoRequisitoSolCredService {

    @Inject
    private TipoRequisitoSolCredDataAccessImp tipoReqSolCredDataAccessImp = new TipoRequisitoSolCredDataAccessImp();
    private ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    @Override
    public TipoRequisitoSolCred saveTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        return tipoReqSolCredDataAccessImp.saveTipoRequisitoSolCred(tipoRequisitoSolCred);
    }

    @Override
    public TipoRequisitoSolCred updateTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        return tipoReqSolCredDataAccessImp.updateTipoRequisitoSolCred(tipoRequisitoSolCred);
    }

    @Override
    public TipoRequisitoSolCred findRequisitoSolCredById(Long id) {
        return tipoReqSolCredDataAccessImp.findRequisitoSolCredById(id);
    }

    @Override
    public void deletTipoRequisitoSolCred(TipoRequisitoSolCred tipoRequisitoSolCred) {
        tipoReqSolCredDataAccessImp.deletTipoRequisitoSolCred(tipoRequisitoSolCred);
    }

    @Override
    public List<TipoRequisitoSolCred> tipoRequisitoSolCredFindAll() {
        return tipoReqSolCredDataAccessImp.tipoRequisitoSolCredFindAll();
    }

    @Override
    public ResponseTipoReqSolCred findTipoReqSolCredActivos() {
        List<TipoRequisitoSolCred> tipoRequisitoSolCredList = this.tipoRequisitoSolCredFindAll();
        ResponseTipoReqSolCred responseTipoReqSolCred = new ResponseTipoReqSolCred();
        if (tipoRequisitoSolCredList != null && !tipoRequisitoSolCredList.isEmpty()) {
            tipoRequisitoSolCredList.removeIf(trsc -> {
                return !trsc.getCEstado().equals("ACT");
            });
            if (tipoRequisitoSolCredList != null && !tipoRequisitoSolCredList.isEmpty()) {
                String sTipoArchivosPermitos = parametroServiceBean.obtenerParametroPorNombre("TIPOS_ARC_PER_SOL_CRED");
                responseTipoReqSolCred.setbFlag(Boolean.TRUE);
                responseTipoReqSolCred.setsMsj("Se han obtenido los tipos de requisitos correctamente.");
                responseTipoReqSolCred.setsTipoArchivosPermitos(sTipoArchivosPermitos);
                responseTipoReqSolCred.setTipoRequisitoSolCredList(tipoRequisitoSolCredList);
            } else {
                responseTipoReqSolCred.setbFlag(Boolean.FALSE);
                responseTipoReqSolCred.setsMsj("No se han encontrado tipos de requisitos activos.");
            }

        } else {
            responseTipoReqSolCred.setbFlag(Boolean.FALSE);
            responseTipoReqSolCred.setsMsj("No se han encontrado tipos de requisitos activos.");
        }
        return responseTipoReqSolCred;
    }

}
