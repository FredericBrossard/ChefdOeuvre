package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//L'annotation @Entity nous indique que cette classe est une classe persistante.
@Entity
public class Statut {

	@Id
	// les 2 annotations permettent de gérer la séquence/attribution du no de l'id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_generator")
	@SequenceGenerator(name = "statut_generator", sequenceName = "statut_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id_statut;

	@Column(name = "NAME", nullable = false)
	private String wording_statut;
	
	public Statut() {}

	public Statut(Long id_statut, String wording_statut) {
		this.id_statut = id_statut;
		this.wording_statut = wording_statut;
	}

	public Long getId_statut() {
		return id_statut;
	}

	public void setId_statut(Long id_statut) {
		this.id_statut = id_statut;
	}

	public String getWording_statut() {
		return wording_statut;
	}

	public void setWording_statut(String wording_statut) {
		this.wording_statut = wording_statut;
	}

	@Override
	public String toString() {
		return "Statut [id_statut=" + id_statut + ", wording_statut=" + wording_statut + "]";
	};
	
	

}
