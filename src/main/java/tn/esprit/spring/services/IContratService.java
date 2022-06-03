package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	List<Contrat> retrieveAllContrats();

	Contrat addContrat(Contrat u);

	void deleteContrat(String id);

	Contrat updateContrat(Contrat u);

	Contrat retrieveContrat(String id);
}