package co.simplon.service;

import java.util.List;
import java.util.Optional;


import co.simplon.model.Report;


public interface ReportService {
	
	public List<Report> findAllReport();
	
	public Report saveReport(Report lineReport);
	
	public Optional<Report> findReportbyId(Long id);

}
