package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
public class TimesheetServiceTest {

	@Autowired
	ITimesheetService iTimesheetService;
	
	
	@Test
	@Order(1)
	public void testRetrieveAllTimesheets() {
		List<Timesheet> listTimesheets = iTimesheetService.retrieveAllTimesheets();
		Assertions.assertEquals(listTimesheets.size(), listTimesheets.size());
	}

	@Test
	@Order(2)
	public void testAddTimesheet() throws ParseException {
		Timesheet t = new Timesheet("Hamza", "Kaabi");
		Timesheet TimesheetAdded = iTimesheetService.addTimesheet(t);
		Assertions.assertEquals(t.getEmploye(), TimesheetAdded.getEmploye());

	}

	@Test
	@Order(3)
	public void testModifyTimesheet() throws ParseException {
		Timesheet t = new Timesheet(1L, "Hamza2", "Kaabi2");
		Timesheet timesheetUpdated = iTimesheetService.updateTimesheet(t);
		Assertions.assertEquals(t.getEmploye(), timesheetUpdated.getEmploye());
	}

	@Test
	@Order(4)
	public void testDeleteTimesheet() {
		iTimesheetService.deleteTimesheet("1");
		Assertions.assertNull(iTimesheetService.retrieveTimesheet("1"));
		Assertions.assertEquals(0, iTimesheetService.retrieveAllTimesheets().size());
	}
	
}
