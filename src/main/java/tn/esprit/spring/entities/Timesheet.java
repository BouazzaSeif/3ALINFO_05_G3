package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timesheet implements Serializable {


	private static final long serialVersionUID = 3876346912862238239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mission;
	
	public Timesheet(String mission, String employe) {
		this.mission = mission;
		this.employe = employe;
	}
	
	public Timesheet() {
	}

	public Timesheet(long id, String mission, String employe) {
		super();
		this.id = id;
		this.mission = mission;
		this.employe = employe;
	}

	private String employe;


	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getEmploye() {
		return employe;
	}

	public void setEmploye(String employe) {
		this.employe = employe;
	}

}
