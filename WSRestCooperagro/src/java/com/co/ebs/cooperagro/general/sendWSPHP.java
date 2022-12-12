/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import com.co.ebs.cooperagro.respuestasGenericas.ResponsePHPGeneraDocsPDF;
import com.co.ebs.cooperagro.respuestasGenericas.ResponsePHPSendEmail;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Brayan F Silva R
 */
public class sendWSPHP {

    public ResponsePHPSendEmail enviarEmailRadicado(HashMap<String, String> hashMapData) {
        ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
        String sEmailNotSolCred = new ParametroServiceBean().obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/CorreoSomec.php/mail.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/CorreoSomec.php/index.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("Respuesta", "RADICADA");
            params.put("Correo", new utilidad().encodeBase64(hashMapData.get("sMailDestino")));
            params.put("CodigoRadicado", hashMapData.get("sNumRadicSolCred"));
            params.put("Linea", hashMapData.get("sLineaCredito"));
            params.put("Monto", hashMapData.get("sMontoCredito"));
            params.put("Periodicidad", hashMapData.get("sDescPeriodicidad"));
            params.put("plazo", hashMapData.get("sPlazo"));
            params.put("Cuota", hashMapData.get("sValorCuota"));
            params.put("Deudor", hashMapData.get("sNombreDeudor"));
            params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPSendEmail = new ResponsePHPSendEmail();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPSendEmail = new Gson().fromJson(rtaJSON, ResponsePHPSendEmail.class);
                return responsePHPSendEmail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPSendEmail;
    }

    public ResponsePHPSendEmail enviarEmail(String sRespuesta, String correo, String sCodRadicado, String token) {
        ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
        String sEmailNotSolCred = new ParametroServiceBean().obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/CorreoSomec.php/mail.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/CorreoSomec.php/index.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();
            if (sRespuesta.equals("3")) {
                params.put("Respuesta", "APROBADO");
            } else if (sRespuesta.equals("4")) {
                params.put("Respuesta", "APLAZADO");
                params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            } else if (sRespuesta.equals("5")) {
                params.put("Respuesta", "NEGADO");
                params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            } else if (sRespuesta.equals("7")) {
                params.put("Respuesta", "ESTUDIO");
                params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            } else if (sRespuesta.equals("8")) {
                params.put("Respuesta", "DESEMBOLSO");
                params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            }
            params.put("Correo", new utilidad().encodeBase64(correo));
            params.put("CodigoRadicado", sCodRadicado);
            params.put("Token", new utilidad().encodeBase64(token));
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPSendEmail = new ResponsePHPSendEmail();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPSendEmail = new Gson().fromJson(rtaJSON, ResponsePHPSendEmail.class);
                return responsePHPSendEmail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPSendEmail;
    }

    public ResponsePHPSendEmail enviarEmailAceptadaAprobada(String correo, String sCodRadicado) {
        ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
        String sEmailNotSolCred = new ParametroServiceBean().obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/CorreoSomec.php/mail.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/CorreoSomec.php/index.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("Respuesta", "ACEPTADA");
            params.put("Correo", new utilidad().encodeBase64(correo));
            params.put("CodigoRadicado", sCodRadicado);
            params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPSendEmail = new ResponsePHPSendEmail();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPSendEmail = new Gson().fromJson(rtaJSON, ResponsePHPSendEmail.class);
                return responsePHPSendEmail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPSendEmail;
    }

    public ResponsePHPSendEmail enviarEmailNewToken(String correo, String sCodRadicado, String token) {
        ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
        String sEmailNotSolCred = new ParametroServiceBean().obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/CorreoSomec.php/mail.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/CorreoSomec.php/index.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("Correo", new utilidad().encodeBase64(correo));
            params.put("CodigoRadicado", sCodRadicado);
            params.put("Token", new utilidad().encodeBase64(token));
            params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPSendEmail = new ResponsePHPSendEmail();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPSendEmail = new Gson().fromJson(rtaJSON, ResponsePHPSendEmail.class);
                return responsePHPSendEmail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPSendEmail;
    }

    public ResponsePHPSendEmail enviarEmailCambioClave(HashMap<String, String> hashMapData) {
        ResponsePHPSendEmail responsePHPSendEmail = new ResponsePHPSendEmail();
        String sEmailNotSolCred = new ParametroServiceBean().obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/CorreoSomec.php/mail.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/CorreoSomec.php/index.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("Correo", new utilidad().encodeBase64(hashMapData.get("sEmail")));
            params.put("CorreoCopia", new utilidad().encodeBase64(sEmailNotSolCred));
            params.put("nombres", hashMapData.get("sNombres"));
            params.put("apellidos", hashMapData.get("sApellidos"));
            params.put("clave", new utilidad().encodeBase64(hashMapData.get("sClave")));
            params.put("Cedula", hashMapData.get("sNumDOI"));
            params.put("TipoDoc", hashMapData.get("sDescTipoDOI"));

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPSendEmail = new ResponsePHPSendEmail();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPSendEmail = new Gson().fromJson(rtaJSON, ResponsePHPSendEmail.class);
                return responsePHPSendEmail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPSendEmail;
    }

    public ResponsePHPGeneraDocsPDF creaDocumento(Long codigoRadicado, String data, Integer tipoSolicitud) {
        ResponsePHPGeneraDocsPDF responsePHPGeneraDocsPDF = new ResponsePHPGeneraDocsPDF();
        String rtaJSON = "";
        try {
            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            URL url = null;
            if (sEntornoTest.equals("1")) {
                url = new URL("https://apps.ebscreditodigital.com/FTP_WLOSOMEC/WsCreaDocumento.php");
            } else {
                url = new URL("https://new.ethossoluciones.com/FTP_WLOSOMEC/WsCreaDocumento.php");
            }
            Map<String, Object> params = new LinkedHashMap<>();

            params.put("codigoRadicado", codigoRadicado.toString());
            params.put("data", new utilidad().encodeBase64(data));
            params.put("tipoSolicitud", tipoSolicitud.toString());
            params.put("entorno", sEntornoTest);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaJSON = rtaJSON.trim() + line.trim();
            }
//            System.out.println(rtaJSON);
            responsePHPGeneraDocsPDF = new ResponsePHPGeneraDocsPDF();
            if (rtaJSON != null && !rtaJSON.equals("")) {
                responsePHPGeneraDocsPDF = new Gson().fromJson(rtaJSON, ResponsePHPGeneraDocsPDF.class);
                return responsePHPGeneraDocsPDF;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsePHPGeneraDocsPDF;
    }

}
