package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
class EntrepriseServiceUnitTests {

	@Mock
	private EntrepriseRepository entrepriseRepository;

	@Mock
	private DepartementRepository departementtRepository;

	@InjectMocks
	private EntrepriseServiceImpl entrepriseService;

	private Entreprise entreprise;
	private Departement departement;

	@BeforeEach
	private void setup() throws ParseException {
		entreprise = new Entreprise("Esprit", "example");
		entreprise.setId(new Random().nextInt() & Integer.MAX_VALUE);
	}

	@DisplayName("JUnit test for ajouterEntreprise method")
	@Test
	void testAjouterEntreprise() {
		given(entrepriseRepository.save(entreprise)).willReturn(entreprise);
		int idSavedEntreprisee = entrepriseService.ajouterEntreprise(entreprise);
		assertThat(idSavedEntreprisee).isPositive();
	}

	
}
