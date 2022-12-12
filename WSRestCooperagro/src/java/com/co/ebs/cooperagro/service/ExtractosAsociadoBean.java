package com.co.ebs.cooperagro.service;

import org.apache.commons.net.MalformedServerReplyException;
import com.co.ebs.cooperagro.domain.Persona;
import com.co.ebs.cooperagro.general.ConnectionServerFTP;
import com.co.ebs.cooperagro.general.crearEmailHTML;
import com.co.ebs.cooperagro.general.sendInformacion;
import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.request.RequestConsultaPersona;
import com.co.ebs.cooperagro.request.RequestGenerarDocPersona;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseListaCadena;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author YO
 */
public class ExtractosAsociadoBean {

    private FTPClient client = null;

    public respuestaGenerica obtenerExtractoAsociado(RequestGenerarDocPersona request) {

        respuestaGenerica rta = new respuestaGenerica();
        File downloadFile1 = null;
        String encodedString = "";
        Boolean successC = false;

        Persona personaWeb;
        personaWeb = new PersonaServiceBean().personaWebFindByCIdentificacion(Integer.parseInt(request.getITipo()), request.getCIdentificacion());

        if (personaWeb != null && personaWeb.getICodigo() != null) {
            try {
                client = ConnectionServerFTP.getConnection();
                successC = client.changeWorkingDirectory(request.getSAnio());
                if (successC) {
                    FTPFileFilter filter = new FTPFileFilter() {

                        @Override
                        public boolean accept(FTPFile ftpFile) {
                            return ftpFile.getName().contains("_" + personaWeb.getICodigo() + ".pdf");
                        }
                    };

                    String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
                    //FTPFile[] result = client.listFiles("Extractos " + request.getSMes(), filter); // pruebas
                    FTPFile[] result = client.listFiles(request.getSMes(), filter); //Produccion

                    if (result.length > 0 && result != null) {
                        if (result[0].getName() != null && result[0].getName() != "") {
                            client.setStrictReplyParsing(false);
                            downloadFile1 = new File("D:/cooperagro/Extractos/" + result[0].getName());
                            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                            //boolean success = client.retrieveFile("Extractos " + request.getSMes() + "/" + result[0].getName(), outputStream1); //Pruebas
                            boolean success = client.retrieveFile(request.getSMes() + "/" + result[0].getName(), outputStream1); //Produccion
                            outputStream1.close();

                            if (success) {

                                byte[] input_file = Files.readAllBytes(Paths.get("D:\\Cooperagro\\Extractos\\" + result[0].getName()));
                                byte[] encodedBytes = Base64.getEncoder().encode(input_file);
                                encodedString = new String(encodedBytes);

                                rta.setbRta(true);
                                rta.setsMsj(encodedString);
                                rta.setiCodigo(1);

                            } else {
                                rta.setbRta(Boolean.FALSE);
                                rta.setiCodigo(0);
                                rta.setsMsj("No se ha podido procesar la solicitud del extracto. Por favor intente de nuevo más tarde.");
                            }
                        } else {
                            rta.setbRta(false);
                            rta.setsMsj("No se encontraron registros con el N° de documento: " + personaWeb.getCIdentificacion());
                            rta.setiCodigo(0);
                        }
                    } else {
                        rta.setbRta(false);
                        rta.setsMsj("No se encontraron registros con el N° de documento: " + personaWeb.getCIdentificacion());
                        rta.setiCodigo(0);
                    }
                } else {
                    rta.setbRta(false);
                    rta.setsMsj("No se encontro registro del extracto con el año " + request.getSAnio());
                    rta.setiCodigo(0);
                }

            } catch (IOException e) {
                e.printStackTrace();
                rta.setbRta(false);
                rta.setsMsj("No se encontro registro del extracto del año: " + request.getSAnio() + " y del mes " + request.getSMes());
                rta.setiCodigo(0);
            }
                finally {
                ConnectionServerFTP.desconectar();
            }
        }
        return rta;
    }

    public ResponseListaCadena obtenerMesesExtractos() {

        ResponseListaCadena listaCadena = new ResponseListaCadena();

        String[] meses = new ParametroServiceBean().obtenerParametroPorNombre("MESES_EXTRACTOS").split(",");
        if (meses.length > 0) {
            List<String> listMeses = new ArrayList<>();
            for (String mes : meses) {
                listMeses.add(mes);
            }
            listaCadena.setbRta(Boolean.TRUE);
            listaCadena.setLista(listMeses);
        } else {
            listaCadena.setbRta(Boolean.FALSE);
        }

        return listaCadena;
    }

}
