package co.simplon.repository;

import java.util.List;


import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Report;

@Named
public interface ReportRepository extends JpaRepository<Report, Long>{

	List<Report> findAllByOrderByDateAsc();
	List<Report> findAllByOrderByDateDesc();
	
/*	Optional<Report> findReportByIdApplicationAsc(Long id);*/
	
	

}
