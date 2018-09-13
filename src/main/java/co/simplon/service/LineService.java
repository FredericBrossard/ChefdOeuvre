package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import co.simplon.model.LineReport;

@Named
public interface LineService {
	
	public List<LineReport> findAllReport();
	
	public LineReport saveReportLine(LineReport lineReport);
	
	public Optional<LineReport> findReportbyId(int date);


}
