package co.simplon.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.Form;
import co.simplon.model.MailInfoDest;
import co.simplon.model.Report;
import co.simplon.service.ReportService;
import co.simplon.service.SendFormService;

@Controller
@RequestMapping("/suivireport")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ReportController {

	@Inject
	ReportService reportService;

	@Inject
	SendFormService sendFormService;

	
/*	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Report saveReport(@RequestBody Report report) {

		reportService.saveReport(report);
		System.out.println("Méthode save du controller 'ReportController' de nouvel ID (euh, à verifier...) =" + report.getId());
		System.out.println("report = " + report);
		return report;

	}*/
	
/*	var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/suivireport/");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({id:8, date:"2018-09-17T15:15:31.033+0000"    
    }));
    
    xmlhttp.response
    */

/*	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long saveReport(@RequestBody Report report) {

		Report result = reportService.saveReport(report);
		System.out.println("Méthode save du controller 'ReportController' de nouvel ID (euh, à verifier...) =" + result.getId());
		System.out.println("report = " + result);
		return result.getId();

	}
	*/
	
/*	@RequestMapping(value= "/sendmail", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void sendOneEmail() {
		System.out.println("Méthode sendOneEmail du controller 'ReportLineScenarionController' ");
		reportService.sendEmail();

	}*/
	
/*	@RequestMapping(value= "/sendmail", method = RequestMethod.GET)
	public ResponseEntity<Boolean> sendOneEmail() {
		System.out.println("Méthode sendOneEmail du controller 'ReportLineScenarionController' ");
		Boolean mailSendStatus = reportService.sendEmail();
		return new ResponseEntity<Boolean>(mailSendStatus, mailSendStatus? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR );

	}*/
	
	
	@RequestMapping(value= "/sendmail", method = RequestMethod.POST)
/*	public ResponseEntity<Boolean> sendOneEmail(@RequestBody Long id, String emailAdresse ) {*/
		public ResponseEntity<Boolean> sendOneEmail(@RequestBody MailInfoDest mailInfoDest ) {
		
		/*mailInfoDest.setEmailAdresseDesti("wavefred@hotmail.com");*/
		System.out.println("mailInfoDest : " + mailInfoDest);
		System.out.println("Méthode sendOneEmail du controller 'ReportLineScenarionController, id: " + mailInfoDest.getId());
		
		Boolean mailSendStatus = false;
		System.out.println("avant");
		Optional<Report> reportConsult = this.reportService.findReportbyId(mailInfoDest.getId());
		System.out.println("apres, le Boolean reportConsult.isPresent() vaut : " + reportConsult.isPresent());
		 if (reportConsult.isPresent() ) {
			 
			 mailSendStatus = reportService.sendEmail(reportConsult.get(), mailInfoDest.getEmailAdresseDesti());
			 return new ResponseEntity<Boolean>(mailSendStatus, mailSendStatus? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 else {
			 System.out.println("else du if reportConsult.isPresent");
			 return new ResponseEntity<Boolean>(mailSendStatus, HttpStatus.NOT_FOUND);
		 }
	
	}
	
	@RequestMapping(value= "/sendform", method = RequestMethod.POST)
			public Boolean sendOneForm(@RequestBody Form form) {
			
			/*mailInfoDest.setEmailAdresseDesti("wavefred@hotmail.com");*/
			System.out.println("form: " + form);
			System.out.println("Méthode sendOneForm du controller:" + form.getMessage());
			
	/*		Boolean formSendStatus = false;*/
			System.out.println("avant");
			Boolean formSendStatus = false;
			formSendStatus = sendFormService.envoyer(form);
			System.out.println("formSendStatus : " + formSendStatus);
			return formSendStatus;
		/*	return sendFormService.envoyer(form);*/
			
			/*Optional<Form> reportConsult = this.sendFormService.envoyer(form);
			System.out.println("apres, le Boolean reportConsult.isPresent() vaut : " + reportConsult.isPresent());
			 if (reportConsult.isPresent() ) {
				 
				 formSendStatus = reportService.sendEmail(reportConsult.get(), formSendStatus.getEmailAdresseDesti());
				 return new ResponseEntity<Boolean>(formSendStatus, formSendStatus? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
			 }
			 else {
				 System.out.println("else du if reportConsult.isPresent");
				 return new ResponseEntity<Boolean>(formSendStatus, HttpStatus.NOT_FOUND);
			 }*/
		
		}
	
	@RequestMapping(value= "/create", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long createReport() {

		return reportService.createReport();

	}

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Report> findAll() {
		System.out.println("Méthode findAll du controller 'ReportLineScenarionController' ");
		return reportService.findAllReport();
	

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Report findById(@PathVariable(value = "id") Long id) {
		System.out.println("Methode findById de ReportController sur id = " + id);
		Optional<Report> reportOpt = reportService.findReportbyId(id);
	/*	Optional<Report> reportOpt = reportService.findReportByIdByApplicationAsc(id);*/
		Report result;
		if (reportOpt.isPresent()) {
			result = reportOpt.get();
		} else {
			result = null;
		}

		
		return result;
	}

	/*@RequestMapping(value = "/{id}", method = RequestMethod.PUT)*/
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	/*public Report update(@PathVariable(value = "id") Long id, @RequestBody Report report) {*/
		public Report update(@RequestBody Report report) {
		System.out.println("Methode update de ReportController sur id = " + report.getId());
		System.out.println("report = " + report);
		System.out.println("report = " + report.getLineAppli());
		report.setLineAppli(report.getLineAppli());
		Report result = reportService.saveReport(report);
		return result;
		
	}

}
