package co.simplon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.Statut;
import co.simplon.service.StatutService;

@Controller
@RequestMapping("/suivistatut")
@CrossOrigin(origins = {"http://localhost:4200"})
public class StatutController {
	
	@Inject
	StatutService statutService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Statut> listStatut(){
		List<Statut> list = statutService.findAllStatut();
		return list;
	}
	
	//Recupère la liste des statuts d'un scénario (selon son id scenario)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Statut> findAllStatutByIdScenario(@PathVariable(value="id") Long id) {
		List<Statut> listStatut = statutService.findAllStatutByScenarioId(id);
		return listStatut;
		
	}
	
	
	

}
