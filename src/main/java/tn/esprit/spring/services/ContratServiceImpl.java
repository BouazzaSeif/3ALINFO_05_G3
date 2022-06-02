package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;

	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}

	@Override
	public void mettreAjourEmailByContratId(String email, int contratId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContratById(int contratId) {
		// TODO Auto-generated method stub
		Contrat contratManagedEntity = contratRepository.findById(contratId).orElseThrow(null);
		contratRepository.delete(contratManagedEntity);
		
	}

	@Override
	public List<String> getAllContratJPQL() {
		// TODO Auto-generated method stub
		return contratRepository.contratId();
	}

	@Override
	public void mettreAjourContractId(int contratId) {
		// TODO Auto-generated method stub
		
	}


	



	



	



	




}
