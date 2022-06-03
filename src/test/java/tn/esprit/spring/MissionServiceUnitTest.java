package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IMissionService;



@SpringBootTest
class MissionServiceUnitTests {

	@Autowired
	IMissionService iMissionService;
	
	@Test
	@Order(1)
	public void testRetrieveAllMissions() {
		List<Mission> listMissions = iMissionService.retrieveAllMissions();
		Assertions.assertEquals(listMissions.size(), listMissions.size());
	}
	
	@Test
	@Order(2)
	public void testAddMission() throws ParseException {
		Mission m = new Mission(1L, "Name", "Description");
		Mission missionAdded = iMissionService.addMission(m);
		Assertions.assertEquals(m.getName(), missionAdded.getName());

	}
	
	
	@Test
	@Order(3)
	public void testModifyMission() throws ParseException {
		Mission m = new Mission(1L, "Name", "Description");
		Mission missionUpdated = iMissionService.updateMission(m);
		Assertions.assertEquals(m.getName(), missionUpdated.getName());
	}

	@Test
	@Order(4)
	public void testDeleteMission() {
		iMissionService.deleteMission("1");
		Assertions.assertNull(iMissionService.retrieveMission("1"));
		Assertions.assertEquals(0, iMissionService.retrieveAllMissions().size());
	}

}
