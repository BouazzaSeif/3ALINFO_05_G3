package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.IDepartementService;

@SpringBootTest
class DepartementServiceUnitTests {

	@Autowired
	IDepartementService departementService;

	@Test
	@Order(1)
	public void testRetrieveAllDepartements() {
		List<Departement> listDepartements = departementService.retrieveAllDepartements();
		Assertions.assertEquals(listDepartements.size(), listDepartements.size());
	}
	
	@Test
	@Order(2)
	public void testAddDepartement() throws ParseException {
		Departement u = new Departement(1 ,"Name", "Etage");
		Departement departementAdded = departementService.addDepartement(u);
		Assertions.assertEquals(u.getName(), departementAdded.getName());

	}
	
	
	@Test
	@Order(3)
	public void testModifyDepartement() throws ParseException {
		Departement u = new Departement(1 ,"Name", "Etage");
		Departement departementAdded = departementService.updateDepartement(u);
		Assertions.assertEquals(u.getName(), departementAdded.getName());
	}

	@Test
	@Order(4)
	public void testDeleteDepartement() {
		departementService.deleteDepartement("1");
		Assertions.assertNull(departementService.retrieveDepartement("1"));
		Assertions.assertEquals(1, departementService.retrieveAllDepartements().size());
	}

}
