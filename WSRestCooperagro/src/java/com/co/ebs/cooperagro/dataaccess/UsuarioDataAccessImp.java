/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import com.co.ebs.cooperagro.request.RequestConsultaPersona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class UsuarioDataAccessImp extends WSRestGenericRepositoryJPA<Usuario> implements UsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        Usuario createUsuario = create(usuario);
        return createUsuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario updateUsuario = update(usuario);
        return updateUsuario;
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        delete(usuario);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        Usuario usuario = find(id);
        return usuario;
    }

    @Override
    public Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent, int TipoPerfil) {
        Usuario findUserByPersonaIdent = new Usuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.* \n"
                    + "  FROM usuario u, persona p \n"
                    + " WHERE u.I_PERSONA = p.I_CODIGO \n"
                    + "   AND p.I_TIPO_IDENT = ? \n"
                    + "   AND p.C_IDENTIFICACION = ? \n"
                    + "   AND u.I_PERFIL = ? \n"
                    + "   AND p.C_ESTADO = 'ACT' \n"
                    + "   AND u.C_ESTADO = 'ACT' ", Usuario.class);

            consultDocument.setParameter(1, iTipoIdent);
            consultDocument.setParameter(2, sIdent);
            consultDocument.setParameter(3, TipoPerfil);

            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
                for (Usuario usuarioFindByPersonaIdent : listUsuario) {
                    if (usuarioFindByPersonaIdent.getIPersona().getCIdentificacion().equals(sIdent)) {
                        findUserByPersonaIdent = usuarioFindByPersonaIdent;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return findUserByPersonaIdent;
    }

    @Override
    public Usuario findUserByPersonaCod(Long codigo, String perfil) {
        Usuario findUserByPersonaIdent = new Usuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT * \n"
                    + "  FROM usuario  \n"
                    + " WHERE I_PERSONA = ? \n"
                    + " AND C_ESTADO = 'ACT' "
                    + " AND I_PERFIL = ? ", Usuario.class);

            consultDocument.setParameter(1, codigo);
            consultDocument.setParameter(2, perfil);

            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
                for (Usuario usuarioFindByPersonaCod : listUsuario) {
                    if (usuarioFindByPersonaCod.getIPersona().getICodigo().equals(codigo)) {
                        findUserByPersonaIdent = usuarioFindByPersonaCod;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return findUserByPersonaIdent;
    }

    public Usuario findUserByPersonaIdent(RequestConsultaPersona request) {
        Usuario findUserByPersonaIdent = new Usuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.* \n"
                    + "  FROM usuario u, persona p \n"
                    + " WHERE u.I_PERSONA = p.I_CODIGO \n"
                    + "   AND p.I_TIPO_IDENT = ? \n"
                    + "   AND p.C_IDENTIFICACION = ? \n"
                    + "   AND p.C_ESTADO = 'ACT' \n"
                    + "   AND u.C_ESTADO = 'ACT' ", Usuario.class);

            consultDocument.setParameter(1, request.getITipo());
            consultDocument.setParameter(2, request.getCIdentificacion());

            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
                for (Usuario usuarioFindByPersonaIdent : listUsuario) {
                    if (usuarioFindByPersonaIdent.getIPersona().getCIdentificacion().equals(request.getCIdentificacion())) {
                        findUserByPersonaIdent = usuarioFindByPersonaIdent;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return findUserByPersonaIdent;
    }

    @Override
    public Usuario validaOlvidoClaveForUser(int xiTipoIdent, String xsIdent, int xiTipoPerfil, Long iTipoCanal) {
        Usuario usuarioValidaOlvidoClave = new Usuario();
        connectionDBJPA connDBJPA = new connectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_VALIDACION.PRC_VAL_OLVIDO_CONTRASENIA");
            storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, Long.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.OUT);

            storedProcedureQuery.setParameter(1, xsIdent);
            storedProcedureQuery.setParameter(2, xiTipoIdent);
            storedProcedureQuery.setParameter(3, xiTipoPerfil);
            storedProcedureQuery.setParameter(4, iTipoCanal);

            storedProcedureQuery.execute();

            Long lCodUser;
            if (storedProcedureQuery.getOutputParameterValue(5) != null) {
                lCodUser = new Long(storedProcedureQuery.getOutputParameterValue(5).toString());
            } else {
                lCodUser = new Long(0);
            }

            int cod_mensaje = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(6).toString());
            String mensaje = storedProcedureQuery.getOutputParameterValue(7).toString();

            if (cod_mensaje == 1 && mensaje.equals("true")) {
                Usuario findUsuarioById = this.findUsuarioById(lCodUser);
                if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
                    findUsuarioById.setcCodMensaje(cod_mensaje);
                    findUsuarioById.setbRta(Boolean.TRUE);
                    findUsuarioById.setsMensaje("El usuario se encuentra registrado y puede continuar con el proceso de olvido contraseña.");
                    usuarioValidaOlvidoClave = findUsuarioById;
                } else {
                    usuarioValidaOlvidoClave.setcCodMensaje(cod_mensaje);
                    usuarioValidaOlvidoClave.setbRta(Boolean.FALSE);
                    usuarioValidaOlvidoClave.setsMensaje("No se ha encontrado registro del usuario en el portal. Por favor intente de nuevo.");
                }
            } else {
                usuarioValidaOlvidoClave.setcCodMensaje(cod_mensaje);
                usuarioValidaOlvidoClave.setbRta(Boolean.FALSE);
                usuarioValidaOlvidoClave.setsMensaje("No se ha encontrado registro del usuario con N° de documento " + xsIdent + ".");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return usuarioValidaOlvidoClave;
    }

    public List<Usuario> findAllUsers() {
        return findAll();
    }
}
