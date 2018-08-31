package co.simplon.model;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Scenario {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "scenario_generator")
 	@SequenceGenerator(name="scenario_generator", sequenceName = "scenario_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id_scenario;
	
	@Column(name = "NAME",nullable=false)
	private String wording_scenario;

	//"@ManyToOne" exprime, entre des classes Java, une relation entre entités JPA. 
	// Ici il y a entre l'entitée "scenario" et l'entitée "application" => Plusieurs "scenario" pour UNE "application".
	@ManyToOne
	@JoinColumn(name = "aplication")
	private Application aplication;
	
	public Scenario( ) {};
	
	public Scenario(Long id_scenario, String wording_scenario, Application aplication) {
		super();
		this.id_scenario = id_scenario;
		this.wording_scenario = wording_scenario;
		this.aplication = aplication;
	}

	public Long getId_scenario() {
		return id_scenario;
	}

	public void setId_scenario(Long id_scenario) {
		this.id_scenario = id_scenario;
	}

	public String getWording_scenario() {
		return wording_scenario;
	}

	public void setWording_scenario(String wording_scenario) {
		this.wording_scenario = wording_scenario;
	}

	public Application getAplication() {
		return aplication;
	}

	public void setAplication(Application aplication) {
		this.aplication = aplication;
	}

	@Override
	public String toString() {
		return "Scenario [id_scenario=" + id_scenario + ", wording_scenario=" + wording_scenario + ", aplication="
				+ aplication + "]";
	} 
	

	
	
}
