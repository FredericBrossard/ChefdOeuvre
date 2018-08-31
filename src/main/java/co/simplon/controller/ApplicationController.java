package co.simplon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.Application;
import co.simplon.service.ApplicationServiceImpl;

@Controller
@RequestMapping("/suiviappli")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ApplicationController {
	
	@Inject
	ApplicationServiceImpl application;
	
	
	//http://localhost:8090/suivipatrimoine/listappli
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Application> listApplication() {
	List<Application> list = application.findAllApplication();
	return list;
		
	}
	
	

}
