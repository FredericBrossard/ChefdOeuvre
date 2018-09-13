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

@Entity
public class ReportLineScenario {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_generator")
	@SequenceGenerator(name = "statut_generator", sequenceName = "statut_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "fk_reportLineAppli")
	private ReportLineAppli reportLineAppli;

	@ManyToOne
	@JoinColumn(name = "fk_scenario")
	private Scenario scenario;

	@ManyToOne
	@JoinColumn(name = "fk_scenarioStatut")
	private Statut statut;

	public ReportLineScenario() {
	}

	public ReportLineScenario(Long id, ReportLineAppli reportLineAppli, Scenario scenario, Statut statut) {
		this.id = id;
		this.reportLineAppli = reportLineAppli;
		this.scenario = scenario;
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReportLineAppli getReportLineAppli() {
		return reportLineAppli;
	}

	public void setReportLineAppli(ReportLineAppli reportLineAppli) {
		this.reportLineAppli = reportLineAppli;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "ReportLineScenario [id=" + id + ", reportLineAppli=" + reportLineAppli + ", scenario=" + scenario
				+ ", statut=" + statut + "]";
	}

	

}
