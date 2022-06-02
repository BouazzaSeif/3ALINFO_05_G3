package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.MissionServiceImpl;

@ExtendWith(MockitoExtension.class)
class MissionServiceUnitTests {

	@Mock
	private MissionRepository missionRepository;

	@Mock
	private DepartementRepository departementtRepository;

	@InjectMocks
	private MissionServiceImpl missionService;

	private Mission mission;
	private Departement departement;

	@BeforeEach
	private void setup() throws ParseException {
		mission = new Mission("Mission1", "example");
		mission.setId(new Random().nextInt() & Integer.MAX_VALUE);
	}

	@DisplayName("JUnit test for ajouterMission method")
	@Test
	void testAjouterMission() {
		given(missionRepository.save(mission)).willReturn(mission);
		int idSavedmission = missionService.addMission(mission).getId();
		assertThat(idSavedmission).isPositive();
	}

}
