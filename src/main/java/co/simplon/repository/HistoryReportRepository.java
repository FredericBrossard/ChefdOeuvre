package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.HistoryReport;

@Named
public interface HistoryReportRepository extends JpaRepository<HistoryReport, Long>{

}
