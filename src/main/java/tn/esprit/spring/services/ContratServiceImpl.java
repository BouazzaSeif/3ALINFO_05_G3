package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

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