package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import co.simplon.model.ReportLineAppli;
import co.simplon.repository.ReportLineAppliRepository;

public class ReportLineAppliServiceImpl implements ReportLineAppliService {
	
	@Inject
	ReportLineAppliRepository reportLineAppliRepository;

	public List<ReportLineAppli> findAllReport() {
		return reportLineAppliRepository.findAll();
	}

	@Override
	public ReportLineAppli save(ReportLineAppli reportAppli) {
		reportLineAppliRepository.save(reportAppli);
		return reportAppli;
	}

	@Override
	public Optional<ReportLineAppli> findbyId(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}



}
