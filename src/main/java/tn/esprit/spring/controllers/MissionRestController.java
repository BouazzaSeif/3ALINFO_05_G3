
package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

@RestController
public class MissionRestController {

	// Couplage Faible
	@Autowired
	IMissionService missionService;

	// URL : http://localhost:????/????/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	public List<Mission> retrieveAllMissions() {
		List<Mission> list = missionService.retrieveAllMissions();
		return list;
	}

	// http://localhost:????/timesheet-devops/retrieve-mission/{mission-id}
	@GetMapping("/retrieve-mission/{mission-id}")
	public Mission retrieveMission(@PathVariable("mission-id") String missionId) {
		return missionService.retrieveMission(missionId);
	}

	// Ajouter Mission : http://localhost:????/timesheet-devops/add-mission
	@PostMapping("/add-mission")
	public Mission addMission(@RequestBody Mission u) {
		Mission mission = missionService.addMission(u);
		return mission;
	}

	// Supprimer Mission :
	// http://localhost:????/timesheet-devops/remove-mission/{mission-id}
	@DeleteMapping("/remove-mission/{mission-id}")
	public void removeMission(@PathVariable("mission-id") String missionId) {
		missionService.deleteMission(missionId);
	}

	// Modifier Mission
	// http://localhost:????/timesheet-devops/modify-mission
	@PutMapping("/modify-mission")
	public Mission updateMission(@RequestBody Mission mission) {
		return missionService.updateMission(mission);
	}

}
