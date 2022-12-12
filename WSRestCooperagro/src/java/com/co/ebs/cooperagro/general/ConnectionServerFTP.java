/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.io.IOException;
import org.apache.commons.net.ftp.*;

/**
 *
 * @author YO
 */
public class ConnectionServerFTP {

    private final static ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final static String servidor = parametroServiceBean.obtenerParametroPorNombre("SERVIDOR_FTP_EXTRACTOS");
    private final static String usuario = parametroServiceBean.obtenerParametroPorNombre("USUARIO_FTP_EXTRACTOS");
    private final static int puerto = Integer.parseInt(parametroServiceBean.obtenerParametroPorNombre("PUERTO_FTP_EXTRACTOS"));
    private final static String clave = parametroServiceBean.obtenerParametroPorNombre("CLAVE_FTP_EXTRACTOS");

    private static FTPClient clienteFTP = null;

    public static void conectar() {

        try {
            clienteFTP.connect(servidor, puerto);
            if (clienteFTP.login(usuario, clave)) {

                clienteFTP.enterLocalPassiveMode();
                clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);

            } else {
                throw new FTPConnectionClosedException("Usuario o clave incorrectos " + usuario + " " + clave + " " + servidor + " " + puerto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean desconectar() {
        try {
            if (clienteFTP.isAvailable()) {
                clienteFTP.logout();
                clienteFTP.disconnect();

            }
            clienteFTP = null;

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static FTPClient getConnection() {
        try {
            if (clienteFTP == null) {
                clienteFTP = new FTPClient();
                conectar();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return clienteFTP;
    }

}
