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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
@Slf4j
public class EntrepriseServiceImpl implements IEntrepriseService {
	  private static final Logger log=LogManager.getLogger(EntrepriseServiceImpl.class);

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterEntreprise(Entreprise entreprise) {
		log.info("ajouterEntreprise lancé");
		try{
			entrepriseRepoistory.save(entreprise);
			log.info("L'entreprise="+entreprise.getId()+" ajoutée");
			
		}
		catch (Exception e){
			log.error("ajouterEnterprise echoué, plus de detail "+e);
		}
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		log.info("ajouterDepartement lancé");
		try{
		deptRepoistory.save(dep);
		log.info("le Departement ="+dep.getId()+" ajouté");
		}
		catch (Exception e){
			log.error("ajouterDepartement echoué, plus de detail "+e);
		}		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		log.info("affecterDepartementAEntreprise lancé");
		try{
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElseThrow(null);
		Departement depManagedEntity = deptRepoistory.findById(depId).orElseThrow(null);

		depManagedEntity.setEntreprise(entrepriseManagedEntity);
		deptRepoistory.save(depManagedEntity);
		log.info("affecterDepartementAEntreprise fini avec success");

		}
		catch (Exception e){
			log.error("affecterDepartement echoué, plus de detail "+e);
		}	

	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		log.info("getAllDepartementsNamesByEntreprise lancé");
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElseThrow(null);
		List<String> depNames = new ArrayList<>();
        try{

		for (Departement dep : entrepriseManagedEntity.getDepartements()) {
			depNames.add(dep.getName());

		}
        
    	log.info("getAllDepartementsNamesByEntreprise fini avec success");

	}
	catch (Exception e){
		log.error("getAllDepartementsNamesByEntreprise echoué, plus de detail "+e);
	}	
		return depNames;



	}
    @Transactional

	public void deleteEntrepriseById(int entrepriseId) {
		log.info("deleteEntrepriseById lancé");
    try{
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElseThrow(null));
        log.info("deleteEntrepriseById fini avec success");

        }
    catch (Exception e){
    	log.error("deleteEntrepriseById echoué, plus de detail "+e);
    }
}
    @Transactional
	public void deleteDepartementById(int depId) {
		log.info("deleteDepartementById lancé");
		try{
		deptRepoistory.delete(deptRepoistory.findById(depId).orElseThrow(null));
		 log.info("deleteDepartementById fini avec success");

        }
    catch (Exception e){
    	log.error("deleteDepartementById echoué, plus de detail "+e);
    }

		}

	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise enterprise = null ;
		log.info("getEntrepriseById lancé");
		try{		 log.info("getEntrepriseById fini avec success");

		 enterprise = entrepriseRepoistory.findById(entrepriseId).orElseThrow(null);

        }
    catch (Exception e){
    	log.error("getEntrepriseById echoué, plus de detail "+e);
    }
		return enterprise;

	}


}
