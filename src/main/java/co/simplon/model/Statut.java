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
public class Statut {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_generator")
	@SequenceGenerator(name = "statut_generator", sequenceName = "statut_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id_statut;
	

	@Column(name = "NAME", nullable = false)
	private String wordingStatut;
	
	@ManyToOne
	@JoinColumn(name = "scenario")
	private Scenario scenario;
	
	@JsonIgnore
	//pour une categorie j'ai plusieurs aliments
	@OneToMany(mappedBy = "statut", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<HistoryReport> histoReportAppli;
	
	public Statut() {}

	public Statut(Long id_statut, String wordingStatut, Scenario scenario) {
		this.id_statut = id_statut;
		this.wordingStatut = wordingStatut;
		this.scenario = scenario;
	}

	public Long getId_statut() {
		return id_statut;
	}

	public void setId_statut(Long id_statut) {
		this.id_statut = id_statut;
	}

	public String getWordingStatut() {
		return wordingStatut;
	}

	public void setWordingStatut(String wordingStatut) {
		this.wordingStatut = wordingStatut;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@Override
	public String toString() {
		return "Statut [id_statut=" + id_statut + ", wordingStatut=" + wordingStatut + ", scenario=" + scenario + "]";
	}
	
}
