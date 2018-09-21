package co.simplon.model;

import java.util.Calendar;

import java.util.TimeZone;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;



//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class HistoryReport {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "historyreport_generator")
 	@SequenceGenerator(name="historyreport_generator", sequenceName = "historyreport_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_etat_appli")
	private Etat etat;
	
	@ManyToOne
	@JoinColumn(name = "fk_statut_scenario")
	private Statut statut;
	
/*	@JsonIgnore
	@OneToMany(mappedBy="histoReportEtat", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Etat> etat;
	
	@JsonIgnore
	@OneToMany(mappedBy="histoReportStatut", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Statut> statut;*/

	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "DATE")
	@CreatedDate
	private final Calendar createDate = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	

	public HistoryReport() {}


	public HistoryReport(Long id, Etat etat, Statut statut, String comment) {
		this.id = id;
		this.etat = etat;
		this.statut = statut;
		this.comment = comment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Calendar getCreateDate() {
		return createDate;
	}


	@Override
	public String toString() {
		return "HistoryReport [id=" + id + ", etat=" + etat + ", statut=" + statut + ", comment=" + comment
				+ ", createDate=" + createDate + "]";
	}


	
}
