package co.simplon.model;

import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Report {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_generator")
	@SequenceGenerator(name = "statut_generator", sequenceName = "statut_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	/*@Column(name = "DATE", nullable = false)
	private LocalDate Date;*/
	@Column(name = "date")
	@CreatedDate
	private final Calendar date = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	

	//@JsonIgnore
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReportLineAppli> lineAppli;
	

	public Report() {
	}


	public Report(Long id, Set<ReportLineAppli> lineAppli) {
		this.id = id;
		this.lineAppli = lineAppli;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<ReportLineAppli> getLineAppli() {
		return lineAppli;
	}


	public void setLineAppli(Set<ReportLineAppli> lineAppli) {
		this.lineAppli = lineAppli;
	}


	public Calendar getDate() {
		return date;
	}


	@Override
	public String toString() {
		return "Report [id=" + id + ", date=" + date + ", lineAppli=" + lineAppli + "]";
	}


	
}
