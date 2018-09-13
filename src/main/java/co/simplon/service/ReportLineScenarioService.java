package co.simplon.service;

import java.util.List;


import co.simplon.model.ReportLineScenario;

public interface ReportLineScenarioService {
	
	public List<ReportLineScenario> findAllReportScenario();

	public ReportLineScenario saveReportScenario(ReportLineScenario reportScenario);

/*	public Optional<ReportLineScenario> findReportbyId(int date);*/

}
