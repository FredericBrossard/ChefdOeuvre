package co.simplon.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class LineReport {

	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "linereport_generator")
 	@SequenceGenerator(name="linereport_generator", sequenceName = "linereport_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "date",nullable=false)
	private LocalDate date;
	
	@Column(name = "scenario",nullable=false)
	/*private String name;*/
	private String scenario;
	
	@Column(name = "statut",nullable=false)
	private String statut;
	
	@Column(name = "commentaire",nullable=false)
	private String comment;
	
	public LineReport() {}

	public LineReport(Long id, LocalDate date, String scenario, String statut, String comment) {
		this.id = id;
		this.date = date;
		this.scenario = scenario;
		this.statut = statut;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "LineReport [id=" + id + ", date=" + date + ", scenario=" + scenario + ", statut=" + statut
				+ ", comment=" + comment + "]";
	}

	
	
}
