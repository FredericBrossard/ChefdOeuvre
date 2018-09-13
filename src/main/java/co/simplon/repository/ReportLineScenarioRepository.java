package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.ReportLineScenario;

@Named
public interface ReportLineScenarioRepository extends JpaRepository<ReportLineScenario, Long>{

}

