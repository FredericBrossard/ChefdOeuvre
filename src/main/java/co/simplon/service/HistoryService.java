package co.simplon.service;

import java.util.List;
import java.util.Optional;

import co.simplon.model.HistoryReport;

public interface HistoryService {
	
	public List<HistoryReport> findAllReport();
	
	public HistoryReport saveReport(HistoryReport report);
	
	public Optional<HistoryReport> findReportbyId(int date);

}
