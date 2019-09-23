package com.everis.examenuno.ejerciciotres;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class ServicioEmail implements IServicioEmail{
	
	private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "academiaeveris@gmail.com";
    private static final String PASSWORD = "tecguru$";
    private static final String EMAIL_FROM = "academiaeveris@gmail.com";
	
	public void enviarCorreo(String email, String asunto, String texto) {
		if(validaEmail(email)) {
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
	        Session session = Session.getInstance(prop, null);
	        Message msg = new MimeMessage(session);
	        try {
	            msg.setFrom(new InternetAddress(EMAIL_FROM));
	            msg.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(email, false));
	            msg.setSubject(asunto); 
	            msg.setText(texto);
	            msg.setSentDate(new Date());
	            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
	            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
	            t.sendMessage(msg, msg.getAllRecipients());
	            System.out.println("Respuesta: " + t.getLastServerResponse());
	            t.close();
	        } catch (MessagingException e) {
	            System.err.println(e.getMessage());
	        }
		}else {
			System.out.println("correo invalido");
		}
	}
	public void enviarCorreoHTML(String email, String asunto, String html) {
		if(validaEmail(email)) {
			if(validaEmail(email)) {
				Properties prop = System.getProperties();
				prop.put("mail.smtp.host", "true");
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.auth", "true");
		        Session session = Session.getInstance(prop, null);
		        Message msg = new MimeMessage(session);
		        try {
		            msg.setFrom(new InternetAddress(EMAIL_FROM));
		            msg.setRecipients(Message.RecipientType.TO,
		                    InternetAddress.parse(email, false));
		            msg.setSubject(asunto); 
		            msg.setDataHandler(new DataHandler(new HTMLDataSource(html)));
		            msg.setSentDate(new Date());
		            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
		            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
		            t.sendMessage(msg, msg.getAllRecipients());
		            System.out.println("Respuesta: " + t.getLastServerResponse());
		            t.close();
		        } catch (MessagingException e) {
		            System.err.println(e.getMessage());
		        }
			}else {
				System.out.println("correo invalido");
			}
		}else {
			System.out.println("correo invalido");
		}
	}
	
	public static boolean validaEmail(String email) {
	    String expresion = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    return email.matches(expresion);
	}
	
	static class HTMLDataSource implements DataSource {

        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("html message is null!");
            return new ByteArrayInputStream(html.getBytes());
        }

        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        public String getContentType() {
            return "text/html";
        }

        public String getName() {
            return "HTMLDataSource";
        }
    }
}
