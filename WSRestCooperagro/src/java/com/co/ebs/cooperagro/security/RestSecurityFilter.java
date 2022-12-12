package com.co.ebs.cooperagro.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.io.IOException;
import java.security.Key;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Brian Cardenas
 */
@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class RestSecurityFilter implements ContainerRequestFilter {

    public static final Key KEY = MacProvider.generateKey(SignatureAlgorithm.HS512);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Recupera la cabecera HTTP Authorization de la petición
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        try {
            String token = "";
            // Extrae el token de la cabecera
            if (authorizationHeader != null && !authorizationHeader.equals("")) {
                token = authorizationHeader.substring("Bearer".length()).trim();
                // Valida el token utilizando la cadena secreta
                if (token != null && !token.equals("")) {
                    Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
                } else {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            } else {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

}
