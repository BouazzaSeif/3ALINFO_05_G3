package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
@Slf4j
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger log = LogManager.getLogger(DepartementServiceImpl.class);
	
	@Autowired
	DepartementRepository departementRepository ;

	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> departements = null;
		try {

			log.info("In Method retrieveAlldepartements :");
			departements = (List<Departement>) departementRepository.findAll();
			log.debug("connexion à la DB Ok :");
			for (Departement departement : departements) {
				log.debug("departement :" + departement.getName());
			}
			log.info("Out of Method retrieveAlldepartements with Success" + departements.size());
		} catch (Exception e) {
			log.error("Out of Method retrieveAlldepartements with Errors : " + e);
		}

		return departements;
	
	}

	@Override
	public Departement addDepartement(Departement u) {
		Departement c_saved = null;

		try {
			log.info("begin of the addDepartement method  ");
			c_saved = departementRepository.save(u);
			log.debug(u.getName() + " added successfully");

		} catch (Exception e) {
			log.error("Error in method addContrat with Errors : " + e);
		}

		return c_saved;
	}

	@Override
	public void deleteDepartement(String id) {
		try {
			log.debug("In Method deleteDepartement() :");
			departementRepository.deleteById(Long.parseLong(id));
			log.debug("Out of Method deleteDepartement() with Success");

		} catch (Exception e) {
			log.error("error in deleteDepartement() : " + e);
		}			
	}

	@Override
	public Departement updateDepartement(Departement u) {
		Departement departementUpdated = null;

		try {
			log.debug("In Method updateDepartement() :");
			departementUpdated = departementRepository.save(u);
			log.debug("Out of Method updateDepartement() with Success");

		} catch (Exception e) {
			log.error("Out of Method updateDepartement() with Errors : " + e);
		}

		return departementUpdated;
	}

	@Override
	public Departement retrieveDepartement(String id) {
		Departement d = null;
		try {
			log.debug("In Method retrieveDepartement() :");

			d = departementRepository.findById(Long.parseLong(id)).isPresent()
					? departementRepository.findById(Long.parseLong(id)).get()
					: null;
			log.debug("Out of Method retrieveDepartement() with Success");

		} catch (Exception e) {
			log.error("error in retrieveDepartement() : " + e);
		}

		return d;
	}


}
