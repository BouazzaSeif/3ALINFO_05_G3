package tn.esprit.spring.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RestController
public class RestControlDepartement {
	@Autowired
	IDepartementService idepartementservice;
	

 	@PostMapping("/ajouterDepartement")
 	@ResponseBody
	public int ajouterDepartement(@RequestBody Departement dep) {
		return idepartementservice.ajouterDepartement(dep);
	}
 	
 	
 	 @DeleteMapping("/deleteDepartementById/{iddept}") 
 	@ResponseBody 
 	public void deleteDepartementById(@PathVariable("iddept") int depId) {
 		idepartementservice.deleteDepartementById(depId);
 	}
 	 
 	 
 	 @GetMapping(value = "getDepartementById/{iddepartement}")
     @ResponseBody
 	public Departement getDepartementById(@PathVariable("iddepartement") int departementId) {

 		return idepartementservice.getDepartementById(departementId);
 	}
}
