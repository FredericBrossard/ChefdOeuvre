package co.simplon.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.model.Application;
import co.simplon.repository.ApplicationRepository;

@Named
public class ApplicationServiceImpl implements ApplicationService {

	@Inject
	ApplicationRepository applicationrepository;
		
	public List<Application> findAllApplication(){
		return applicationrepository.findAll();
	}
	
}
