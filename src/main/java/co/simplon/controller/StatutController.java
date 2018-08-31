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

import co.simplon.model.Statut;
import co.simplon.service.StatutServiceImpl;

@Controller
@RequestMapping("/suivistatut")
@CrossOrigin(origins = {"http://localhost:4200"})
public class StatutController {
	
	@Inject
	StatutServiceImpl statutServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Statut> listStatut(){
		List<Statut> list = statutServiceImpl.findAllStatut();
		return list;
	}
	

}
