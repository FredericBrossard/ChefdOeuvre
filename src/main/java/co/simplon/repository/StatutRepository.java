package co.simplon.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Scenario;
import co.simplon.model.Statut;

@Named
public interface StatutRepository extends JpaRepository<Statut, Long>{


	public List<Statut> findByScenarioId(Long id);
	
	public Statut findByScenarioAndLabel(Scenario scenario, String label);
	
	
	
}
