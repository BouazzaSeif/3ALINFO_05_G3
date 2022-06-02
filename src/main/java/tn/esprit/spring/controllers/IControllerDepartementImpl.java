package tn.esprit.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;
@Controller
public class IControllerDepartementImpl {
	@Autowired
	IDepartementService idepartementservice;

	//add
	public int ajouterDepartement(Departement dep) {
		return idepartementservice.ajouterDepartement(dep);
	}
	//getbyid
	public Departement getDepartementById() {
		return idepartementservice.getDepartementById(1);
	}
	//supp
	public void deleteDepartementById(int depId) {
		idepartementservice.deleteDepartementById(depId);

	}
	
	
}
