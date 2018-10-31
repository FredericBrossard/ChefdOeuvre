package co.simplon.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Application;
import co.simplon.model.Scenario;

@Named
public interface ScenarioRepository extends JpaRepository<Scenario, Long>{

	public List<Scenario> findAllScenarioByApplication(Application application);
		
}
