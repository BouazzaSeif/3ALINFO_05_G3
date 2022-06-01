package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;


public interface IMissionService { 
	 
	List<Mission> retrieveAllMissions(); 
	Mission addMission(Mission m);
	void deleteMission(String id);
	Mission updateMission(Mission m);
	Mission retrieveMission(String id);

} 
 