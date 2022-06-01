package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	@Query("SELECT e FROM Employe e where e.id=?1 ")

	public Entreprise getEntrepriseById();
	@Query("SELECT * FROM Employe e where e.id=?entrepriseId ")
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

}