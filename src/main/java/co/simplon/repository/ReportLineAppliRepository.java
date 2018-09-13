package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.ReportLineAppli;

@Named
public interface ReportLineAppliRepository extends JpaRepository<ReportLineAppli, Long> {

}
