package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeServiceUnitTests {

	@Mock
	private EmployeRepository employeRepository;

	@Mock
	private ContratRepository contratRepository;

	@InjectMocks
	private EmployeServiceImpl employeService;

	private Employe employe;
	private Contrat contrat;

	@BeforeEach
	private void setup() throws ParseException {
		employe = new Employe("Bouazza", "Seif", "seifeddine.bouazza@esprit.tn", true, Role.INGENIEUR);
		employe.setId(new Random().nextInt() & Integer.MAX_VALUE);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		contrat = new Contrat(sdf.parse("11-10-2015"), "CDI", 2800f);
		contrat.setReference(new Random().nextInt() & Integer.MAX_VALUE);
	}

	@DisplayName("JUnit test for ajouterEmploye method")
	@Test
	void testAjouterEmploye() {
		given(employeRepository.save(employe)).willReturn(employe);
		int idSavedEmployee = employeService.ajouterEmploye(employe);
		assertThat(idSavedEmployee).isPositive();
	}

	@DisplayName("JUnit test for mettreAjourEmailByEmployeId method")
	@Test
	void testMettreAjourEmailByEmployeId() {
		given(employeRepository.findById(employe.getId())).willReturn(Optional.of(employe));
		String newEmail = "newemail@gmail.com";
		given(employeRepository.save(employe)).willReturn(employe);
		employeService.mettreAjourEmailByEmployeId(newEmail, employe.getId());
		assertThat(employe.getEmail()).isEqualTo(newEmail);
	}

	@DisplayName("JUnit test for ajouterContrat method")
	@Test
	void testAjouterContrat() {
		given(contratRepository.save(contrat)).willReturn(contrat);
		int refContrat = employeService.ajouterContrat(contrat);
		assertThat(refContrat).isPositive();
	}
}
