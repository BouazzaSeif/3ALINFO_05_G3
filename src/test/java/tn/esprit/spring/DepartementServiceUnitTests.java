package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
class DepartementServiceUnitTests {

	@Mock
	private DepartementRepository DepartementRepository;

	

	@InjectMocks
	private DepartementServiceImpl DepartementService;

	private Departement departement;
	@DisplayName("JUnit test for ajouter departement method")
	@Test
	void testAjouterDepartement() {
		given(DepartementRepository.save(departement)).willReturn(departement);
		int idep = DepartementService.ajouterDepartement(departement);
		assertThat(idep).isPositive();
	}
}
