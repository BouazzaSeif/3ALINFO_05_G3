package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	MissionRepository missionRepository;

	private static final Logger l = LogManager.getLogger(MissionServiceImpl.class);

	@Override
	public List<Mission> retrieveAllMissions() {
		List<Mission> missions = null;
		try {

			l.info("In Method retrieveAllMissions :");
			missions = (List<Mission>) missionRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Mission mission : missions) {
				l.debug("mission :" + mission.getName());
			}
			l.info("Out of Method retrieveAllMissions with Success" + missions.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e);
		}

		return missions;
	}

	@Override
	public Mission addMission(Mission m) {
		Mission mission_saved = null;

		try {
			// TODO Log à ajouter en début de la méthode
			l.info("begin of the addMission method  ");
			mission_saved = missionRepository.save(m);
			// TODO Log à ajouter à la fin de la méthode
			l.debug(m.getName() + " added successfully");

		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
			l.error("Error in method addMission with Errors : " + e);
		}

		return mission_saved;
	}

	@Override
	public void deleteMission(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mission updateMission(Mission m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mission retrieveMission(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}