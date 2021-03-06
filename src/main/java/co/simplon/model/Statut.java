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
	private Long id;

	@Column(name = "LABEL", nullable = false)
	private String label;

	@ManyToOne
	@JoinColumn(name = "fk_scenario")
	private Scenario scenario;

	@JsonIgnore
	@OneToMany(mappedBy = "statut", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReportLineScenario> listReportLineScenario;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "fk_statut") private HistoryReport histoReportStatut;
	 */

	public Statut() {	}

	public Statut(Long id, String label, Scenario scenario, Set<ReportLineScenario> listReportLineScenario) {
		this.id = id;
		this.label = label;
		this.scenario = scenario;
		this.listReportLineScenario = listReportLineScenario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Set<ReportLineScenario> getListReportLineScenario() {
		return listReportLineScenario;
	}

	public void setListReportLineScenario(Set<ReportLineScenario> listReportLineScenario) {
		this.listReportLineScenario = listReportLineScenario;
	}

	@Override
	public String toString() {
		return "Statut [id=" + id + ", label=" + label + ", scenario=" + scenario + ", listReportLineScenario="
				+ listReportLineScenario + "]";
	}

	
}
