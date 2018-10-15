package co.simplon.service;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import co.simplon.model.Form;

//Dans mon compte gmail et donc google aller dans 
//: "Paramètre "Autoriser les applications moins sécurisées" activé " apres s'etre connecté sur son compte via le lien ci- dessous
//: https://myaccount.google.com/lesssecureapps

@Named
public class SendFormServiceImpl implements SendFormService {

	private final String USERNAME = "frederic.brossard.pf1@gmail.com";
	private final String PASSWORD = "Lolita3%";


/*	public Boolean envoyer(Form form, String emailAdresse) {*/
		public Boolean envoyer(Form form) {

		Boolean result = false;
		String emailAdresse = "wavefred@hotmail.com";

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
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {
			// Etape 2 : Création de l'objet Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("frederic.brossard.pf1@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAdresse));
			message.setSubject(form.getObjet());

			/*
			 * message.
			 * setText("Bonjour, veuillez trouver l'état de la production Patrimoine Distrib&Démat de la journée du "
			 * + date + ", sur l'application.");
			 */
			// Constitution du message au formlat HTML
			String texteMessage = "	" + "<div style=\"color:green;\">" + "<p>L'email de l'expéditeur du message est : " + form.getEmail() + "</p> "
					+ "<p>La demande de l'expéditeur est : " + form.getMessage() + "</p> " + "</div>";
			message.setContent(texteMessage, "text/html; charset=utf-8");

			// Etape 3 : Envoyer le message
			Transport.send(message);
			System.out.println("Message_envoye");
			result = true;
		} catch (MessagingException e) {
			System.err.println("Erreur");
			e.printStackTrace();

			// throw remonte la gestion de l'erreur à l'etage au dessus. Dc ici ds le
			// controleur. On ne fait pas chuter le controler !!!!
			/* throw new RuntimeException(e); */
		}
		return result;
	}

}
