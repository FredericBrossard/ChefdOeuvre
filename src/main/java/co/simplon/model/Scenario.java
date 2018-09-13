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
	
	@Column(name = "NAME",nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "fk_application")
	private Application application;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReportLineScenario> reportLineScenario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Statut> statut;
	

	public Scenario() {}


	public Scenario(Long id, String name, Application application, Set<ReportLineScenario> reportLineScenario,
			Set<Statut> statut) {
		this.id = id;
		this.name = name;
		this.application = application;
		this.reportLineScenario = reportLineScenario;
		this.statut = statut;
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


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	public Set<ReportLineScenario> getReportLineScenario() {
		return reportLineScenario;
	}


	public void setReportLineScenario(Set<ReportLineScenario> reportLineScenario) {
		this.reportLineScenario = reportLineScenario;
	}


	public Set<Statut> getStatut() {
		return statut;
	}


	public void setStatut(Set<Statut> statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Scenario [id=" + id + ", name=" + name + ", application=" + application + ", reportLineScenario="
				+ reportLineScenario + ", statut=" + statut + "]";
	}

	
}
