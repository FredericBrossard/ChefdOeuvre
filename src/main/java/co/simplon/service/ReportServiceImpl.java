package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.Report;
import co.simplon.repository.ReportRepository;

@Named
public class ReportServiceImpl implements ReportService{

	
	@Inject
	ReportRepository reportRepository;

	@Override
	public List<Report> findAllReport() {
		return reportRepository.findAllByOrderByDateDesc();
	}

	@Override
	public Report saveReport(Report report) {
		reportRepository.save(report);
		return report;
	}

	@Override
	public Optional<Report> findReportbyId(Long id) {
		
		return reportRepository.findById(id);
	}
	
	

}
