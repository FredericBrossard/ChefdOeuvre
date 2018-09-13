package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.LineReport;

@Named
public interface LineRepository extends JpaRepository<LineReport, Long> {

}
