package co.simplon.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Application {
	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_generator")
	@SequenceGenerator(name = "application_generator", sequenceName = "application_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Scenario> scenario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReportLineAppli> reportLineAppli;

	public Application() {
	}

	public Application(Long id, String name, Set<Scenario> scenario, Set<ReportLineAppli> reportLineAppli) {
		this.id = id;
		this.name = name;
		this.scenario = scenario;
		this.reportLineAppli = reportLineAppli;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Scenario> getScenario() {
		return scenario;
	}

	public void setScenario(Set<Scenario> scenario) {
		this.scenario = scenario;
	}

	public Set<ReportLineAppli> getReportLineAppli() {
		return reportLineAppli;
	}

	public void setReportLineAppli(Set<ReportLineAppli> reportLineAppli) {
		this.reportLineAppli = reportLineAppli;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", scenario=" + scenario + ", reportLineAppli="
				+ reportLineAppli + "]";
	}

	
}
