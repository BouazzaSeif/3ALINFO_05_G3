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
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;

@ExtendWith(MockitoExtension.class)
class ContratServiceUnitTest {

	@Mock
	private ContratRepository contratRepository;

	@Mock
	private DepartementRepository departementtRepository;

	@InjectMocks
	private ContratServiceImpl contratService;

	private Contrat contrat;
	private Departement departement;

	@BeforeEach
	private void setup() throws ParseException {
		contrat = new Contrat();
		contrat.setReference(new Random().nextInt() & Integer.MAX_VALUE);
	}

	@DisplayName("JUnit test for ajouterContrat method")
	@Test
	void testAjouterContrat() {
		given(contratRepository.save(contrat)).willReturn(contrat);
		int idSavedContrat = contratService.ajouterContrat(contrat);
		assertThat(idSavedContrat).isPositive();
	}

}
