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
public class ReportLineAppli {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_generator")
	@SequenceGenerator(name = "statut_generator", sequenceName = "statut_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_report")
	private Report report;
	
	@ManyToOne
	@JoinColumn(name = "fk_application")
	private Application application;
	
	@ManyToOne
	@JoinColumn(name = "fk_etat")
	private Etat etat;
	
	@Column(name = "COMMENT")
	private String comment;
	

	@JsonIgnore
	@OneToMany(mappedBy="reportLineAppli", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReportLineScenario> listReportLineScenario;
	
	
	 public ReportLineAppli() {}


	public ReportLineAppli(Long id, Report report, Application application, Etat etat, String comment,
			Set<ReportLineScenario> listReportLineScenario) {
		this.id = id;
		this.report = report;
		this.application = application;
		this.etat = etat;
		this.comment = comment;
		this.listReportLineScenario = listReportLineScenario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Report getReport() {
		return report;
	}


	public void setReport(Report report) {
		this.report = report;
	}


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Set<ReportLineScenario> getListReportLineScenario() {
		return listReportLineScenario;
	}


	public void setListReportLineScenario(Set<ReportLineScenario> listReportLineScenario) {
		this.listReportLineScenario = listReportLineScenario;
	}


	@Override
	public String toString() {
		return "ReportLineAppli [id=" + id + ", report=" + report + ", application=" + application + ", etat=" + etat
				+ ", comment=" + comment + ", listReportLineScenario=" + listReportLineScenario + "]";
	}


	
}
