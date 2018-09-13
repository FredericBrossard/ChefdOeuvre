package co.simplon.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import co.simplon.model.ReportLineAppli;

@Named
public interface ReportLineAppliService {

	public List<ReportLineAppli> findAllReport();

	public ReportLineAppli save(ReportLineAppli reportAppli);

	public Optional<ReportLineAppli> findbyId(Long Id);

}
