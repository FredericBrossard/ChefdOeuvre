package co.simplon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.ReportLineScenario;
import co.simplon.service.ReportLineScenarioServiceImpl;

@Controller
@RequestMapping("/suiviraportscenario")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ReportLineScenarioController {

	@Inject
	ReportLineScenarioServiceImpl reportLineScenarioService;
	
/*	@Inject
	LineServiceImpl lineServiceImpl;*/

	/*
	 * CODE JavaScript à lancer depuis la console HTML
	    
	    var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "/suiviraportscenario/");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({date:"01-01-2018",name:"Netcredit", statut:"Ouvert", comment:"essai"  
        }));

    	xmlhttp.response
	  
	 	    
	  var xmlhttp = new XMLHttpRequest(); 
	  xmlhttp.open("POST", "/suiviraportscenario");
	  xmlhttp.setRequestHeader("Content-Type", "application/json");
	  xmlhttp.send(JSON.stringify({
	  "line_report": {"id":1, "application":{"id":1, "name":'Page Accueil'}, "etat":{"id":1, "label":'Ouvert'}, "report"::{"id":1, "date":'2018-09-10T11:44:44.797'} } , 
	  }));
	  
	  xmlhttp.response
	  
	  var xmlhttp = new XMLHttpRequest(); 
	  xmlhttp.open("POST", "/suiviraportscenario");
	  xmlhttp.setRequestHeader("Content-Type", "application/json");
	  xmlhttp.send(JSON.stringify({
	  "report_line_appli": {"id":1, "application":{"id":1, "name":'Page Accueil'}, "etat":{"id":1, "label":'Ouvert'}, "report"::{"id":1, "date":'2018-09-10T11:44:44.797'} } , 
	  "scenario":{"id":1, "name":'Page Accueil'}, 
	  "statut": {"id":1, "label":'Ouverture à l heure'}
	  }));
	  
	  xmlhttp.response
	  
	 */

	/*@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveReportLine(@RequestBody LineReport lineReport) {

		lineServiceImpl.saveReportLine(lineReport);
		System.out.println("1ere Méthode POST saveReportLine du controller 'ReportLineScenarionController' ");

	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<LineReport> findAll() {
		System.out.println("Méthode findAll du controller 'ReportLineScenarionController' ");
		List<LineReport> list = lineServiceImpl.findAllReport();
		return list;

	}	*/
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveReport(@RequestBody ReportLineScenario reportScenario) {

		reportLineScenarioService.saveReportScenario(reportScenario);
		System.out.println("Méthode saveReport du controller 'ReportLineScenarionController' ");

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ReportLineScenario> findAll() {
		System.out.println("Méthode findAll du controller 'ReportLineScenarionController' ");
		return reportLineScenarioService.findAllReportScenario();

	}

}
