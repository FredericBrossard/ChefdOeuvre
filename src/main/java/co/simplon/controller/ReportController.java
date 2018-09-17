package co.simplon.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.Report;
import co.simplon.service.ReportService;




@Controller
@RequestMapping("/suivireport")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ReportController {
	
	@Inject
	ReportService reportService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveReport(@RequestBody Report report) {

		reportService.saveReport(report);
		System.out.println("Méthode save du controller 'ReportController' ");

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Report> findAll() {
		System.out.println("Méthode findAll du controller 'ReportLineScenarionController' ");
		return reportService.findAllReport();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
        public Report findById(@PathVariable(value="id") Long id) {
        System.out.println("Methode findById de ReportController sur id = " + id);
        Optional<Report> reportOpt =  reportService.findReportbyId(id);
        Report result;
        if (reportOpt.isPresent()) {
        	result = reportOpt.get();
        }else {
        	result = null;
        }
        
        return result;
    }

}
