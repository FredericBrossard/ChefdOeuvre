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

import co.simplon.model.HistoryReport;
import co.simplon.service.HistoryServiceImpl;

@Controller
@RequestMapping("/suivihistory")
@CrossOrigin(origins = {"http://localhost:4200"})
public class HistoryReportController {
	
	@Inject
	HistoryServiceImpl historyService;
	
	/* CODE JavaScript à lancer depuis la console HTML
	
	     	
    	var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "/suivihistory");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({comment:"essai1", date : '', etat: {id:1}, statut: {id:1}, scenario: {id:1}
        }));
        
        

    	xmlhttp.response
	
	*/
		
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveReport(@RequestBody HistoryReport historyReport) {
	
		historyService.saveReport(historyReport);
		 System.out.println("Méthode saveReport du controller 'HistoryReportController' ");
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<HistoryReport> findAll() {
		return historyService.findAllReport();
	}
}
