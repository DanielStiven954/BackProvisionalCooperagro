/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.ReferenciasSolAfilWebDataAccessImp;
import com.co.ebs.cooperagro.domain.ReferenciasSolAfilWeb;
import com.co.ebs.cooperagro.domain.SolicitudAfiliacionWeb;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ReferenciasSolAfilWebServiceBean implements ReferenciasSolAfilWebService {

    private final ReferenciasSolAfilWebDataAccessImp referenciasSolAfilWebDataAccessImp = new ReferenciasSolAfilWebDataAccessImp();

    @Override
    public ReferenciasSolAfilWeb saveReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        return this.referenciasSolAfilWebDataAccessImp.saveReferenciasSolAfilWeb(referenciasSolAfilWeb);
    }

    @Override
    public ReferenciasSolAfilWeb updateReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        return this.referenciasSolAfilWebDataAccessImp.updateReferenciasSolAfilWeb(referenciasSolAfilWeb);
    }

    @Override
    public ReferenciasSolAfilWeb findReferenciasSolAfilWebById(Long id) {
        return this.referenciasSolAfilWebDataAccessImp.findReferenciasSolAfilWebById(id);
    }

    @Override
    public ReferenciasSolAfilWeb findReferenciasBySolAfilWeb(Long idSolAfilWeb) {
        return this.referenciasSolAfilWebDataAccessImp.findReferenciasBySolAfilWeb(idSolAfilWeb);
    }

    @Override
    public void deleteReferenciasSolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        this.referenciasSolAfilWebDataAccessImp.deleteReferenciasSolAfilWeb(referenciasSolAfilWeb);
    }

    @Override
    public List<ReferenciasSolAfilWeb> findAllReferenciasSolAfilWeb() {
        return this.referenciasSolAfilWebDataAccessImp.findAllReferenciasSolAfilWeb();
    }

    @Override
    public respuestaGenerica saveReferenciasBySolAfilWeb(ReferenciasSolAfilWeb referenciasSolAfilWeb) {
        respuestaGenerica rtaGenSaveReferencias = new respuestaGenerica();
        if (referenciasSolAfilWeb != null) {
            if (referenciasSolAfilWeb.getISolAfiliacionWeb() != null && referenciasSolAfilWeb.getISolAfiliacionWeb().getICodigo() != null) {
                ReferenciasSolAfilWeb infoBuscada = this.findReferenciasBySolAfilWeb(referenciasSolAfilWeb.getISolAfiliacionWeb().getICodigo());
                if (infoBuscada != null) {
                    ReferenciasSolAfilWeb rsaw = this.updateReferenciasSolAfilWeb(referenciasSolAfilWeb);
                    if (rsaw != null && rsaw.getICodigo() != null) {
                        rtaGenSaveReferencias.setbRta(Boolean.TRUE);
                        rtaGenSaveReferencias.setiCodigo(1);
                        rtaGenSaveReferencias.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de afiliación.");
                    }
                    else {
                        rtaGenSaveReferencias.setbRta(Boolean.FALSE);
                        rtaGenSaveReferencias.setiCodigo(0);
                        rtaGenSaveReferencias.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }
                else {
                    ReferenciasSolAfilWeb rsaw = this.saveReferenciasSolAfilWeb(referenciasSolAfilWeb);
                    if (rsaw != null && rsaw.getICodigo() != null) {
                        rtaGenSaveReferencias.setbRta(Boolean.TRUE);
                        rtaGenSaveReferencias.setiCodigo(1);
                        rtaGenSaveReferencias.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de afiliación.");
                    }
                    else {
                        rtaGenSaveReferencias.setbRta(Boolean.FALSE);
                        rtaGenSaveReferencias.setiCodigo(0);
                        rtaGenSaveReferencias.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                    }
                }

            }
            else {
                rtaGenSaveReferencias.setbRta(Boolean.FALSE);
                rtaGenSaveReferencias.setiCodigo(0);
                rtaGenSaveReferencias.setsMsj("No se ha enviado el N° de radicado de la solicitud de afiliación. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        }
        else {
            rtaGenSaveReferencias.setbRta(Boolean.FALSE);
            rtaGenSaveReferencias.setiCodigo(0);
            rtaGenSaveReferencias.setsMsj("Verifique la información enviada.");
        }
        return rtaGenSaveReferencias;
    }

}
