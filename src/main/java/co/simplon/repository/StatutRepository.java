package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Statut;

@Named
public interface StatutRepository extends JpaRepository<Statut, Long>{

}
