package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.LineReport;
import co.simplon.repository.LineRepository;

@Named
public class LineServiceImpl implements LineService {

	@Inject
	LineRepository lineRepository;
	
	@Override
	public List<LineReport> findAllReport() {
		
		return lineRepository.findAll();
	}

	@Override
	public LineReport saveReportLine(LineReport lineReport) {
		return lineRepository.save(lineReport);
	}

	@Override
	public Optional<LineReport> findReportbyId(int date) {
		// TODO Auto-generated method stub
		return null;
	}



}
