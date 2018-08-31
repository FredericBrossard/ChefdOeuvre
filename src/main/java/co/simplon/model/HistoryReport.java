package co.simplon.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Long id_historyreport;
	
/*	@Column(name = "IDAPPLI",nullable=false)
	private String id_aplication;*/
		
/*	@Column(name = "IDETAT",nullable=false)
	private String id_etat;*/
	
/*	@ManyToOne
	@JoinColumn(name = "etat")
	private Etat etat;*/
	@OneToMany
	private List <Etat> etat = new ArrayList<>();
	
/*	@Column(name = "IDSCENA",nullable=false)
	private String id_scenario;
	*/
/*	@ManyToOne
	@JoinColumn(name = "scenario")
	private Scenario scenario;*/
/*	Une relation 1:n est caractérisée par un champ de type Collection dans la classe maître. 
	La classe esclave ne porte pas de relation retour. 
	Cette relation peut être spécifiée soit par l'annotation @OneToMany ou @ManyToMany
*/	
	@OneToMany
	private List <Scenario> scenario = new ArrayList<>();
	
	/*@Column(name = "IDSTATU",nullable=false)
	private String id_statut;*/
	/*@ManyToOne
	@JoinColumn(name = "statut")
	private Statut statut;*/
	@OneToMany
	private List <Statut> statut  = new ArrayList<>();
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "DATE")
	@CreatedDate
	private final Calendar CreateDate = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	
	
}
