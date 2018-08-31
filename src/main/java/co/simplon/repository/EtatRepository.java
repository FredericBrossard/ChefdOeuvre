package co.simplon.repository;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.model.Etat;

@Named
public interface EtatRepository extends JpaRepository<Etat, Long> {

}
