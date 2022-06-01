package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Mission;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer> {

	@Query("SELECT count(*) FROM Mission")
	public int counMission();

	@Query("SELECT nom FROM Mission")
	public List<String> missionNames();

	@Modifying
	@Query("DELETE from Mission")
	public void deleteAllMissionsPQL();

}
