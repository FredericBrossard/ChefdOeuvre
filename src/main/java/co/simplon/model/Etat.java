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
public class Etat {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "etat_generator")
 	@SequenceGenerator(name="etat_generator", sequenceName = "etat_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id;
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_wording_etat")*/
	@Column(name = "NAME",nullable=false)
/*	private String wordingEtat;*/
	private String label;
	
	@JsonIgnore
	@OneToMany(mappedBy="etat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistoryReport> histoReportEtat;
	
	/*@JsonIgnore
	@OneToMany(mappedBy="etat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Scenario> scenario;*/

	public Etat() {}

	public Etat(Long id, String label, Set<HistoryReport> histoReportEtat) {
		this.id = id;
		this.label = label;
		this.histoReportEtat = histoReportEtat;
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

	public Set<HistoryReport> getHistoReportEtat() {
		return histoReportEtat;
	}

	public void setHistoReportEtat(Set<HistoryReport> histoReportEtat) {
		this.histoReportEtat = histoReportEtat;
	}

	@Override
	public String toString() {
		return "Etat [id=" + id + ", label=" + label + ", histoReportEtat=" + histoReportEtat + "]";
	}

}
