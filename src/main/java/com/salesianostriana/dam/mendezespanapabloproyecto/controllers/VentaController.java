package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.LineaVentaService;

@Controller
public class VentaController {

	@Autowired
	private LineaVentaService lineaVentaService;
	
	@PostMapping("/venta/addToVenta")
	public String addProductToVenta(@ModelAttribute("lineaVenta") LineaVenta lineaVenta) {
			lineaVentaService.save(lineaVenta);
			return "redirect:/portada";
	}

}
