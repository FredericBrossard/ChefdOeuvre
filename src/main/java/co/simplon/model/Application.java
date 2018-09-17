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
    private Set<Scenario> listScenario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReportLineAppli> listReportLineAppli;

	public Application() {
	}

	public Application(Long id, String name, Set<Scenario> listScenario, Set<ReportLineAppli> listReportLineAppli) {
		this.id = id;
		this.name = name;
		this.listScenario = listScenario;
		this.listReportLineAppli = listReportLineAppli;
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

	public Set<Scenario> getListScenario() {
		return listScenario;
	}

	public void setListScenario(Set<Scenario> listScenario) {
		this.listScenario = listScenario;
	}

	public Set<ReportLineAppli> getListReportLineAppli() {
		return listReportLineAppli;
	}

	public void setListReportLineAppli(Set<ReportLineAppli> listReportLineAppli) {
		this.listReportLineAppli = listReportLineAppli;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", listScenario=" + listScenario + ", listReportLineAppli="
				+ listReportLineAppli + "]";
	}

	
	
}
