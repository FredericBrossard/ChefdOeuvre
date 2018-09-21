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

import co.simplon.model.LineReport;
import co.simplon.service.LineService;

@Controller
@RequestMapping("/suivilinereport")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LineReportController {

	@Inject
	LineService lineService;

	@RequestMapping(method = RequestMethod.GET)
		@ResponseBody
		public List<LineReport> findAll() {
			return lineService.findAllReport();
		}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void saveReport(@RequestBody LineReport linereport) {

		lineService.saveReportLine(linereport);
		System.out.println("Méthode save du controller 'ReportController' ");

	}
}
