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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class Report {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_generator")
	@SequenceGenerator(name = "report_generator", sequenceName = "report_seq", allocationSize = 1)
	@Column(name = "ID")
	// attribut "Clef primaire"
	private Long id;
	// attribut "date du rapport"
	@Column(name = "date")
	@CreatedDate
	private final Calendar date = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	
	//Relation bidirectionnelle de type 1 "Report" pour plusieurs "ReportLineAppli". 
	//Attribut "listLineAppli" de type liste de ReportLineAppli
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id")
	private Set<ReportLineAppli> listLineAppli;
	
	public Report() {
	}

	public Report(Long id, Set<ReportLineAppli> lineAppli) {
		this.id = id;
		this.listLineAppli = lineAppli;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<ReportLineAppli> getLineAppli() {
		return listLineAppli;
	}


	public void setLineAppli(Set<ReportLineAppli> lineApplis) {
		this.listLineAppli = lineApplis;
		for(ReportLineAppli lineAppli : lineApplis) {
			lineAppli.setReport(this);
		}
	}


	public Calendar getDate() {
		return date;
	}


	@Override
	public String toString() {
		return "Report [id=" + id + ", date=" + date + ", lineAppli=" + listLineAppli + "]";
	}


	
}
