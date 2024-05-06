package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPrueba {

	@GetMapping({"/", "/portada"})
	public String showPortada() {
		return "portada";
	}
	
}
