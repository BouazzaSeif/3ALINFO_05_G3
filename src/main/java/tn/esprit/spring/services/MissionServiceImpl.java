package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
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
		try {
			l.debug("In Method deleteMission() :");
			missionRepository.deleteById(Long.parseLong(id));
			l.debug("Out of Method deleteMission() with Success");

		} catch (Exception e) {
			l.error("error in deleteMission() : " + e);
		}			
	}
	

	@Override
	public Mission updateMission(Mission m) {
		Mission missionUpdated = null;

		try {
			l.debug("In Method updateMission() :");
			missionUpdated =  missionRepository.save(m);
			l.debug("Out of Method updateMission() with Success");

		} catch (Exception e) {
			l.error("Out of Method updateMission() with Errors : " + e);
		}

		return missionUpdated;
	}

	@Override
	public Mission retrieveMission(String id) {
		Mission mission = null;
		try {
			l.debug("In Method retrieveMission() :");

			mission = missionRepository.findById(Long.parseLong(id)).isPresent()
					? missionRepository.findById(Long.parseLong(id)).get()
					: null;
			l.debug("Out of Method retrieveMission() with Success");

		} catch (Exception e) {
			l.error("error in retrieveMission() : " + e);
		}

		return mission;
	}
}