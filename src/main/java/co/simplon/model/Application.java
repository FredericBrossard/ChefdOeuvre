package co.simplon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "fk_name_aplication")
	 */
	@Column(name = "NAME", nullable = false)
	private String name;


	/*@JsonIgnore
	//pour une categorie j'ai plusieurs aliments
	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistoryReport> histoReportAppli;	*/
	
	public Application() {
	}

	public Application(Long id, String name, Set<HistoryReport> histoReportAppli) {
		this.id = id;
		this.name = name;
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


	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + "]";
	}

	
	
}
