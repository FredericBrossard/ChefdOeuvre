package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.HistoryReport;
import co.simplon.repository.HistoryReportRepository;

@Named
public class HistoryServiceImpl implements HistoryService {
	
	@Inject
	HistoryReportRepository historyReport;
	
	//Recupération de tous les rapports
	public List<HistoryReport> findAllReport() {
		return historyReport.findAll();
		
	};
	
	public HistoryReport saveReport(HistoryReport report) {
		historyReport.save(report);
		return report;
		
	};

	
	//Recupération par ID, mais l'adapter pour effetcuer une recupération d'un rapport sur une date.
	@Override
	public Optional<HistoryReport> findReportbyId(int date) {
		return null;
	};
	

}
