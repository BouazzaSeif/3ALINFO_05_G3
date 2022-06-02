package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
@Slf4j
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger log = LogManager.getLogger(EntrepriseServiceImpl.class);
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterDepartement(Departement dep) {
		log.info("ajouterDepartement lancé");
		try {
			deptRepoistory.save(dep);
			log.info("le Departement =" + dep.getId() + " ajouté");
		} catch (Exception e) {
			log.error("ajouterDepartement echoué, plus de detail " + e);
		}
		return dep.getId();
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		log.info("deleteDepartementById lancé");
		try {
			deptRepoistory.delete(deptRepoistory.findById(depId).orElseThrow(null));
			log.info("deleteDepartementById fini avec success");

		} catch (Exception e) {
			log.error("deleteDepartementById echoué, plus de detail " + e);
		}

	}

	public Departement getDepartementById(int departementId) {
		Departement enterprise = null;
		log.info("getEntrepriseById lancé");
		try {
			log.info("getEntrepriseById fini avec success");

			Departement departement = deptRepoistory.findById(departementId).orElseThrow(null);

		} catch (Exception e) {
			log.error("getEntrepriseById echoué, plus de detail " + e);
		}
		return enterprise;

	}

}
