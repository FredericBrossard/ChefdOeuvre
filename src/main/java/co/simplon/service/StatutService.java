package co.simplon.service;

import java.util.List;


import javax.inject.Named;

import co.simplon.model.Scenario;
import co.simplon.model.Statut;

@Named
public interface StatutService {
	
	public List<Statut> findAllStatut();
	
	public List<Statut> findAllStatutByScenarioId(Long id);
	
	public Statut findByScenarioAndLabel(Scenario scenario, String label);


}
