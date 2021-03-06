package co.simplon.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.Application;
import co.simplon.model.Scenario;
import co.simplon.repository.ScenarioRepository;

@Named
public class ScenarioServiceImpl implements ScenarioService {
    @Inject
	ScenarioRepository scenarioRepository;
	
	public List<Scenario> findAllScenario() {
		return scenarioRepository.findAll();
			
	};
	
	public List<Scenario> findAllScenarioByApplication(Application application) {
		return scenarioRepository.findAllScenarioByApplication(application);
		
	};
}
