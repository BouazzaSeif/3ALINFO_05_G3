package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;
@Repository
public interface DepartementRepository extends CrudRepository<Departement, Integer>  {
	@Query("SELECT d FROM Departement d where d.id=?1 ")

	public Departement getDepartementById();
	@Query("SELECT * FROM Departement d where d.id=?departementId ")
	public List<String> getAllDepartementsNamesByDepartement(int departementId);
}
