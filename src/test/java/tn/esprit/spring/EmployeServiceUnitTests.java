package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
class EmployeServiceUnitTests {

	@Autowired
	IEmployeService iEmployeService;

	@Test
	@Order(1)
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = iEmployeService.retrieveAllEmployes();
		Assertions.assertEquals(listEmployes.size(), listEmployes.size());
	}
	
	@Test
	@Order(2)
	public void testAddEmploye() throws ParseException {
		Employe u = new Employe(1L ,"Nom", "Prenom", "email", true, Role.TECHNICIEN);
		Employe employeAdded = iEmployeService.addEmploye(u);
		Assertions.assertEquals(u.getNom(), employeAdded.getNom());

	}
	
	
	@Test
	@Order(3)
	public void testModifyEmploye() throws ParseException {
		Employe u = new Employe(1L ,"Nom", "Prenom", "email", true, Role.TECHNICIEN);
		Employe employeUpdated = iEmployeService.updateEmploye(u);
		Assertions.assertEquals(u.getNom(), employeUpdated.getNom());
	}

	@Test
	@Order(4)
	public void testDeleteEmploye() {
		iEmployeService.deleteEmploye("1");
		Assertions.assertNull(iEmployeService.retrieveEmploye("1"));
		Assertions.assertEquals(0, iEmployeService.retrieveAllEmployes().size());
	}
}
