package co.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Application;

import javax.inject.Named;


@Named
public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
