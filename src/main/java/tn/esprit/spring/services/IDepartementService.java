package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	public int ajouterDepartement(Departement dep);
	public void deleteDepartementById(int depId);
	public Departement getDepartementById(int departementId);
}
