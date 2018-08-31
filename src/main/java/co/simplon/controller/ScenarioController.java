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

import co.simplon.model.Scenario;
import co.simplon.service.ScenarioServiceImpl;

@Controller
@RequestMapping("/suiviscenario")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ScenarioController {

	@Inject
	ScenarioServiceImpl scenarioServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Scenario> listScenario(){
		List<Scenario> list = scenarioServiceImpl.findAllScenario();
		return list;
		
	};
	
	
	
}
