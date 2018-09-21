package co.simplon.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

// Dans mon compte gmail et donc google aller dans 
//		: "Paramètre "Autoriser les applications moins sécurisées" activé " apres s'etre connecté sur son compte via le lien ci- dessous
//		: https://myaccount.google.com/lesssecureapps

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private String username = "frederic.brossard.pf1@gmail.com";
	private String password = "Lolita1%";

	public void envoyer() {

		// Recuperation de la date systeme et mise au format dd/MM/yyyy
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(actuelle);
		/*System.out.println("===== Date =================");
		System.out.println(date);*/

		// Etape 1 : Création de la session
		Properties props = new Properties();
		/*
		 * SMTP est un serveur. c a d un service qui écoute sur le port 25 avec comme
		 * principal objectif, de router les mails à partir de l'adresse du destinataire
		 */
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Etape 2 : Création de l'objet Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("frederic.brossard.pf1@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wavefred@hotmail.com"));
			message.setSubject("Suivi du Patrimoine Distrib / Demat");
			// chercher une méthode qui génère

			message.setText("Bonjour, le rapport du Patrimoine Distrib / Demat de ce jour " + date + ", est disponible sur l'application.");
			// Etape 3 : Envoyer le message
			Transport.send(message);
			System.out.println("Message_envoye");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
