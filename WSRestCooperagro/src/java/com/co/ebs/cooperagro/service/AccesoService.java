package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.domain.Acceso;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.ebssas.PersonasDTO;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public interface AccesoService {

    Acceso saveAcceso(Acceso acceso);

    Acceso updateAcceso(Acceso acceso);

    Acceso findAccesoById(Long id);

    Acceso findAccesoByIdUser(Long idUser);

    void deleteAcceso(Acceso acceso);

    Acceso findAccesoByIUsuarioAndiTransaccion(Long idUser, int iTransaccion);

    List<Acceso> findAllAcceso();

    String getLLaveSeguridad(int tipoIdent, String sIdentificacion, String sTipoTransaccion, int iTipoPerfil, int iTipoCanal);

    String validarLoginUsuario(int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String navegador, String xiTipoCanal);

    public String validarLoginAdmin(int tipoPerfil, int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String navegador, String xiTipoCanal);

    String loginRegistroNuevoUsuario(int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String xiTipoCanal);

    Persona validarPersona(int xiTipoIden, String xcIdentificacion);

    PersonasDTO validaRegistroPersonaForLogin(int xiTipoIden, String xcIdentificacion);

    respuestaGenerica cerrarSession(Long idUsuario);

    PersonasDTO validaRegistroPersonaForLoginAdmin(int iPerfil, int xiTipoIden, String xcIdentificacion);

    respuestaGenerica cambiarPrimeraClave(String xCodUsuario, String xClaveAntigua, String xClaveNueva, String xClaveNuevaConf, int iTipoCanal);
    
    String validarCodLlave(String llave);
}
