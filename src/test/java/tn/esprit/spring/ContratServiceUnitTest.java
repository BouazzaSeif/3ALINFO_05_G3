package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@SpringBootTest
class ContratServiceUnitTest {

	@Autowired
	IContratService iContratService;

	@Test
	@Order(1)
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = iContratService.retrieveAllContrats();
		Assertions.assertEquals(listContrats.size(), listContrats.size());
	}

	@Test
	@Order(2)
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat u = new Contrat(d,"Contrat 1", 1);
		Contrat ContratAdded = iContratService.addContrat(u);
		Assertions.assertEquals(u.getReference(), ContratAdded.getReference());

	}

	@Test
	@Order(3)
	public void testModifyContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat u = new Contrat(d,"Contrat 1", 1);
		Contrat ContratUpdated = iContratService.updateContrat(u);
		Assertions.assertEquals(u.getReference(), ContratUpdated.getReference());
	}

	@Test
	@Order(4)
	public void testDeleteContrat() {
		iContratService.deleteContrat("1");
		Assertions.assertNull(iContratService.retrieveContrat("1"));
		Assertions.assertEquals(0, iContratService.retrieveAllContrats().size());
	}
}
