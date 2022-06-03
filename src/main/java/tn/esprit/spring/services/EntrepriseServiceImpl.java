package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
@Slf4j
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger log = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	@Autowired
	EntrepriseRepository entrepriseRepository;

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null;
		try {

			log.info("In Method retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();
			log.debug("connexion à la DB Ok :");
			for (Entreprise entreprise : entreprises) {
				log.debug("Employe :" + entreprise.getName());
			}
			log.info("Out of Method retrieveAllEntreprises with Success" + entreprises.size());
		} catch (Exception e) {
			log.error("Out of Method retrieveAllEntreprises with Errors : " + e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise u) {
		Entreprise entreprise = null;

		try {
			log.info("begin of the addEntreprise method  ");
			entreprise = entrepriseRepository.save(u);
			log.debug(u.getName() + " added successfully");

		} catch (Exception e) {
			log.error("Error in method addEntreprise with Errors : " + e);
		}

		return entreprise;
	}

	@Override
	public void deleteEntreprise(String id) {
		try {
			log.debug("In Method deleteEntreprise() :");
			entrepriseRepository.deleteById(Long.parseLong(id));
			log.debug("Out of Method deleteEntreprise() with Success");

		} catch (Exception e) {
			log.error("error in deleteEntreprise() : " + e);
		}			
	}

	@Override
	public Entreprise updateEntreprise(Entreprise u) {
		Entreprise entrepriseUpdated = null;

		try {
			log.debug("In Method updateEntreprise() :");
			entrepriseUpdated =  entrepriseRepository.save(u);
			log.debug("Out of Method updateEntreprise() with Success");

		} catch (Exception e) {
			log.error("Out of Method updateEntreprise() with Errors : " + e);
		}

		return entrepriseUpdated;
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise entreprise = null;
		try {
			log.debug("In Method retrieveEmploye() :");

			entreprise = entrepriseRepository.findById(Long.parseLong(id)).isPresent()
					? entrepriseRepository.findById(Long.parseLong(id)).get()
					: null;
			log.debug("Out of Method retrieveEmploye() with Success");

		} catch (Exception e) {
			log.error("error in retrieveEmploye() : " + e);
		}

		return entreprise;
	}




}
