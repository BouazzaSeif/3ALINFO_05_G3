package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
class EntrepriseServiceUnitTests {

	@Autowired
	IEntrepriseService entrepriseService;


	@Test
	@Order(1)
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = entrepriseService.retrieveAllEntreprises();
		Assertions.assertEquals(listEntreprises.size(), listEntreprises.size());
	}
	
	@Test
	@Order(2)
	public void testAddEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise(1L, "Name", "Raison Social");
		Entreprise entrepriseAdded = entrepriseService.addEntreprise(entreprise);
		Assertions.assertEquals(entreprise.getName(), entrepriseAdded.getName());

	}
	
	
	@Test
	@Order(3)
	public void testModifyEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise(1L, "Name", "Raison Social");
		Entreprise EntrepriseUpdated = entrepriseService.updateEntreprise(entreprise);
		Assertions.assertEquals(entreprise.getName(), EntrepriseUpdated.getName());
	}

	@Test
	@Order(4)
	public void testDeleteEntreprise() {
		entrepriseService.deleteEntreprise("1");
		Assertions.assertNull(entrepriseService.retrieveEntreprise("1"));
		Assertions.assertEquals(0, entrepriseService.retrieveAllEntreprises().size());
	}

}
