package co.simplon.service;

import java.security.NoSuchProviderException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Session;

import org.apache.logging.log4j.message.Message;

import co.simplon.model.Application;

import co.simplon.model.Report;
import co.simplon.model.ReportLineAppli;
import co.simplon.model.ReportLineScenario;
import co.simplon.model.Scenario;

import co.simplon.repository.ReportLineAppliRepository;
import co.simplon.repository.ReportLineScenarioRepository;
import co.simplon.repository.ReportRepository;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;;

@Named
public class ReportServiceImpl implements ReportService {

	@Inject
	ReportRepository reportRepository;

	@Inject
	ApplicationService applicationService;

	@Inject
	EtatService etatService;

	@Inject
	ReportLineAppliRepository reportLineAppliRepository;

	@Inject
	ReportLineScenarioRepository reportLineScenarioRepository;

	@Inject
	ScenarioService scenarioService;

	@Inject
	StatutService statutService;

	@Override
	public List<Report> findAllReport() {
		return reportRepository.findAllByOrderByDateDesc();
	}

	@Override
	public Report saveReport(Report report) {
		reportRepository.save(report);
		return report;
	}

	@Override
	public Optional<Report> findReportbyId(Long id) {

		return reportRepository.findById(id);
	}

	// Creation d'un rapport du jour
	@Override
	public Long createReport() {

		// Etape 1 : création et save d un report à date du jour
		Report report = new Report();
		// 1ere sauvegarde pour disposer de l'id sur Report pour ensuite pouvoir
		// sauvergarder "reportLineAppli"
		reportRepository.save(report);

		// Etape 2 : Creation d l'objet lineApplication
		Set<ReportLineAppli> listLineAppli = new HashSet<ReportLineAppli>();

		// Etape 3 : Constitution de la liste des applications
		List<Application> listApplication = applicationService.findAllApplication();

		// Boucle For each sur la liste des application pour valorisation du sous objet
		// lineApplication de l'objet Report
		for (Application application : listApplication) {

			// Création de l'objet lineApplication
			ReportLineAppli reportLineAppli = new ReportLineAppli();
			reportLineAppliRepository.save(reportLineAppli);

			reportLineAppli.setReport(report);
			reportLineAppli.setApplication(application);
			reportLineAppli.setComment("commentaire pour " + application.getName());

			reportLineAppli.setEtat(etatService.findByLabel("Ouvert"));

			// je remplace cette ligne qui créé un report line scenario null
			Set<ReportLineScenario> listReportLineScenario = new HashSet<ReportLineScenario>();

			///
			List<Scenario> listScenario = scenarioService.findAllScenarioByApplication(application);
			for (Scenario scenario : listScenario) {

				ReportLineScenario reportLineScenario = new ReportLineScenario();
				// Set<ReportLineScenario> reportLineScenario = new
				// HashSet<ReportLineScenario>();

				reportLineScenario.setReportLineAppli(reportLineAppli);

				reportLineScenario.setScenario(scenario);

				reportLineScenario.setStatut(statutService.findByScenarioAndLabel(scenario, "Ouverture à l heure"));

				reportLineScenarioRepository.save(reportLineScenario);

				listReportLineScenario.add(reportLineScenario);

			}

			///
			reportLineAppli.setListReportLineScenario(listReportLineScenario);

			reportLineAppliRepository.save(reportLineAppli);

			listLineAppli.add(reportLineAppli);

		}

		// Init de l'attribut lineAppli de l'objet report à null
		// report.setLineAppli(new HashSet<ReportLineAppli>());
		report.setLineAppli(listLineAppli);

		// Sauvegarde en base de l objet report à null (en fait avec un Id et Une date)
		reportRepository.save(report);
		return report.getId();
	}
	// Methode d'envoi de mail
	public void sendEmail () {
		
		SendEmail executionSendMail = new SendEmail();
		executionSendMail.envoyer();
		   
	}
}
