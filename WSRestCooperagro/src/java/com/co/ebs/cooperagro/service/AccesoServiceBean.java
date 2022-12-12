package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.AccesoDataAccessImp;
import com.co.ebs.cooperagro.domain.Acceso;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.domain.TipoCanal;
import com.co.ebs.cooperagro.domain.SessionUsuario;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.encriptarSha;
import com.co.ebs.cooperagro.general.sendInformacion;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.security.JwtTokenHelper;
import com.ebssas.PersonasDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Brian Cardenas
 */
public class AccesoServiceBean implements AccesoService {

    //CAPA DE NEGOCIO
    private final AccesoDataAccessImp accesoDataAccessImp = new AccesoDataAccessImp();
    private final JwtTokenHelper jwtTokenHelper = new JwtTokenHelper();

    //UTILIDADES U OTROS
    private final encriptarSha encripta = new encriptarSha();
    private final utilidad util = new utilidad();

    private final crearEmailHTML emailHTML = new crearEmailHTML();
    private final sendInformacion sendInfo = new sendInformacion();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();

    @Override
    public Acceso saveAcceso(Acceso acceso) {
        return accesoDataAccessImp.saveAcceso(acceso);
    }

    @Override
    public Acceso updateAcceso(Acceso acceso) {
        return accesoDataAccessImp.updateAcceso(acceso);
    }

    @Override
    public Acceso findAccesoById(Long id) {
        return accesoDataAccessImp.findAccesoById(id);
    }

    @Override
    public Acceso findAccesoByIdUser(Long idUser) {
        return accesoDataAccessImp.findAccesoByIdUser(idUser);
    }

    @Override
    public void deleteAcceso(Acceso acceso) {
        accesoDataAccessImp.deleteAcceso(acceso);
    }

    @Override
    public List<Acceso> findAllAcceso() {
        List<Acceso> listAllAccesos = new ArrayList<>();
        listAllAccesos = accesoDataAccessImp.findAll();
        return listAllAccesos;
    }

    @Override
    public Acceso findAccesoByIUsuarioAndiTransaccion(Long idUser, int iTransaccion) {
        return accesoDataAccessImp.findAccesoByIUsuarioAndiTransaccion(idUser, iTransaccion);
    }

    @Override
    public String getLLaveSeguridad(int tipoIdent, String sIdentificacion, String sTipoTransaccion, int iTipoPerfil, int iTipoCanal) {

        String Llave = accesoDataAccessImp.getLlaveSeguridadAcceso(tipoIdent, sIdentificacion, sTipoTransaccion, iTipoPerfil, iTipoCanal);
        return Llave;
    }

    public int suma(int w, int f) {
        if (w == 0 || f == 0) {
            return w;
        }
        return w + f;
    }

