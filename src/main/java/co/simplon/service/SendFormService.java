package co.simplon.service;

import javax.inject.Named;

import co.simplon.model.Form;

@Named
public interface SendFormService {
	
	/*public Boolean envoyer(Form form, String emailAdresse);*/
	//Méthode d'envoi du formulaire par mail
	public Boolean envoyer(Form form);

}
