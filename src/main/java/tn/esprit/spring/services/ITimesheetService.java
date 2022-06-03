package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Timesheet;

public interface ITimesheetService  {
	
	List<Timesheet> retrieveAllTimesheets();

	Timesheet addTimesheet(Timesheet u);

	void deleteTimesheet(String id);

	Timesheet updateTimesheet(Timesheet u);

	Timesheet retrieveTimesheet(String id);

}
