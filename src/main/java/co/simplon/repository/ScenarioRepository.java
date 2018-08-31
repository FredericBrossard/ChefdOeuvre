package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Scenario;

@Named
public interface ScenarioRepository extends JpaRepository<Scenario, Long>{

}
