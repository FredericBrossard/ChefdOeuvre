package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Etat {
	@Id
	//les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "etat_generator")
 	@SequenceGenerator(name="etat_generator", sequenceName = "etat_seq", allocationSize=1)
	@Column(name = "ID")
	private Long id_etat;
	
	@Column(name = "NAME",nullable=false)
	private String wording_etat;

	public Etat() {};
	
	public Etat(Long id_etat, String wording_etat) {
		this.id_etat = id_etat;
		this.wording_etat = wording_etat;
	}

	public Long getId_etat() {
		return id_etat;
	}

	public void setId_etat(Long id_etat) {
		this.id_etat = id_etat;
	}

	public String getWording_etat() {
		return wording_etat;
	}

	public void setWording_etat(String wording_etat) {
		this.wording_etat = wording_etat;
	}

	@Override
	public String toString() {
		return "Etat [id_etat=" + id_etat + ", wording_etat=" + wording_etat + "]";
	}

	
	
}
