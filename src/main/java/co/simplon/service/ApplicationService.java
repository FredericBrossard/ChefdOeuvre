package co.simplon.service;

import java.util.List;

import co.simplon.model.Application;


public interface ApplicationService {
	// Méthode qui renvoi une liste d'Application
	public List<Application> findAllApplication();
}
