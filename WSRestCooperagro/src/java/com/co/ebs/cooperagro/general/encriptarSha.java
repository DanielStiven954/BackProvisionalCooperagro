/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan F Silva R
 */
public class encriptarSha {

    public String encriptar(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            Logger.getLogger(encriptarSha.class.getName()).log(Level.SEVERE, null, e);
        }
        return generatedPassword;
    }

    public void encriptarOne(String pass, String llave) {
        encriptarSha xtran = new encriptarSha();
        System.out.println(xtran.encriptar(pass, llave));
    }

//    Generación de la clave del administrador
    public static void main(String[] args) {
        encriptarSha xtran = new encriptarSha();
        System.out.println(xtran.encriptar("passAdmin2020", "8388447293"));
        xtran.encriptarOne("passAdmin2020", "8388447293");

    }
}

    

