package co.simplon.service;

import java.util.List;

import javax.inject.Named;

import co.simplon.model.Application;
import co.simplon.model.Scenario;

@Named
public interface ScenarioService {
	
	public List<Scenario> findAllScenario();
	
	public List<Scenario> findAllScenarioByApplication(Application application);

}
