package co.simplon.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.ReportLineScenario;
import co.simplon.repository.ReportLineScenarioRepository;

@Named
public class ReportLineScenarioServiceImpl implements ReportLineScenarioService {

	@Inject
	ReportLineScenarioRepository reportLineScenarioRepository;

	public List<ReportLineScenario> findAllReportScenario() {
		return reportLineScenarioRepository.findAll();
	}

	public ReportLineScenario saveReportScenario(ReportLineScenario reportScenario) {
		reportLineScenarioRepository.save(reportScenario);
		return reportScenario;
	}

}
