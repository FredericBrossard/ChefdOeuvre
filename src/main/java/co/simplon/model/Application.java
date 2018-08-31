package co.simplon.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Application {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "application_generator")
 	@SequenceGenerator(name="application_generator", sequenceName = "application_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id_application;
	
	@Column(name = "NAME",nullable=false)
	private String name_aplication;
	
/*	@OneToMany
	private Set<Scenario> scenario;*/
	
	public Application() {};

	public Application(Long id_application, String name_aplication, Set<Scenario> scenario) {
		this.id_application = id_application;
		this.name_aplication = name_aplication;
	//	this.scenario = scenario;
	}

	public Long getId_application() {
		return id_application;
	}

	public void setId_application(Long id_application) {
		this.id_application = id_application;
	}

	public String getName_aplication() {
		return name_aplication;
	}

	public void setName_aplication(String name_aplication) {
		this.name_aplication = name_aplication;
	}

/*	public Set<Scenario> getScenario() {
		return scenario;
	}

	public void setScenario(Set<Scenario> scenario) {
		this.scenario = scenario;
	}*/
	//Methode toString qui transforme l'objet est chaine de characteres
	@Override
	public String toString() {
		return "Application [id_application=" + id_application + ", name_aplication=" + name_aplication + "]";
		/*return "Application [id_application=" + id_application + ", name_aplication=" + name_aplication + ", scenario="
		+ scenario + "]";*/
	}
 
}
