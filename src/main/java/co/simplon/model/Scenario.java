package co.simplon.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Scenario {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "scenario_generator")
 	@SequenceGenerator(name="scenario_generator", sequenceName = "scenario_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAMESCENA",nullable=false)
	private String wordingScenario;
	
/*	@Column(name = "NAMESTATUT", nullable = false)
	private String wordingStatut;*/

	//"@ManyToOne" exprime, entre des classes Java, une relation entre entités JPA. 
	// Ici il y a entre l'entitée "scenario" et l'entitée "application" => Plusieurs "scenario" pour UNE "application".
	@ManyToOne
	@JoinColumn(name = "aplication")
	private Application aplication;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Statut> statut;

	public Scenario() {}

	public Scenario(Long id, String wordingScenario, Application aplication, Set<Statut> statut) {
		this.id = id;
		this.wordingScenario = wordingScenario;
		this.aplication = aplication;
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWordingScenario() {
		return wordingScenario;
	}

	public void setWordingScenario(String wordingScenario) {
		this.wordingScenario = wordingScenario;
	}

	public Application getAplication() {
		return aplication;
	}

	public void setAplication(Application aplication) {
		this.aplication = aplication;
	}

	public Set<Statut> getStatut() {
		return statut;
	}

	public void setStatut(Set<Statut> statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Scenario [id=" + id + ", wordingScenario=" + wordingScenario + ", aplication=" + aplication
				+ ", statut=" + statut + "]";
	}

	
	
	
	
}