    @Override
    public String validarLoginAdmin(int tipoPerfil, int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String navegador, String xiTipoCanal) {
        String jwtResp = "";

        String jwt;
        String sClaveUser = "";
        HashMap<String, Object> valToken = new HashMap<String, Object>();
        //Persona valPersona = new Persona();
        PersonasDTO personaDTO = null;
        personaDTO = validaRegistroPersonaForLoginAdmin(tipoPerfil, tipoIdent, sIdentificacion);

        if (personaDTO != null && personaDTO.isBResultado()) {
            String sLlaveSeguridad = this.getLLaveSeguridad(tipoIdent, sIdentificacion, sTipoTransaccion, tipoPerfil, Integer.parseInt(xiTipoCanal));
            if (sLlaveSeguridad != null && !sLlaveSeguridad.equals("") && !sLlaveSeguridad.equals("0")) {
                sClaveUser = encripta.encriptar(xcClave, sLlaveSeguridad);
                if (sClaveUser != null && !sClaveUser.equals("")) {
//                    Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, tipoPerfil);
                    Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, tipoPerfil, Integer.parseInt(xiTipoCanal));
                    if (respValClave != null && respValClave.getcCodMensaje() == 1) {

                        long idTipoCanal = Long.parseLong(xiTipoCanal);

                        TipoCanal tipoCanal = new TipoCanalServiceBean().findTipoCanalById(idTipoCanal);
                        new SessionUsuarioServiceBean().saveSession(respValClave, navegador, tipoCanal);

//                        SessionUsuario consultaUltimaConexion = session.findSessionByUser(respValClave.getICodigo());
                        SessionUsuario consultaUltimaConexion = new SessionUsuarioServiceBean().findSessionByUser(respValClave.getICodigo(), idTipoCanal);

                        String fechaConexion = "";
                        if (consultaUltimaConexion != null && consultaUltimaConexion.getICodigo() != null) {
                            fechaConexion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(consultaUltimaConexion.getFConexion());
                        } else {
                            fechaConexion = "N/A";
                        }

                        String nombres = "";
                        if (personaDTO.getCNombres() != null && personaDTO.getCApellidos() != null) {
                            nombres = personaDTO.getCNombres() + " " + personaDTO.getCApellidos();
                        } else {
                            nombres = new CygnusCoreServiceBean().getNombresCompletos(null, String.valueOf(tipoIdent), sIdentificacion);
                        }

                        int cantidadNotifiSinLeer = new NotificacionUsuarioServiceBean().notificacionesSinLeer(respValClave);
                        String sGenero = new CygnusCoreServiceBean().getGeneroPersona(null, String.valueOf(tipoIdent), sIdentificacion);
                        valToken.put("bRta", respValClave.getbRta());
                        valToken.put("codMsj", respValClave.getcCodMensaje());
                        valToken.put("sMsj", respValClave.getsMensaje());
                        valToken.put("codUser", respValClave.getICodigo());
                        valToken.put("tipoPerfil", respValClave.getIPerfil().getICodigo());
                        valToken.put("codPersona", respValClave.getIPersona().getICodigo());
                        valToken.put("ultimaConexion", fechaConexion);
                        valToken.put("notificacionesSinLeer", cantidadNotifiSinLeer);
                        valToken.put("nombres", nombres);
                        valToken.put("genero", sGenero);
//                        String[] notifiSinLeer = notifi.dosUltimasNotificacionesSinLeer(respValClave);
//                        if(notifiSinLeer!=null && notifiSinLeer.length>0){
//                            valToken.put("notificacionUno", notifiSinLeer[0]);
//                            if(notifiSinLeer[1]!=null){
//                                valToken.put("notificacionDos", notifiSinLeer[1]);
//                            }
//                        }
                        jwt = jwtTokenHelper.generateJwtTokenSucces(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                        jwtResp = json.toString();

                    } else {
                        valToken.put("bRta", Boolean.FALSE);
                        valToken.put("sMsj", respValClave.getsMensaje());
                        jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                        jwtResp = json.toString();
                    }
                } else {
                    valToken.put("bRta", Boolean.FALSE);
                    valToken.put("sMsj", "No se ha podido validar la clave. Por favor intente de nuevo.");
                    jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                    JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                    jwtResp = json.toString();
                }
            } else {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", "La contraseña ha expirado o no cuenta con una clave aun.");
                jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                jwtResp = json.toString();
            }

        } else {
            valToken.put("bRta", personaDTO.isBResultado());
            valToken.put("sMsj", personaDTO.getCMjs());
            jwt = jwtTokenHelper.generateJwtTokenError(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
            jwtResp = json.toString();
        }

        System.err.println("ENVIANDO RESPUESTA DE [validarLoginUsuario]:\n" + jwtResp);
        return jwtResp;
    }

    @Override
    public String validarLoginUsuario(int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String navegador, String xiTipoCanal) {
        String jwtResp = "";

        String jwt;
        String sClaveUser = "";
        HashMap<String, Object> valToken = new HashMap<String, Object>();
        PersonasDTO personaDTO;
        personaDTO = validaRegistroPersonaForLogin(tipoIdent, sIdentificacion);
        System.out.println("personaDTO: " + personaDTO.toString());
        if (personaDTO != null && personaDTO.isBResultado()) {
            int iTipoPerfil = this.getTipoPerson(personaDTO.getCTipoPerson());
//            String sLlaveSeguridad = this.getLLaveSeguridad(tipoIdent, sIdentificacion, sTipoTransaccion, iTipoPerfil);
//            String sLlaveSeguridad = this.validarCodLlave(personaDTO.getICodigo());
            String sLlaveSeguridad = this.getLLaveSeguridad(tipoIdent, sIdentificacion, sTipoTransaccion, iTipoPerfil, Integer.parseInt(xiTipoCanal));
//            String sLlaveSeguridad = "6912196758";
            System.out.println("sLlaveSeguridad: " + sLlaveSeguridad);
            if (sLlaveSeguridad != null && !sLlaveSeguridad.equals("") && !sLlaveSeguridad.equals("0")) {
                sClaveUser = encripta.encriptar(xcClave, sLlaveSeguridad);
                if (sClaveUser != null && !sClaveUser.equals("")) {
//                    Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, iTipoPerfil);
                    Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, iTipoPerfil, Integer.parseInt(xiTipoCanal));

                    if (respValClave != null && respValClave.getcCodMensaje() == 1) {

                        long idTipoCanal = Long.parseLong(xiTipoCanal);
                        TipoCanal tipoCanal = new TipoCanalServiceBean().findTipoCanalById(idTipoCanal);
                        SessionUsuarioServiceBean sessionUsuarioServiceBean = new SessionUsuarioServiceBean();
                        sessionUsuarioServiceBean.updateSessionActByUser(respValClave.getICodigo(), idTipoCanal);
                        sessionUsuarioServiceBean.saveSession(respValClave, navegador, tipoCanal);

                        SessionUsuario consultaUltimaConexion = new SessionUsuarioServiceBean().findSessionByUser(respValClave.getICodigo(), idTipoCanal);
                        String fechaConexion = "";
                        if (consultaUltimaConexion != null && consultaUltimaConexion.getICodigo() != null) {
                            fechaConexion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(consultaUltimaConexion.getFConexion());
                        } else {
                            fechaConexion = "N/A";
                        }
                        String nombres = "";
                        if (personaDTO.getCNombres() != null && personaDTO.getCApellidos() != null) {
                            nombres = personaDTO.getCNombres() + " " + personaDTO.getCApellidos();

                        } else {
                            nombres = new CygnusCoreServiceBean().getNombresCompletos(null, String.valueOf(tipoIdent), sIdentificacion);
                        }

                        String sGenero = personaDTO.getCSexo();
                        //new CygnusCoreServiceBean().getGeneroPersona(null, String.valueOf(tipoIdent), sIdentificacion);

                        int cantidadNotifiSinLeer = new NotificacionUsuarioServiceBean().notificacionesSinLeer(respValClave);
                        valToken.put("notificacionesSinLeer", cantidadNotifiSinLeer);
                        valToken.put("bRta", respValClave.getbRta());
                        valToken.put("codMsj", respValClave.getcCodMensaje());
                        valToken.put("sMsj", respValClave.getsMensaje());
                        valToken.put("codUser", respValClave.getICodigo());
                        valToken.put("tipoPerfil", respValClave.getIPerfil().getICodigo());
                        valToken.put("codPersona", respValClave.getIPersona().getICodigo());
                        valToken.put("ultimaConexion", fechaConexion);
                        valToken.put("nombres", nombres);
                        valToken.put("genero", sGenero);
                        jwt = jwtTokenHelper.generateJwtTokenSucces(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                        jwtResp = json.toString();

                    } else {
                        valToken.put("bRta", Boolean.FALSE);
                        valToken.put("sMsj", respValClave.getsMensaje());
                        jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                        jwtResp = json.toString();
                    }
                } else {
                    valToken.put("bRta", Boolean.FALSE);
                    valToken.put("sMsj", "No se ha podido validar la clave. Por favor intente de nuevo.");
                    jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                    JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                    jwtResp = json.toString();
                }
            } else {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", "La contraseña ha expirado o no cuenta con una clave aun.");
                jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                jwtResp = json.toString();
            }

        } else {
            valToken.put("bRta", personaDTO.isBResultado());
            valToken.put("sMsj", personaDTO.getCMjs());
            jwt = jwtTokenHelper.generateJwtTokenError(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
            jwtResp = json.toString();
        }

        System.err.println("ENVIANDO RESPUESTA DE [validarLoginUsuario]:\n" + jwtResp);

        return jwtResp;
    }

    @Override
    public String loginRegistroNuevoUsuario(int tipoIdent, String sIdentificacion, String sTipoTransaccion, String xcClave, String xiTipoCanal) {

        String jwtResp = "";
        String jwt;
        String sClaveUser = "";
        HashMap<String, Object> valToken = new HashMap<String, Object>();

        int iTipoPerfil = new CygnusCoreServiceBean().getTipoPerson("", String.valueOf(tipoIdent), sIdentificacion);
//        String sLlaveSeguridad = this.getLLaveSeguridad(tipoIdent, sIdentificacion, sTipoTransaccion, iTipoPerfil);
        String sLlaveSeguridad = this.getLLaveSeguridad(tipoIdent, sIdentificacion, sTipoTransaccion, iTipoPerfil, Integer.parseInt(xiTipoCanal));
        if (sLlaveSeguridad != null && !sLlaveSeguridad.equals("") && !sLlaveSeguridad.equals("0")) {

            //Persona valPersona = new Persona();
            PersonasDTO valPersona;
            valPersona = validaRegistroPersonaForLogin(tipoIdent, sIdentificacion);

            sClaveUser = encripta.encriptar(xcClave, sLlaveSeguridad);
            if (sClaveUser != null && !sClaveUser.equals("")) {
//                Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, iTipoPerfil);
                Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(tipoIdent, sIdentificacion, sClaveUser, iTipoPerfil, Integer.parseInt(xiTipoCanal));

                String nombres = "";
                if (valPersona != null && valPersona.getCNombres() != null && valPersona.getCApellidos() != null) {
                    nombres = valPersona.getCNombres() + " " + valPersona.getCApellidos();
                } else {
                    nombres = new CygnusCoreServiceBean().getNombresCompletos(null, String.valueOf(tipoIdent), sIdentificacion);
                }

                String sGenero = new CygnusCoreServiceBean().getGeneroPersona(null, String.valueOf(tipoIdent), sIdentificacion);

                if (respValClave != null && respValClave.getcCodMensaje() == 1) {
                    int cantidadNotifiSinLeer = new NotificacionUsuarioServiceBean().notificacionesSinLeer(respValClave);

                    valToken.put("bRta", respValClave.getbRta());
                    valToken.put("codMsj", respValClave.getcCodMensaje());
                    valToken.put("sMsj", respValClave.getsMensaje());
                    valToken.put("codUser", respValClave.getICodigo());
                    valToken.put("tipoPerfil", respValClave.getIPerfil().getICodigo());
                    valToken.put("codPersona", respValClave.getIPersona().getICodigo());
                    valToken.put("notificacionesSinLeer", cantidadNotifiSinLeer);
                    valToken.put("nombres", nombres);
                    valToken.put("genero", sGenero);
                    jwt = jwtTokenHelper.generateJwtTokenSucces(valToken);
                    JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                    jwtResp = json.toString();
                } else {
                    valToken.put("bRta", Boolean.FALSE);
                    valToken.put("sMsj", respValClave.getsMensaje());
                    jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                    JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                    jwtResp = json.toString();
                }
            } else {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", "No se ha podido validar la clave ingresada con la registrada. Por favor intente de nuevo.");
                jwt = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                jwtResp = json.toString();
            }
        } else {
            valToken.put("bRta", Boolean.FALSE);
            valToken.put("sMsj", "La contraseña ha expirado o no cuenta con una clave aun.");
            jwt = jwtTokenHelper.generateJwtTokenError(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
            jwtResp = json.toString();
        }

        return jwtResp;
    }

    @Override
    public Persona validarPersona(int xiTipoIden, String xcIdentificacion) {
        Persona personaWeb = new Persona();

        // busca a la persona en core
        List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(xiTipoIden), xcIdentificacion);

        if (personaCore != null && !personaCore.isEmpty()) {

            // busca a la persona en la bd web
            personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacion(xiTipoIden, xcIdentificacion);
            if (personaWeb != null && personaWeb.getICodigo() != null) {
                personaWeb.setbRta(Boolean.FALSE);
                personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " ya se encuentra registrado en el portal transaccional de COOPERAGRO.");
            } else {
                personaWeb.setbRta(Boolean.TRUE);
                personaWeb.setsMsj("Ahora debe responder unas preguntas de seguridad para generar el registro en el portal transaccional de COOPERAGRO.");
            }
        } else {
            personaWeb.setbRta(Boolean.FALSE);
            personaWeb.setsMsj("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse dirigirse a la opción de Afiliación.");
        }
        return personaWeb;
    }

    /*@Override
    public Persona validaRegistroPersonaForLoginAdmin(int iPerfil, int xiTipoIden, String xcIdentificacion) {
        Persona personaWeb = new Persona();
        List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(xiTipoIden), xcIdentificacion);

        if (personaCore != null && !personaCore.isEmpty()) {
            personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacionAndPerfil(iPerfil, xiTipoIden, xcIdentificacion);
            if (personaWeb != null && personaWeb.getICodigo() != null) {
                personaWeb.setbRta(Boolean.TRUE);
                personaWeb.setsMsj("El usuario se encuentra registrado.");
            } else {
                personaWeb = new Persona();
                personaWeb.setbRta(Boolean.FALSE);
                personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");
            }
        } else {
            personaWeb.setbRta(Boolean.FALSE);
            personaWeb.setsMsj("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");
        }
        return personaWeb;
    }*/
    @Override
    public PersonasDTO validaRegistroPersonaForLoginAdmin(int iPerfil, int xiTipoIden, String xcIdentificacion) {
        Persona personaWeb = new Persona();
        List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(xiTipoIden), xcIdentificacion);
        PersonasDTO personaDTO = null;

        if (personaCore != null && !personaCore.isEmpty()) {
            personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacionAndPerfil(iPerfil, xiTipoIden, xcIdentificacion);

            // ANDRES SIERRA LOG:
            if (personaWeb == null) {
                System.err.println("NULL ALERT :: service/AccesoServiceBean.java :: personaWeb 402"
                        + "retorna NULL");
            } else if (personaWeb.getICodigo() == null) {
                System.err.println("NULL ALERT :: service/AccesoServiceBean.java :: personaWeb.getICodigo 402"
                        + "retorna NULL:");
            }

            if (personaWeb != null && personaWeb.getICodigo() != null) {

                for (PersonasDTO personasDTO : personaCore) {
                    if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                        personaDTO = personasDTO;
                        break;
                    } else {

                    }
                }

                personaDTO.setBResultado(Boolean.TRUE);
                personaDTO.setCMjs("El usuario se encuentra registrado.");

            } else {
                personaDTO = new PersonasDTO();
                personaDTO.setBResultado(Boolean.FALSE);
                personaDTO.setCMjs("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");
                /*personaWeb = new Persona();
                personaWeb.setbRta(Boolean.FALSE);
                personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");*/
            }
        } else {
            /*personaWeb.setbRta(Boolean.FALSE);
            personaWeb.setsMsj("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");*/
            personaDTO = new PersonasDTO();
            personaDTO.setBResultado(Boolean.FALSE);
            personaDTO.setCMjs("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");
        }
        return personaDTO;
    }

    /*@Override
    public Persona validaRegistroPersonaForLogin(int xiTipoIden, String xcIdentificacion) {
        Persona personaWeb = new Persona();
        List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(xiTipoIden), xcIdentificacion);

        if (personaCore != null && !personaCore.isEmpty()) {
            personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacion(xiTipoIden, xcIdentificacion);
            if (personaWeb != null && personaWeb.getICodigo() != null) {
                personaWeb.setbRta(Boolean.TRUE);
                personaWeb.setsMsj("El usuario se encuentra registrado.");
            } else {
                personaWeb.setbRta(Boolean.FALSE);
                personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");
            }
        } else {
            personaWeb.setbRta(Boolean.FALSE);
            personaWeb.setsMsj("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");
        }
        return personaWeb;
    }*/
    @Override
    public PersonasDTO validaRegistroPersonaForLogin(int xiTipoIden, String xcIdentificacion) {
        Persona personaWeb = new Persona();
        List<PersonasDTO> personaCore = new CygnusCoreServiceBean().wsConsultarPersona("", String.valueOf(xiTipoIden), xcIdentificacion);
        PersonasDTO personaDTO = null;
        personaDTO = new PersonasDTO();

        if (personaCore != null && !personaCore.isEmpty()) {
            personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacion(xiTipoIden, xcIdentificacion);
            if (personaWeb != null && personaWeb.getICodigo() != null) {

                for (PersonasDTO personasDTO : personaCore) {
                    if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                        personaDTO = personasDTO;
                        break;
                    }
                }

                personaDTO.setBResultado(Boolean.TRUE);
                personaDTO.setCMjs("El usuario se encuentra registrado.");

                //personaWeb.setbRta(Boolean.TRUE);
                //personaWeb.setsMsj("El usuario se encuentra registrado.");
            } else {
                personaDTO.setBResultado(Boolean.FALSE);
                personaDTO.setCMjs("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");
                //personaWeb.setbRta(Boolean.FALSE);
                //personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " no se encuentra registrado en el portal transaccional de COOPERAGRO. Por favor reealice el proceso de registro.");
            }
        } else {

            personaDTO.setBResultado(Boolean.FALSE);
            personaDTO.setCMjs("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");
            //personaWeb.setbRta(Boolean.FALSE);
            //personaWeb.setsMsj("No se ha encontrado registro en COOPERAGRO con el N° de documento " + xcIdentificacion + ", si desea afiliarse visite la opción de Afiliación.");
        }
        return personaDTO;
    }

    @Override
    public respuestaGenerica cerrarSession(Long idUsuario) {
        SessionUsuario buscarSessionACT = new SessionUsuarioServiceBean().findSessionACTByUser(idUsuario);
        buscarSessionACT.setCEstado("INA");
        SessionUsuario sessionUpd = new SessionUsuarioServiceBean().updateSession(buscarSessionACT);
        respuestaGenerica respuesta = new respuestaGenerica();
        if (sessionUpd.getCEstado().equals("INA")) {
            respuesta.setbRta(Boolean.TRUE);
            respuesta.setiCodigo(1);
            respuesta.setsMsj("Se ha cerrado la sesión correctamente");
        } else {
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setiCodigo(2);
            respuesta.setsMsj("Ha ocurrido un error al cerrar la sesión");
        }
        return respuesta;
    }

    @Override
    public respuestaGenerica cambiarPrimeraClave(String xCodUsuario, String xClaveAntigua, String xClaveNueva, String xClaveNuevaConf, int iTipoCanal) {
        respuestaGenerica respuesta = new respuestaGenerica();
        try {
            Acceso acceso = this.findAccesoByIdUser(Long.parseLong(xCodUsuario));
            Usuario usuario = acceso.getIUsuario();
            Date fecha = new Date();
            String sClaveAntigua = "", sClaveNueva = "", sConfNueva = "";
            sClaveAntigua = util.decodeBase64(xClaveAntigua);
            sClaveNueva = util.decodeBase64(xClaveNueva);
            sConfNueva = util.decodeBase64(xClaveNuevaConf);
            String claveAntEncriptada = encripta.encriptar(sClaveAntigua, acceso.getCLlaveSeguridad());
            if (claveAntEncriptada.equals(acceso.getCClave())) {
                String canRegistrosValAuditoria = new ParametroServiceBean().obtenerParametroPorNombre("NUM_REGIS_VAL_AUD_CLAVE");
                String claveNuevaEncriptada = encripta.encriptar(sClaveNueva, String.valueOf(acceso.getCLlaveSeguridad()));
                boolean validarClave = new AuditoriaClaveServiceBean().bValidaClaveAnterior(usuario.getICodigo(), claveNuevaEncriptada, Integer.parseInt(canRegistrosValAuditoria), Integer.parseInt(String.valueOf(acceso.getITransaccion().getICodigo())), iTipoCanal);
                if (validarClave) {
                    int digMinPass = Integer.parseInt(new ParametroServiceBean().obtenerParametroPorNombre("MIN_PRIMER_PASSWORD"));
                    int digMaxPass = Integer.parseInt(new ParametroServiceBean().obtenerParametroPorNombre("MAX_PRIMER_PASSWORD"));
                    String isAlphanum = new ParametroServiceBean().obtenerParametroPorNombre("PASSWORD_ALPHANUMERICO");
                    if (isAlphanum.equals("SI")) {
                        boolean claveValidada = util.verificarAlfanumerico(sClaveNueva, digMinPass, digMaxPass);
                        if (!claveValidada) {
                            respuesta.setbRta(Boolean.FALSE);
                            respuesta.setsMsj("La clave debe contener al menos un digito, una mayuscula y una minuscula. "
                                    + "la longitud de la clave debe estar entre " + digMinPass + " y " + digMaxPass + ".");
                            return respuesta;
                        }
                    }

                    if (sClaveNueva.equals(sConfNueva)) {
                        acceso.setCClave(claveNuevaEncriptada);
                        acceso.setFInicio(fecha);
                        String diasClavValida = new ParametroServiceBean().obtenerParametroPorNombre("DIAS_VIGENCIA_PRI_CLAVE");
                        acceso.setFInicio(new Date());
                        acceso.setFFin(util.obtenerFechaFinalAcceso(fecha, Integer.parseInt(diasClavValida)));
                        Acceso actualizado = this.updateAcceso(acceso);
                        if (actualizado != null) {
                            respuesta.setbRta(Boolean.TRUE);
                            respuesta.setsMsj("La clave se ha cambiado satisfactoriamente");
                        } else {
                            respuesta.setbRta(Boolean.FALSE);
                            respuesta.setsMsj("Ha ocurrido un error al actualizar la contraseña");
                        }
                    } else {
                        respuesta.setbRta(Boolean.FALSE);
                        respuesta.setsMsj("La contraseña nueva no coincide con la de verificación");
                    }

                } else {
                    respuesta.setbRta(Boolean.FALSE);
                    respuesta.setsMsj("La nueva contraseña debe ser diferente a las anteriores registradas");
                }
            } else {
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setsMsj("La contraseña antigua no concuerda");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Se ha presentando un inconveniente al procesar el cambio de clave.");
        }

        return respuesta;
    }

    public int getTipoPerson(String tipoPersona) {
        int iTipoPerson = 0;

        if (tipoPersona.equals("N")) {
            iTipoPerson = 2;
        } else if (tipoPersona.equals("J")) {
            iTipoPerson = 3;
        } else {
            iTipoPerson = 2;
        }

        return iTipoPerson;
    }

    public respuestaGenerica restaurarClave(Long codUsuario) {
        respuestaGenerica generica = new respuestaGenerica();
        UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();
        Usuario usuarioB = usuarioServiceBean.findUsuarioById(codUsuario);
        if (usuarioB != null && usuarioB.getICodigo() != null) {
            Acceso accesoU = this.findAccesoByIdUser(codUsuario);
            if (accesoU != null && accesoU.getICodigo() != null) {
                String llave = this.getLLaveSeguridad(usuarioB.getIPersona().getITipoIdent().intValue(), usuarioB.getIPersona().getCIdentificacion(), "1", 2, 1);
                String hash = encripta.encriptar(usuarioB.getIPersona().getCIdentificacion(), llave);
                accesoU.setCClave(hash);
                Acceso accesoAct = this.updateAcceso(accesoU);
                if (accesoAct != null) {
                    generica.setbRta(Boolean.TRUE);
                    generica.setsMsj("La clave se ha restaurado satisfactoriamente");
                    generica.setiCodigo(1);
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("Se ha presentando un inconveniente al procesar la resturación de clave.");
                    generica.setiCodigo(0);
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("El usuario no cuenta con acceso");
                generica.setiCodigo(0);
            }

        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("El usuario no es válido");
            generica.setiCodigo(0);
        }

        return generica;
    }

    public respuestaGenerica restaurarClaveNueva(Long codUsuario) {
        respuestaGenerica generica = new respuestaGenerica();
        UsuarioServiceBean usuarioServiceBean = new UsuarioServiceBean();

        try {

            generica = new AccesoUsuarioServiceBean().desbloquearUsuario(String.valueOf(codUsuario));
            int TipoPerfil = 1;
            if (generica.getbRta()) {
                Usuario usuarioB = usuarioServiceBean.findUsuarioById(codUsuario);
                if (usuarioB != null && usuarioB.getICodigo() != null) {
                    String sClaveEncriptada = "", sLlaveSeg = "", sNombresPersona = "", sApellidosPersona = "";
                    String sMinPrimerPassword = parametroServiceBean.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
                    String sCantSaltKeySeg = parametroServiceBean.obtenerParametroPorNombre("CANT_SALT");
                    String sDiasVigPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("DIAS_VIGENCIA_PRI_CLAVE");
                    int iMinPrimerPassword = Integer.parseInt(sMinPrimerPassword);
                    int iCantSaltKeySeg = Integer.parseInt(sCantSaltKeySeg);
                    int iDiasVigPrimeraClave = Integer.parseInt(sDiasVigPrimeraClave);
                    sLlaveSeg = util.generarAleatorio(iCantSaltKeySeg);
                    String sClave = util.passwordRandom(iMinPrimerPassword);
                    sClaveEncriptada = encripta.encriptar(sClave, sLlaveSeg);
                    Usuario findUserByPersonaIdent = new UsuarioServiceBean().findUserByPersonaIdent(usuarioB.getIPersona().getITipoIdent().intValue(), usuarioB.getIPersona().getCIdentificacion(), TipoPerfil);
                    if (findUserByPersonaIdent != null && findUserByPersonaIdent.getICodigo() != null) {
                        Acceso findAccesoByiUser = this.findAccesoByIUsuarioAndiTransaccion(findUserByPersonaIdent.getICodigo(), 1);
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
                            Acceso updateAccesoByUser = this.updateAcceso(updateAcceso);
                            if (updateAccesoByUser != null && updateAccesoByUser.getICodigo() != null) {
//                                sNombresPersona = updateAccesoByUser.getIUsuario().getIPersona().getCNombres();
//                                sApellidosPersona = updateAccesoByUser.getIUsuario().getIPersona().getCApellidos();
                                sNombresPersona = cygnusCoreServiceBean.getNombresCompletos(null, updateAcceso.getIUsuario().getIPersona().getITipoIdent().toString(), updateAcceso.getIUsuario().getIPersona().getCIdentificacion());
                                String sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(usuarioB.getIPersona().getITipoIdent()), usuarioB.getIPersona().getCIdentificacion());
                                HashMap<String, String> hashMapData = new HashMap<>();
                                hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
                                hashMapData.put("sNumDOI", usuarioB.getIPersona().getCIdentificacion());
                                hashMapData.put("sNombreCompleto", sNombresPersona + " " + sApellidosPersona);
                                hashMapData.put("sClave", sClave);
                                hashMapData.put("sEmail", sEmailPersona);
                                String sEmalHTML = emailHTML.emailOlvidoClave(hashMapData);
                                generica = sendInfo.sendInfoByPersona(usuarioB.getIPersona().getITipoIdent().intValue(), usuarioB.getIPersona().getCIdentificacion(), "EMAIL", sEmalHTML, "OLVIDO CLAVE PORTAL COOPERAGRO E.C");
                            } else {
                                generica.setbRta(Boolean.FALSE);
                                generica.setiCodigo(0);
                                generica.setsMsj("No se ha podigo restablecer la contraseña. Por favor intente de nuevo más tarde.");
                            }
                        }
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("No se ha podido obtener los datos de acceso del usuario. Por favor intente de nuevo, si el error persiste comuniquese con COOPERAGRO.");
                    }

                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("El usuario no es válido..");
                    generica.setiCodigo(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("Se ha presentado un inconveniete al generar la nueva clave, por favor intente de nuevo más tarde.");
        }

        return generica;
    }

    @Override
    public String validarCodLlave(String llave) {
        String Llave = accesoDataAccessImp.getLlaveSeguridad(llave);
        return Llave;
    }

}
