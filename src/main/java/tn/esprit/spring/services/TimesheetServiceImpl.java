package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService{
	
	@Autowired
	TimesheetRepository timesheetRepository ;
	
	private static final Logger l = LogManager.getLogger(TimesheetServiceImpl.class);


	@Override
	public List<Timesheet> retrieveAllTimesheets() {
		List<Timesheet> timesheets = null;
		try {

			l.info("In Method retrieveAllTimesheets :");
			timesheets = (List<Timesheet>) timesheetRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Timesheet timesheet : timesheets) {
				l.debug("Employee :" + timesheet.getEmploye());
			}
			l.info("Out of Method retrieveAllTimesheets with Success" + timesheets.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllTimesheets with Errors : " + e);
		}

		return timesheets;
	}

	@Override
	public Timesheet addTimesheet(Timesheet u) {
		Timesheet timesheetSaved = null;

		try {
			// TODO Log à ajouter en début de la méthode
			l.info("begin of the addTimesheet method  ");
			timesheetSaved = timesheetRepository.save(u);
			// TODO Log à ajouter à la fin de la méthode
			l.debug(timesheetSaved.getEmploye() + " added successfully");

		} catch (Exception e) {
			// TODO log ici : l....("error in addTimesheet() : " + e);
			l.error("Error in method addTimesheet with Errors : " + e);
		}

		return timesheetSaved;
	}

	@Override
	public void deleteTimesheet(String id) {
		try {
			l.debug("In Method deleteTimesheet() :");
			timesheetRepository.deleteById(Long.parseLong(id));
			l.debug("Out of Method deleteTimesheet() with Success");

		} catch (Exception e) {
			l.error("error in deleteTimesheet() : " + e);
		}		
	}

	@Override
	public Timesheet updateTimesheet(Timesheet u) {
		Timesheet timesheetUpdated = null;

		try {
			l.debug("In Method updateTimesheet() :");
			timesheetUpdated = timesheetRepository.save(u);
			l.debug("Out of Method updateTimesheet() with Success");

		} catch (Exception e) {
			l.error("Out of Method updateTimesheet() with Errors : " + e);
		}

		return timesheetUpdated;
	}

	@Override
	public Timesheet retrieveTimesheet(String id) {
		Timesheet timesheet = null;
		try {
			l.debug("In Method retrieveTimesheet() :");

			timesheet = timesheetRepository.findById(Long.parseLong(id)).isPresent()
					? timesheetRepository.findById(Long.parseLong(id)).get()
					: null;
			l.debug("Out of Method retrieveTimesheet() with Success");

		} catch (Exception e) {
			l.error("error in retrieveTimesheet() : " + e);
		}

		return timesheet;
	}
}


