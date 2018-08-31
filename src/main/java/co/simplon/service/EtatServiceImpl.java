package co.simplon.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.Etat;
import co.simplon.repository.EtatRepository;

@Named
public class EtatServiceImpl implements EtatService {
	
	@Inject
	EtatRepository etatRepository;
	
	public List<Etat>findAllEtat() {
		return etatRepository.findAll();
	}

}
