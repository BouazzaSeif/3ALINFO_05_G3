package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static final Logger log = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository; 
	
	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null;
		try {

			log.info("In Method retrieveAllEmployes :");
			employes = (List<Employe>) employeRepository.findAll();
			log.debug("connexion à la DB Ok :");
			for (Employe Employe : employes) {
				log.debug("Employe :" + Employe.getNom());
			}
			log.info("Out of Method retrieveAllEmployes with Success" + employes.size());
		} catch (Exception e) {
			log.error("Out of Method retrieveAllEmployes with Errors : " + e);
		}

		return employes;
	}

	@Override
	public Employe addEmploye(Employe u) {
		Employe c_saved = null;

		try {
			log.info("begin of the addEmploye method  ");
			c_saved = employeRepository.save(u);
			log.debug(u.getNom() + " added successfully");

		} catch (Exception e) {
			log.error("Error in method addEmploye with Errors : " + e);
		}

		return c_saved;
	}

	@Override
	public void deleteEmploye(String id) {
		try {
			log.debug("In Method deleteEmploye() :");
			employeRepository.deleteById(Long.parseLong(id));
			log.debug("Out of Method deleteEmploye() with Success");

		} catch (Exception e) {
			log.error("error in deleteEmploye() : " + e);
		}			
	}

	@Override
	public Employe updateEmploye(Employe u) {
		Employe employeUpdated = null;

		try {
			log.debug("In Method updateEmploye() :");
			employeUpdated =  employeRepository.save(u);
			log.debug("Out of Method updateEmploye() with Success");

		} catch (Exception e) {
			log.error("Out of Method updateEmploye() with Errors : " + e);
		}

		return employeUpdated;
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe emp = null;
		try {
			log.debug("In Method retrieveEmploye() :");

			emp = employeRepository.findById(Long.parseLong(id)).isPresent()
					? employeRepository.findById(Long.parseLong(id)).get()
					: null;
			log.debug("Out of Method retrieveEmploye() with Success");

		} catch (Exception e) {
			log.error("error in retrieveEmploye() : " + e);
		}

		return emp;
	}


}
