package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;


public interface IEntrepriseService {

	List<Entreprise> retrieveAllEntreprises();

	Entreprise addEntreprise(Entreprise u);

	void deleteEntreprise(String id);

	Entreprise updateEntreprise(Entreprise u);

	Entreprise retrieveEntreprise(String id);
}
