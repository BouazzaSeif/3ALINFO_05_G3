package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = -357738161698377833L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String etage ;

	public Departement() {
		super();
	}

	public Departement(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public Departement(int id, String name, String etage) {
		super();
		this.id = id;
		this.name = name;
		this.etage = etage;
	}

	public Departement(String name, String etage) {
		super();
		this.name = name;
		this.etage = etage;
	}

	
	

}
