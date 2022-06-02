package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
public interface IContratService {


		public int ajouterContrat(Contrat contrat);
		public void mettreAjourEmailByContratId(String email, int contratId);
		public void deleteContratById(int contratId);
		public List<String> getAllContratJPQL();
		public void mettreAjourContractId(int contratId);

	

}