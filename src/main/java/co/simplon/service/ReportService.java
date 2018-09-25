package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import co.simplon.model.Report;

@Named
public interface ReportService {
	
	public List<Report> findAllReport();
	
	public Report saveReport(Report lineReport);
	
	public Optional<Report> findReportbyId(Long id);
	/*public Optional<Report> findReportbyId(int id);*/
	
/*	public Optional<Report> findReportByIdByApplicationAsc(Long id);*/
	
	public Long createReport();
	
/*	public Boolean sendEmail ();*/
	
	public Boolean sendEmail (Report report, String emailAdresse);

}
