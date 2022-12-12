/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.olimpiait.api;

import com.co.ebs.cooperagro.general.utilidad;
import com.co.ebs.cooperagro.olimpiait.modelapi.ConsultaANI;
import com.co.ebs.cooperagro.olimpiait.modelapi.Login;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 *
 * @author Jonathan
 */
public class ApiFirmamos {
     private static String URI_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_OLIMPIA_IT");
     private static String CRED_API = new ParametroServiceBean().obtenerParametroPorNombre("CRED_API_OLIMPIA_IT");
    //private static String URI_API ="https://reconoserpruebas.olimpiait.com:6407/";
    HttpClient client = new DefaultHttpClient();
    
    public String loginAPI() {
        String sToken = "", sIdAplicacion = "", sUsuario = "", sContrasena = "";
        String sURL_Login = URI_API + "/Login";
        
        try {
            HttpPost httpPostLogin = new HttpPost(sURL_Login);

            Login login = new Login();

//            String sEntornoTest = new utilidad().getValueConfigurePropByKey("ENTORNO_TEST");
            String sCredUriApiSplit[] = CRED_API.split(";");
            if (sCredUriApiSplit.length > 0) {             
                sIdAplicacion = sCredUriApiSplit[0];
                sUsuario = sCredUriApiSplit[1];
                sContrasena = sCredUriApiSplit[2];
            }
            
            System.out.print(sIdAplicacion+" "+" "+sUsuario+" "+sContrasena);
            login.setIdAplicacion(sIdAplicacion);
            login.setUsuario(sUsuario);
            login.setContrasena(sContrasena);

            String sRequestLogin = new Gson().toJson(login);
            StringEntity entity = new StringEntity(sRequestLogin);
            httpPostLogin.setEntity(entity);
            httpPostLogin.setHeader("Content-Type", "application/json-patch+json");
            httpPostLogin.setHeader("Accept", "application/json");

            HttpResponse response = client.execute(httpPostLogin);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
               while ((line = rd.readLine()) != null) {
                sToken = sToken.trim() + line.trim();
            }
            if (sToken != null && !sToken.equals("")) {
                sToken = sToken.substring("Bearer ".length()).trim();
                sToken = sToken.replace("\"", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sToken;
    }
    
    public String consultarANI(ConsultaANI consultaANI) {
        String sJSONResponse = "";
        System.out.println("********************URI_API: "+URI_API);
        String sURL_CONSULTA_ANI = URI_API + "/ANI/ConsultaANI";
        try {
            HttpPost httpPostConsultaANI = new HttpPost(sURL_CONSULTA_ANI);
            
            String sJSONConsultaANI = new Gson().toJson(consultaANI);
            
            System.out.println("********************sJSONConsultaANI: "+sJSONConsultaANI);
            System.out.println("********************sTokenAuth: "+ this.loginAPI().toString());
            
            StringEntity entity = new StringEntity(sJSONConsultaANI);
            String sTokenAuth = this.loginAPI();
            httpPostConsultaANI.setEntity(entity);
            httpPostConsultaANI.setHeader("Content-Type", "application/json-patch+json");
            httpPostConsultaANI.setHeader("Accept", "application/json");
            httpPostConsultaANI.setHeader("Authorization", "Bearer " + sTokenAuth);

            HttpResponse response = client.execute(httpPostConsultaANI);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                sJSONResponse = sJSONResponse.trim() + line.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sJSONResponse;
    }

}
