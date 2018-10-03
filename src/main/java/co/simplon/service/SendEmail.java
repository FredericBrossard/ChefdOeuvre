package co.simplon.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import co.simplon.model.Report;
import co.simplon.model.ReportLineAppli;

//Dans mon compte gmail et donc google aller dans 
//: "Paramètre "Autoriser les applications moins sécurisées" activé " apres s'etre connecté sur son compte via le lien ci- dessous
//: https://myaccount.google.com/lesssecureapps

public class SendEmail {

	// Mdp à gérer via une variable d'environnement et le fichier properties, pour
	// ainsi deposer sous gitHub tous les elements sauf le fichier properties
	private final String USERNAME = "frederic.brossard.pf1@gmail.com";
	private final String PASSWORD = "Lolita3%";

	// Injection du service pour pouvoir utiliser ses méthodes
	@Inject
	ReportService reportService;

	// Méthode permettant de constituer et envoyer un email
	public Boolean envoyer(Report report, String emailAdresse) {

		Boolean result = false;
		/* Report dateReport = new Report(); */
		/* System.out.println("date du report : " + report.getDate()); */
		// Recuperation de la date systeme et mise au format dd/MM/yyyy
		/*
		 * Date actuelle = new Date(); DateFormat dateFormat = new
		 * SimpleDateFormat("dd/MM/yyyy"); String date = dateFormat.format(actuelle);
		 */

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(report.getDate().getTime());

		System.out.println("===== Date =================");
		System.out.println(date);

		// Etape 1 : Création de la session
		Properties props = new Properties();
		/*
		 * SMTP est un serveur. c a d un service qui écoute sur le port 25 avec comme
		 * principal objectif de router les mails à partir de l'adresse du destinataire
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

		// Illustration de gestion de multi destinataire
		/*
		 * String[] to = {"xx@yahoo.fr","yy@gmail.com"}; InternetAddress[] toAddress =
		 * new InternetAddress[to.length]; for (int i = 0; i < to.length; i++)
		 * toAddress[i] = new InternetAddress(to[i]);
		 */

		try {
			// Etape 2 : Création de l'objet Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("frederic.brossard.pf1@gmail.com"));
			/*
			 * message.setRecipients(Message.RecipientType.TO,
			 * InternetAddress.parse("wavefred@hotmail.com"));
			 */
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAdresse));
			message.setSubject("Suivi du Patrimoine Distrib / Demat");
		
			String titre = "<h3>Liste des Applications : </h3>";
			String line = "<td>";
			String messAppli = "<h3>Voici l'état des Applications : </h3>";

			// Boucle For each pour lire les occurences de lineAppli et extraire le nom des
			// applications
			for (ReportLineAppli lineAppli : report.getLineAppli()) {
				String appliName = lineAppli.getApplication().getName();
				String appliEtat = lineAppli.getEtat().getLabel();
				String appliComment = lineAppli.getComment();
				messAppli = messAppli + "<li>" + appliName + " => Etat : "  + appliEtat + " ( Commentaire : " + appliComment + ")</li>";
			}

		/*	for (ReportLineAppli lineAppli : report.getLineAppli()) {
				
				String appliName = lineAppli.getApplication().getName();
				line = line + "<tr>" + appliName + "</tr>";
				String appliEtat = lineAppli.getEtat().getLabel();
				line  = line + "<tr>" + appliEtat  + "</tr>";
				line = line + "</td>";
			}*/
			
			/*
			 * message.
			 * setText("Bonjour, veuillez trouver l'état de la production Patrimoine Distrib&Démat de la journée du "
			 * + date + ", sur l'application.");
			 */
			// Constitution du message au formlat HTML

			String texteMessage = "	" + "<div style=\"color:red;\"> " + "<p>Bonjour,</p> "
					+ "<p>Veuillez trouver l'état de la production Patrimoine Distrib&Démat de la journée du " + date
					+ " sur votre l'application mobile.</p> " + "<ul>" + messAppli + "</ul>" + "<p>Cordialement,</p>"
			/*				+ "<table>" + line + "</table>" */
					+ "<p>L'Equipe Distrib&Démat.</p>" + "</div>";
			message.setContent(texteMessage, "text/html; charset=utf-8");

			/*
			 * https://www.developpez.net/forums/d983700/java/developpement-web-java/envoyer
			 * -email-piece-jointe/ //Ajout de la première partie du message dans un objet
			 * Multipart MimeMultipart multipart = new MimeMultipart();
			 * multipart.addBodyPart(message);
			 * 
			 * // Partie de la pièce jointe MimeBodyPart messageBodyPart = new
			 * MimeBodyPart(); DataSource source = new FileDataSource("file");
			 * messageBodyPart.setDataHandler(new dataHandler(source));
			 * messageBodyPart.setFileName("name");
			 * 
			 * //Ajout de la partie pièce jointe MimeMultipart multipart = new
			 * MimeMultipart(); multipart.addBodyPart(messageBodyPart);
			 */

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
