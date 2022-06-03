package tn.esprit.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import tn.esprit.spring.services.IDepartementService;


@Controller
public class IControllerDepartementImpl {
	@Autowired
	IDepartementService idepartementservice;

}
