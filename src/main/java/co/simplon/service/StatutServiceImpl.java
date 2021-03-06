package co.simplon.service;

import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.Scenario;
import co.simplon.model.Statut;
import co.simplon.repository.StatutRepository;

@Named
public class StatutServiceImpl implements StatutService {
	
	@Inject
	StatutRepository statutRepository;
	
	public List<Statut> findAllStatut() {
		return statutRepository.findAll();
		
	}

	@Override
	public List<Statut> findAllStatutByScenarioId(Long id) {
	
		return statutRepository.findByScenarioId(id);
	}

	@Override
	public Statut findByScenarioAndLabel(Scenario scenario, String label) {
		
		return statutRepository.findByScenarioAndLabel(scenario, label);
	}



}
