package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Contrat;
@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{
	
	@Query("SELECT count(*) FROM Contrat")
    public int countemp();
	
    @Query("SELECT nom FROM Contrat")
    public List<String> contratId();
    
    
    
    
    
    
    
    
    
    @Query("Select "
			+ "DISTINCT ctr from Contrat ctr "
			+ "join ctr.departements dps "
			+ "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Contrat> getAllContratByEntreprisec(@Param("entreprise") Entreprise entreprise);
    
    @Modifying
    @Query("UPDATE Contrat e SET e.contrat=:contrat1 where e.id=:contratId")
    public void mettreAjourEmailByContratIdJPQL(@Param("contrat1")String email, @Param("conrtatId")int contratId);

    @Modifying
    @Query("DELETE from Contrat")
    public void deleteAllContratJPQL();
    
    //@Query("select c.salaire from Contrat c join c.employe e where e.id=:employeId")

    @Query("select c.salaire from Contrat c where c.contrat.id=:contratId")
    public float getSalaireByContratIdJPQL(@Param("contratId")int contratId);
    
    
    @Query("Select "
			+ "DISTINCT AVG(cont.salaire) from Contrat cont "
			+ "join cont.employe emp "
			+ "join emp.departements deps "
			+ "where deps.id=:depId")
    public Double getSalaireMoyenByDepartementId(@Param("depId")int departementId);
	
    		
   

	
} 