package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Timesheet;


@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
	
}
