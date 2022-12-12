/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Brayan F Silva R
 */
public class sendSMS {

    public Boolean envioSMS_Sencillo(String sIndicativo, String sNumCel, String sTxtMsj) {
        Boolean bRtaEnvioSMS = Boolean.FALSE;
        String rtaEvioSMS = "";
        try {
            URL url = new URL("https://api103.hablame.co/sms/envio/");
            Map<String, Object> params = new LinkedHashMap<>();

            params.put("cliente",   "10013292");
            params.put("api", "fceNDmNiH8Onw8DjmTN6uCzd1Afazu");
            params.put("numero", sIndicativo + sNumCel);
            params.put("sms", sTxtMsj);
            params.put("fecha", "");
            params.put("referencia", "EBS");

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
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaEvioSMS = rtaEvioSMS.trim() + line.trim();
            }
            System.out.println(rtaEvioSMS);
            ResponseSendSMS responseSendSMS = new ResponseSendSMS();
            if (rtaEvioSMS != null && !rtaEvioSMS.equals("")) {
                responseSendSMS = new Gson().fromJson(rtaEvioSMS, ResponseSendSMS.class);
                if (responseSendSMS != null && responseSendSMS.getResultado() == 0) {
                    bRtaEnvioSMS = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bRtaEnvioSMS;
    }

    public Boolean envioSMS_Masivo(String[] Numeros, String sTxtMsj) {
        Boolean bRtaEnvioSMS = Boolean.FALSE;
        String rtaEvioSMS = "";
        try {
            URL url = new URL("https://api.hablame.co/sms/envio/");
            Map<String, Object> params = new LinkedHashMap<>();
            String sNumCel = Numeros[0];
            for (int i = 1; i < Numeros.length; i++) {
                sNumCel = sNumCel + "," + Numeros[i];
            }
            params.put("cliente", "10013292");
            params.put("api", "fceNDmNiH8Onw8DjmTN6uCzd1Afazu");
            params.put("numero", sNumCel);
            params.put("sms", sTxtMsj);
            params.put("fecha", "");
            params.put("referencia", "EBS");

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
                rtaEvioSMS = rtaEvioSMS.trim() + line.trim();
            }
            System.out.println(rtaEvioSMS);
            ResponseSendSMS responseSendSMS = new ResponseSendSMS();
            if (rtaEvioSMS != null && !rtaEvioSMS.equals("")) {
                responseSendSMS = new Gson().fromJson(rtaEvioSMS, ResponseSendSMS.class);
                if (responseSendSMS != null && responseSendSMS.getResultado() == 0) {
                    bRtaEnvioSMS = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bRtaEnvioSMS;
    }

    public static void main(String[] args) {
        
    }
}
