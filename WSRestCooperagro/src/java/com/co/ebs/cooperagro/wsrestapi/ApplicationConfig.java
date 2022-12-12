package com.co.ebs.cooperagro.wsrestapi;

import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Brian Cardenas
 */
@ApplicationPath("WSRestAPICooperagro")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.co.ebs.cooperagro.security.RestSecurityFilter.class);
        resources.add(com.co.ebs.cooperagro.security.WSRestCooperagroCrossOrigin.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSEstadoCuenta.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSInformacionUsuario.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestAcceso.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestAdminCore.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestAuth.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestCargaDatos.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestCygnusCore.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestDashBoard.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestFotoPerfil.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestGeneracionDocumento.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestNotificacion.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestOlvidoClave.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestPQRSF.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestParametros.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestPreguntaUsuario.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestPreguntasRegUser.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestSeguridad.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestSolAfiWeb.class);
        resources.add(com.co.ebs.cooperagro.wsrestapi.WSRestSolicitudCredito.class);
    }

}
