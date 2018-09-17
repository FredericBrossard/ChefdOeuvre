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
    private Set<ReportLineScenario> listReportLineScenario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Statut> listStatut;
	

	public Scenario() {}


	public Scenario(Long id, String name, Application application, Set<ReportLineScenario> listReportLineScenario,
			Set<Statut> listStatut) {
		this.id = id;
		this.name = name;
		this.application = application;
		this.listReportLineScenario = listReportLineScenario;
		this.listStatut = listStatut;
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


	public Set<ReportLineScenario> getListReportLineScenario() {
		return listReportLineScenario;
	}


	public void setListReportLineScenario(Set<ReportLineScenario> listReportLineScenario) {
		this.listReportLineScenario = listReportLineScenario;
	}


	public Set<Statut> getListStatut() {
		return listStatut;
	}


	public void setListStatut(Set<Statut> listStatut) {
		this.listStatut = listStatut;
	}


	@Override
	public String toString() {
		return "Scenario [id=" + id + ", name=" + name + ", application=" + application + ", listReportLineScenario="
				+ listReportLineScenario + ", listStatut=" + listStatut + "]";
	}


	
}
