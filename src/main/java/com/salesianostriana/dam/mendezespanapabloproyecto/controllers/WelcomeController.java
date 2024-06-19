package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;

@Controller
public class WelcomeController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping({"/", "/portada"})
	public String showPortada(Model model) {
		List<Producto> listaMasBaratos = productoService.buscar6MasBaratos();
		model.addAttribute("listaMasBaratos", listaMasBaratos);
		return "portada";
	}
	
	@GetMapping("/error")
	public String showError() {
		return "error";
	}
	
	@GetMapping("/quienessomos")
	public String showInfo() {
		return "negocioInfo";
	}
	
}
