package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	public int ajouterContrat(Contrat contrat);

	public void mettreAjourEmailByContratId(String email, int contratId);

	public void deleteContratById(int contratId);

	public List<String> getAllContratJPQL();

	public void mettreAjourContractId(int contratId);

}