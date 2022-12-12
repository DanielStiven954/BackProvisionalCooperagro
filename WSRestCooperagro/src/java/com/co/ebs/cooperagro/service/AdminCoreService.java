
package com.co.ebs.cooperagro.service;
import com.co.ebs.cooperagro.wscore.*;
import WSAdminCooperagro.*;

/**
 *
 * @author Brian Cardenas
 */
public interface AdminCoreService {
    
    ResponseTiposIdent wsTiposIdent();
    
    //ResponseTiposIdent wsTiposIdentHabilitados();
    
    ResponsePeriodo wsPeriodos();
   
    //ResponsePeriodo obtenerPeriodicidadHabilitadasSolCred();

//    ResponseEntidad obtenerEntidadesBancarias();

    ResponseLineaCredito wsLineaCredito();

    //ResponseLineaCredito findLineaCreditoById(Long codigo);

    //ResponsePeriodo findPeriodoById(Long codigo);

    String getNombreLineaCredito(Long lCodigo);

    String getDescPeriodo(Long lcodigo);
    
    ResponseNivelesEstudio wsTiposNivEstudio();

    //ResponseNivelesEstudio wsTiposNivEstudioById(int codigo);

    ResponseTipoEstadoCivil wsTipoEstadoCivil();

    //ResponseTipoEstadoCivil wsTipoEstadoCivilByID(String codigo);

    ResponseCiudad wsCiudad();

    //ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion);

    ResponseEntidad wsEntidades();
    
    ResponseProfesion wsProfesiones();
    
    ResponseCargo wsCargos();
}
