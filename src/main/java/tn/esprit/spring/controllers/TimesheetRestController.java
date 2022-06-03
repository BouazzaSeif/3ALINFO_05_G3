package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class TimesheetRestController {

	@Autowired
	ITimesheetService timesheetService;
	
	
	// URL : http://localhost:????/????/retrieve-all-Timesheets
		@GetMapping("/retrieve-all-timesheets")
		public List<Timesheet> retrieveAllTimesheets() {
			List<Timesheet> list = timesheetService.retrieveAllTimesheets();
			return list;
		}

		// http://localhost:????/timesheet-devops/retrieve-Timesheet/{Timesheet-id}
		@GetMapping("/retrieve-timesheet/{timesheet-id}")
		public Timesheet retrieveTimesheet(@PathVariable("Timesheet-id") String TimesheetId) {
			return timesheetService.retrieveTimesheet(TimesheetId);
		}

		// Ajouter Timesheet : http://localhost:????/timesheet-devops/add-Timesheet
		@PostMapping("/add-timesheet")
		public Timesheet addTimesheet(@RequestBody Timesheet u) {
			Timesheet Timesheet = timesheetService.addTimesheet(u);
			return Timesheet;
		}

		// Supprimer Timesheet :
		// http://localhost:????/timesheet-devops/remove-Timesheet/{Timesheet-id}
		@DeleteMapping("/remove-timesheet/{timesheet-id}")
		public void removeTimesheet(@PathVariable("Timesheet-id") String TimesheetId) {
			timesheetService.deleteTimesheet(TimesheetId);
		}

		// Modifier Timesheet
		// http://localhost:????/timesheet-devops/modify-Timesheet
		@PutMapping("/modify-timesheet")
		public Timesheet updateTimesheet(@RequestBody Timesheet Timesheet) {
			return timesheetService.updateTimesheet(Timesheet);
		}
	
}
