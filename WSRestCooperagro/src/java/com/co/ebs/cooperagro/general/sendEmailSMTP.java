/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.general;

import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import com.co.ebs.cooperagro.service.ParametroServiceBean;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ETHOS-DEV02
 */
public class sendEmailSMTP {

    private ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    public Message getMailMessageSession() {

        // Sender's email ID needs to be mentioned
        String host = parametroServiceBean.obtenerParametroPorNombre("HOST_MAIL");
        String puerto = parametroServiceBean.obtenerParametroPorNombre("PUERTO_MAIL");
        String correo = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
        String pass = parametroServiceBean.obtenerParametroPorNombre("PASS_MAIL");
        final String Username = correo;
        final String PassWord = pass;
        System.err.println("Correo: "+correo);
        System.err.println("pass: "+pass);
        System.err.println("puerto: "+puerto);
        System.err.println("host: "+host);
        
        Properties props = new Properties();
        
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", puerto);
        props.put("mail.smtp.auth", "true");   
//        props.put("mail.smtp.ssl.trust", host);
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        });
        return new MimeMessage(session);
    }

    public static void addAttachment(Multipart multipart, String filename) throws MessagingException {
        DataSource source = new FileDataSource(filename);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(source.getName());
        multipart.addBodyPart(messageBodyPart);
    }

    public void AttachMultipleFilesFromFolder(Message message, String folderPath) throws MessagingException, IOException {
        if (!folderPath.equalsIgnoreCase("")) {
            try {
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(getTextFromMessage(message), "text/html; charset=utf-8");
                Multipart multipart = new MimeMultipart();
                // Set text message part
                multipart.addBodyPart(messageBodyPart);
                File filePath = new File(folderPath);
                File[] attachments = filePath.listFiles();
                for (int i = 0; i < attachments.length; i++) {
                    addAttachment(multipart, folderPath + File.separator + attachments[i].getName());
                    message.setContent(multipart);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }

        }
    }

    public void SendEmail(String to, String mensaje, String asunto) throws Exception {

        try {
            String correo = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
            Message message = getMailMessageSession();
            message.setFrom(new InternetAddress(correo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public Boolean SendEmailHTML(String emailDestino, String emailRemitente, String mensaje, String asunto) throws Exception {
        Boolean bRtaSendEmail = Boolean.FALSE;
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            Message message = getMailMessageSession();
            message.setFrom(new InternetAddress(emailRemitente));            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
            message.setSubject(asunto);
            message.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
            message.setContent(mensaje, "text/html;charset=ISO-8859-1");
            Transport.send(message);
            bRtaSendEmail = Boolean.TRUE;
        } catch (MessagingException e) {
            bRtaSendEmail = Boolean.FALSE;
            e.printStackTrace();
        }
        return bRtaSendEmail;
    }

    public Boolean SendEmailHTMLSolCredAdmin(String emailRemitente, String mensaje, String asunto) throws Exception {
        Boolean bRtaSendEmail = Boolean.FALSE;
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            String sEmailNotSolCred = parametroServiceBean.obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
            Message message = getMailMessageSession();
            message.setFrom(new InternetAddress(emailRemitente));
            if (sEmailNotSolCred != null && !sEmailNotSolCred.equals("")) {
                message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sEmailNotSolCred));
                rtaGenerica.setbRta(true);
                rtaGenerica.setsMsj("Los emails de notificacion de solicitud de credito fueron cargados correctamente.");
            }

            message.setSubject(asunto);
            message.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
            message.setContent(mensaje, "text/html;charset=ISO-8859-1");
            Transport.send(message);
            bRtaSendEmail = Boolean.TRUE;
        } catch (MessagingException e) {
            bRtaSendEmail = Boolean.FALSE;
            e.printStackTrace();
        }
        return bRtaSendEmail;
    }

    public Boolean SendEmailHTMLWitchAttachment(String emailDestino, String emailRemitente, String mensaje, String asunto, String attachment) throws Exception {
        Boolean bRtaSendEmail = Boolean.FALSE;
        respuestaGenerica rtaGenerica = new respuestaGenerica();
        try {
            Message message = getMailMessageSession();
            message.setFrom(new InternetAddress(emailRemitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));

            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mensaje, "text/html");

            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds attachments
            MimeBodyPart attachPart = new MimeBodyPart();

            try {
                attachPart.attachFile(attachment);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            multipart.addBodyPart(attachPart);

            message.setSubject(asunto);
            message.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
            message.setContent(multipart); //7
            Transport.send(message);

            /*Multipart multipart = new MimeMultipart();

            DataSource source = new FileDataSource(attachment);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);

            message.setSubject(asunto);
            message.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
            Object body[] = {mensaje, multipart};
            message.setContent(body, "text/html;charset=ISO-8859-1");
            Transport.send(message);*/
            bRtaSendEmail = Boolean.TRUE;
        } catch (MessagingException e) {
            bRtaSendEmail = Boolean.FALSE;
            e.printStackTrace();
        }
        return bRtaSendEmail;
    }

    public void Send(String desde, String sDirMail, String sMensaje, String sAsunto) {

        try {

            this.enviarCorreo(desde, sDirMail, sAsunto, sMensaje);
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionManager.ManageException(e);
        }
    }

    private static MimeMessage getMessage(Session session, String from, String to, String sMensaje, String sAsunto) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setText(sMensaje);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from, "Proceso elecciones"));
            msg.setSubject(sAsunto);

            return msg;
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void enviarCorreo(String desde, String para, String asunto, String mensaje) {

        try {
            Message message = new MimeMessage(getSession());

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.addFrom(new InternetAddress[]{new InternetAddress(desde)});

            message.setSubject(asunto);
            message.setContent(mensaje, "text/plain");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Session getSession() {
        Authenticator authenticator = new Authenticator();

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
        properties.setProperty("mail.smtp.auth", "true");

        /*properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");*/
        properties.setProperty("mail.smtp.host", "smtpout.secureserver.net");
        properties.setProperty("mail.smtp.port", "25");

        return Session.getInstance(properties, authenticator);
    }

    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + html;
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    private static class ArrayOfEmailNotSolCredDTO {

//        @XmlElement(name = "EmailNotSolCredDTO", nillable = true)
//        protected List<EmailNotSolCredDTO> emailNotSolCredDTO;
        /**
         * Gets the value of the tipoIdentificacionDTO property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the tipoIdentificacionDTO property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTipoIdentificacionDTO().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
     * {@link TipoIdentificacionDTO }
         *
         *
         */
//        public List<EmailNotSolCredDTO> getEmailNotSolCredDTO() {
//            if (emailNotSolCredDTO == null) {
//                emailNotSolCredDTO = new ArrayList<EmailNotSolCredDTO>();
//            }
//            return this.emailNotSolCredDTO;
//        }
    }

    private static class EmailNotSolCredDTO {

        @XmlElement(name = "SDescripcion")
        protected String sDescripcion;

        public String getsDescripcion() {
            return sDescripcion;
        }

        public void setsDescripcion(String sDescripcion) {
            this.sDescripcion = sDescripcion;
        }

    }

    private class Authenticator extends javax.mail.Authenticator {

        private PasswordAuthentication authentication;

        public Authenticator() {

            /*String username = "eleccionethos@gmail.com";
      String password = "ethosweb";*/
 /*String username = "mmejia@ethosweb.com";
      String password = "mm3j14";*/
            String username = "soporte@ethosweb.com";
            String password = "50p0rt32013*";
            authentication = new PasswordAuthentication(username, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

    class SMTPAuthentication extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {

            String username = "eleccionethos@gmail.com";
            String password = "ethosweb";
            return new PasswordAuthentication(username, password);
        }
    }

    static class ExceptionManager {

        public static void ManageException(Exception e) {
            System.out.println("Se ha producido una exception");
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    public boolean enviarEmailV2(String nomAsociado, String fecha, String emailDestino, String pAsunto, String pMensaje) {
        boolean rta = false;
        Properties properties = new Properties();
        String correoEnvia = "cooperagro@ebscreditodigital.com";
        String contrasena = "0Oyta7N$";
        properties.put("mail.smtp.host", "smtp.hostinger.co");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.user", correoEnvia);
        properties.put("mail.password", contrasena);

        Session session = Session.getDefaultInstance(properties, null);
        try {
            // Crear el cuerpo del mensaje
            MimeMessage mimeMessage = new MimeMessage(session);

            // Agregar quien env�a el correo
            mimeMessage.setFrom(new InternetAddress(correoEnvia, "COOPERAGRO"));

            // Los destinatarios
            InternetAddress[] internetAddresses = {new InternetAddress(emailDestino)};

            // Agregar los destinatarios al mensaje
            mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses);
            mimeMessage.addRecipients(Message.RecipientType.BCC, new InternetAddress[]{new InternetAddress("cooperagro@ebscreditodigital.com")});
            // Agregar el asunto al correo
            mimeMessage.setSubject(pAsunto);

            // Creo la parte del mensaje
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            mimeBodyPart.setText(cuerpoHTML(nomAsociado, pMensaje, fecha), "utf-8", "html");
            mimeBodyPart.setText(pMensaje, "utf-8", "html");
            // Crear el multipart para agregar la parte del mensaje anterior
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            mimeBodyPart = new MimeBodyPart();

//            File miDir = new File("./src/java/com/co/ebs/financiar/general/piePagina.png");
//            File miDir = new File(getClass().getResource("piePagina.png").toURI());
//            try {
//                DataSource fds = new FileDataSource(miDir.getCanonicalPath());
//                mimeBodyPart.setDataHandler(new DataHandler(fds));
//                mimeBodyPart.setHeader("Content-ID", "<image>");
//                multipart.addBodyPart(mimeBodyPart);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
            // Agregar el multipart al cuerpo del mensaje
            mimeMessage.setContent(multipart);

            // Enviar el mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect(correoEnvia, contrasena);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            rta = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rta;
    }

    public String cuerpoHTML(String nomUsuario, String mensaje, String fecha) {
        String rta = "<body style=\"margin: 0em;\">\n"
                + "    <header style=\"height: 60px; background-color: #3d6e3c;\"></header>\n"
                + "                 \n"
                + "    <h2 style=\"text-align: center;margin-top: 2%; font-style: normal;\n"
                + "                font-size: 40px;\n"
                + "                line-height: 60px;\">\n"
                + "        <small>Bogotá - </small>\n"
                + "        <small>" + fecha + "</small>\n"
                + "    </h2>\n"
                + "                 \n"
                + "     <h2 style=\"font-weight: 500;\n"
                + "     font-size: 60px;\n"
                + "     line-height: 90px;\n"
                + "     text-align: center;\n"
                + "     color: #3d6e3c;\">Apreciad@   " + nomUsuario + "</h2>\n"
                + "    \n"
                + "    <h2 style=\"text-align: center;margin-top: 2%; font-style: normal;\n"
                + "                font-size: 40px;\n"
                + "                line-height: 60px;\">\n"
                + "        " + mensaje + "\n"
                + "    </h2>\n"
                + "    <br><br><br><br><br><br><br><br><br><br><br><br>\n"
                + "    \n"
                + "    <header style=\"height: 60px; background-color: #3d6e3c;\"></header>\n"
                + "\n"
                + "</body>  ";

        return rta;
    }

    public static void main(String[] args) {
        sendEmailSMTP enviar = new sendEmailSMTP();
        try {
            enviar.SendEmailHTML("juan.forero@ebssas.com", "extracto@coperagro.coop", "Hola", "Hola");
        }
        catch (Exception e){
            System.out.println("com.co.ebs.cooperagro.general.sendEmailSMTP.main()"+e.getMessage());
        }
        }    
            

}
