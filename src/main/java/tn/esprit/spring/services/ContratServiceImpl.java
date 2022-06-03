package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	
	@Override
	public List<Contrat> retrieveAllContrats() {
		List<Contrat> contrats = null;
		try {

			l.info("In Method retrieveAllcontrats :");
			contrats = (List<Contrat>) contratRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Contrat contrat : contrats) {
				l.debug("contrat :" + contrat.getTypeContrat());
			}
			l.info("Out of Method retrieveAllcontrats with Success" + contrats.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllcontrats with Errors : " + e);
		}

		return contrats;
	
}

	@Override
	public Contrat addContrat(Contrat u) {
		Contrat c_saved = null;

		try {
			// TODO Log à ajouter en début de la méthode
			l.info("begin of the addContrat method  ");
			c_saved = contratRepository.save(u);
			// TODO Log à ajouter à la fin de la méthode
			l.debug(u.getTypeContrat() + " added successfully");

		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
			l.error("Error in method addContrat with Errors : " + e);
		}

		return c_saved;
	}


	@Override
	public void deleteContrat(String id) {
		try {
			l.debug("In Method deleteContrat() :");
			contratRepository.deleteById(Long.parseLong(id));
			l.debug("Out of Method deleteContrat() with Success");

		} catch (Exception e) {
			l.error("error in deleteContrat() : " + e);
		}		
	}

	@Override
	public Contrat updateContrat(Contrat u) {
		Contrat contratUpdated = null;

		try {
			l.debug("In Method updateUser() :");
			contratUpdated = contratRepository.save(u);
			l.debug("Out of Method updateUser() with Success");

		} catch (Exception e) {
			l.error("Out of Method updateUser() with Errors : " + e);
		}

		return contratUpdated;
	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat c = null;
		try {
			l.debug("In Method retrieveContrat() :");

			c = contratRepository.findById(Long.parseLong(id)).isPresent()
					? contratRepository.findById(Long.parseLong(id)).get()
					: null;
			l.debug("Out of Method retrieveContrat() with Success");

		} catch (Exception e) {
			l.error("error in retrieveContrat() : " + e);
		}

		return c;
	}


}