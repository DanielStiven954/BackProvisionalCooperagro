/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.UsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.Acceso;
import com.co.ebs.cooperagro.domain.PerfilTransaccional;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.encriptarSha;
import com.co.ebs.cooperagro.general.sendInformacion;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestConsultaPersona;
import com.co.ebs.cooperagro.respuestasGenericas.DatoPersona;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseInformacionUsuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseOlvidoClave;
import com.co.ebs.cooperagro.respuestasGenericas.metodoEnvioOlvidoClave;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class UsuarioServiceBean implements UsuarioService {

    private final UsuarioDataAccessImp usuarioDataAccessImp = new UsuarioDataAccessImp();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final AccesoServiceBean accesoServiceBean = new AccesoServiceBean();

    private final utilidad util = new utilidad();
    private final encriptarSha sha = new encriptarSha();
    private final crearEmailHTML emailHTML = new crearEmailHTML();
    private final sendInformacion sendInfo = new sendInformacion();

    @Override
    public Usuario findUsuarioById(Long id) {
        Usuario usuario = usuarioDataAccessImp.findUsuarioById(id);
        return usuario;
    }

    @Override
    public Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent, int TipoPerfil) {
        Usuario findUserByPersonaIdent = usuarioDataAccessImp.findUserByPersonaIdent(iTipoIdent, sIdent, TipoPerfil);
        return findUserByPersonaIdent;
    }

    @Override
    public Usuario findUserByPersonaCodigo(Long codigo, String perfil) {
        Usuario findUserByPersonaIdent = usuarioDataAccessImp.findUserByPersonaCod(codigo, perfil);
        return findUserByPersonaIdent;
    }

    public Usuario findUserByPersonaIdent(RequestConsultaPersona request) {
        Usuario findUserByPersonaIdent = usuarioDataAccessImp.findUserByPersonaIdent(request);
        return findUserByPersonaIdent;
    }

    @Override
    public ResponseOlvidoClave validaOlvidoClave(String xsData, Long iTipoCanal) {
        Usuario usuario = new Usuario();
        ResponseOlvidoClave responseOlvidoClave = new ResponseOlvidoClave();
        try {
            String sIdent = "";
            int iTipoPerfil = 0, iTipoIdent = 0;
            String sDecodeData = util.decodeBase64(xsData);
            if (sDecodeData != null && !sDecodeData.equals("")) {
                String sSplitParam[] = sDecodeData.split(";");
                if (sSplitParam.length > 0) {
                    iTipoIdent = Integer.parseInt(sSplitParam[0]);
                    sIdent = sSplitParam[1];
                    iTipoPerfil = Integer.parseInt(sSplitParam[2]);
                }
                if (iTipoIdent != 0 && (sIdent != null && !sIdent.equals("")) && iTipoPerfil != 0) {
                    usuario = usuarioDataAccessImp.validaOlvidoClaveForUser(iTipoIdent, sIdent, iTipoPerfil, iTipoCanal);
                } else {
                    usuario.setbRta(Boolean.FALSE);
                    usuario.setsMensaje("En el momento no es posible realizar la validación. Por favor intente de nuevo más tarde.");
                }
            } else {
                usuario.setbRta(Boolean.FALSE);
                usuario.setsMensaje("En el momento no es posible realizar la validación. Por favor intente de nuevo más tarde.");
            }

            if (usuario.getbRta()) {
                List<PerfilTransaccional> perfilTransaccionalList = new ArrayList<>();
                List<metodoEnvioOlvidoClave> lstMetodoOlvidoClave = new ArrayList<>();
                boolean metodoValido = false;

                perfilTransaccionalList = usuario.getPerfilTransaccionalList();
                int i = 0;
                if (perfilTransaccionalList != null && !perfilTransaccionalList.isEmpty()) {
                    metodoEnvioOlvidoClave envioOlvidoClave = new metodoEnvioOlvidoClave();
                    for (PerfilTransaccional perfilTransaccional : perfilTransaccionalList) {
                        if (perfilTransaccional.getITransaccion().getITipoTran().getICodigo() == 2) {
                            if (perfilTransaccional.getITransaccion().getCEstado().equals("ACT")) {
                                i = i + 1;
                                switch (perfilTransaccional.getITransaccion().getCValidacion()) {
                                    case "EMAIL":
                                        String sEmailPersona = cygnusCoreServiceBean.getEmailPersona(String.valueOf(usuario.getIPersona().getICodigo()), String.valueOf(iTipoIdent), sIdent);
                                        if (sEmailPersona.contains("@")) {
                                            metodoValido = true;
                                            envioOlvidoClave.setiCodMetodoEnvio(i);
                                            envioOlvidoClave.setsValidaMetodo(perfilTransaccional.getITransaccion().getCValidacion());
                                            envioOlvidoClave.setsDescMetodoEnvio(perfilTransaccional.getITransaccion().getCDescripcion());
                                            envioOlvidoClave.setsDestinoEnvioClave(util.ocultarCorreo(sEmailPersona));
                                        } else {
                                            responseOlvidoClave.setbRta(Boolean.FALSE);
                                            responseOlvidoClave.setiCodigo(0);
                                            responseOlvidoClave.setsMsj("No cuenta con un correo registrado en COOPERAGRO, por favor comuniquese con COOPERAGRO para registrar un email. " + usuario.getIPersona().getICodigo() + " numero  " + sIdent);
                                        }

                                        break;
                                    case "SMS":
                                        //                                String sTelPersona = cygnusCoreServiceBean.getTelPersona(String.valueOf(usuario.getIPersona().getICodigo()), String.valueOf(iTipoIdent), sIdent);
                                        break;
                                    default:
                                        break;
                                }

                                lstMetodoOlvidoClave.add(envioOlvidoClave);
                            } else {
                                responseOlvidoClave.setbRta(Boolean.FALSE);
                                responseOlvidoClave.setiCodigo(0);
                                responseOlvidoClave.setsMsj("No cuenta con un metodo de envío de información activo.");
                            }
                        }
                    }
                } else {
                    responseOlvidoClave.setbRta(Boolean.FALSE);
                    responseOlvidoClave.setiCodigo(0);
                    responseOlvidoClave.setsMsj("No cuenta con un metodo de envío de información para realizar el proceso.");
                }
                if (lstMetodoOlvidoClave != null && !lstMetodoOlvidoClave.isEmpty() && metodoValido) {
                    responseOlvidoClave.setbRta(Boolean.TRUE);
                    responseOlvidoClave.setiCodigo(1);
                    responseOlvidoClave.setsMsj("Seleccione el metodo de envío al cual desea le sea enviada la clave.");
                    responseOlvidoClave.setMetodosEnvioInfoClave(lstMetodoOlvidoClave);
                }

            } else {
                responseOlvidoClave.setbRta(usuario.getbRta());
                responseOlvidoClave.setiCodigo(0);
                responseOlvidoClave.setsMsj(usuario.getsMensaje());
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            usuario.setbRta(Boolean.FALSE);
            usuario.setsMensaje("Ha ocurrido un inconveniente al intentar realizar la validación. Por favor intente de nuevo");
        }

        return responseOlvidoClave;
    }

    @Override
    public respuestaGenerica generarClaveNueva(String xsData) {
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            String sIdent = "", sValidaEnvioInfo = "";
            int iTipoIdent = 0;
            int TipoPerfil = 1 ;
            String sDecodeData = util.decodeBase64(xsData);
            if (sDecodeData != null && !sDecodeData.equals("")) {
                String sSplitParam[] = sDecodeData.split(";");
                if (sSplitParam.length > 0) {
                    iTipoIdent = Integer.parseInt(sSplitParam[0]);
                    sIdent = sSplitParam[1];
                    sValidaEnvioInfo = sSplitParam[2];
                    TipoPerfil = Integer.parseInt(sSplitParam[3]);
                }
                if (iTipoIdent != 0 && (sIdent != null && !sIdent.equals("")) && (sValidaEnvioInfo != null && !sValidaEnvioInfo.equals(""))) {
                    String sClaveEncriptada = "", sLlaveSeg = "", sNombresPersona = "", sApellidosPersona = "";
                    String sMinPrimerPassword = parametroServiceBean.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
                    String sCantSaltKeySeg = parametroServiceBean.obtenerParametroPorNombre("CANT_SALT");
                    String sDiasVigPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("DIAS_VIGENCIA_PRI_CLAVE");
                    int iMinPrimerPassword = Integer.parseInt(sMinPrimerPassword);
                    int iCantSaltKeySeg = Integer.parseInt(sCantSaltKeySeg);
                    int iDiasVigPrimeraClave = Integer.parseInt(sDiasVigPrimeraClave);
                    sLlaveSeg = util.generarAleatorio(iCantSaltKeySeg);
                    String sClave = util.passwordRandom(iMinPrimerPassword);
                    sClaveEncriptada = sha.encriptar(sClave, sLlaveSeg);
                    Usuario findUserByPersonaIdent = this.findUserByPersonaIdent(iTipoIdent, sIdent, TipoPerfil);
                    if (findUserByPersonaIdent != null && findUserByPersonaIdent.getICodigo() != null) {
                        Acceso findAccesoByiUser = accesoServiceBean.findAccesoByIUsuarioAndiTransaccion(findUserByPersonaIdent.getICodigo(), 1);
                        if (findAccesoByiUser != null && findAccesoByiUser.getICodigo() != null) {
                            Acceso updateAcceso = findAccesoByiUser;
                            Date fFinPrimeraClave = util.getDateAdd(iDiasVigPrimeraClave);
                            updateAcceso.setCClave(sClaveEncriptada);
                            updateAcceso.setCEstado("ACT");
                            updateAcceso.setCLlaveSeguridad(sLlaveSeg);
                            updateAcceso.setFInicio(new Date());
                            updateAcceso.setFFin(fFinPrimeraClave);
                            updateAcceso.setIUsuario(findUserByPersonaIdent);
                            updateAcceso.setITransaccion(findAccesoByiUser.getITransaccion());
                            Acceso updateAccesoByUser = accesoServiceBean.updateAcceso(updateAcceso);
                            if (updateAccesoByUser != null && updateAccesoByUser.getICodigo() != null) {
//                                sNombresPersona = updateAccesoByUser.getIUsuario().getIPersona().getCNombres();
//                                sApellidosPersona = updateAccesoByUser.getIUsuario().getIPersona().getCApellidos();
                                sNombresPersona = cygnusCoreServiceBean.getNombresCompletos(null, updateAcceso.getIUsuario().getIPersona().getITipoIdent().toString(), updateAcceso.getIUsuario().getIPersona().getCIdentificacion());
                                String sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(iTipoIdent), sIdent);
                                HashMap<String, String> hashMapData = new HashMap<>();
                                hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
                                hashMapData.put("sNumDOI", sIdent);
                                hashMapData.put("sNombreCompleto", sNombresPersona + " " + sApellidosPersona);
                                hashMapData.put("sClave", sClave);
                                hashMapData.put("sEmail", sEmailPersona);
                                String sEmalHTML = emailHTML.emailOlvidoClave(hashMapData);
                                rtaGenerica = sendInfo.sendInfoByPersona(iTipoIdent, sIdent, sValidaEnvioInfo, sEmalHTML, "OLVIDO CLAVE PORTAL COOPERAGRO E.C");
                            } else {
                                rtaGenerica.setbRta(Boolean.FALSE);
                                rtaGenerica.setiCodigo(0);
                                rtaGenerica.setsMsj("No se ha podigo restablecer la contraseña. Por favor intente de nuevo más tarde.");
                            }
                        } else {
                            rtaGenerica.setbRta(Boolean.FALSE);
                            rtaGenerica.setiCodigo(0);
                            rtaGenerica.setsMsj("No se ha podido obtener los datos de acceso del usuario. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                        }
                    } else {
                        rtaGenerica.setbRta(Boolean.FALSE);
                        rtaGenerica.setiCodigo(0);
                        rtaGenerica.setsMsj("No se ha podido obtener la información del usuario. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                    }
                } else {
                    rtaGenerica.setbRta(Boolean.FALSE);
                    rtaGenerica.setiCodigo(0);
                    rtaGenerica.setsMsj("En el momento no es posible realizar la generación de la clave. Por favor intente de nuevo más tarde.");
                }
            } else {
                rtaGenerica.setbRta(Boolean.FALSE);
                rtaGenerica.setiCodigo(0);
                rtaGenerica.setsMsj("En el momento no es posible realizar la generación de la clave. Por favor intente de nuevo más tarde.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rtaGenerica.setbRta(Boolean.FALSE);
            rtaGenerica.setsMsj("Se ha presentado un inconveniete al generar la nueva clave web, por favor intente de nuevo más tarde.");
        }

        return rtaGenerica;
    }

    public ResponseInformacionUsuario listarUsuarios() {
        ResponseInformacionUsuario response = new ResponseInformacionUsuario();
        List<Usuario> listaUsuari = usuarioDataAccessImp.findAllUsers();
        if (listaUsuari != null && !listaUsuari.isEmpty()) {
            List<DatoPersona> listaRta = new ArrayList();
            for (Usuario usuario : listaUsuari) {
                DatoPersona datoTemp = new DatoPersona();
                datoTemp.setiCodPersona(usuario.getIPersona().getICodigo());
                datoTemp.setiCodUsuario(usuario.getICodigo());
                if (usuario.getIPersona().getCNombres() != null && usuario.getIPersona().getCNombres() != "") {
                    datoTemp.setsNombres(usuario.getIPersona().getCNombres());
                } else {
                    datoTemp.setsNombres("N/A");
                }
                if (usuario.getIPersona().getCApellidos() != null && usuario.getIPersona().getCApellidos() != "") {
                    datoTemp.setsApellidos(usuario.getIPersona().getCApellidos());
                } else {
                    datoTemp.setsApellidos("N/A");
                }
                datoTemp.setcIdentificacion(usuario.getIPersona().getCIdentificacion());
                datoTemp.setcTipoIdentificacion(String.valueOf(usuario.getIPersona().getITipoIdent()));
                datoTemp.setcEstado(usuario.getCEstado());
                listaRta.add(datoTemp);
            }
            response.setFlag(true);
            response.setMsm("Usuarios encontrados correctamente");
            response.setListUsuarios(listaRta);
        } else {
            response.setFlag(false);
            response.setMsm("No se han encontrado usuarios");
        }
        return response;
    }
}
