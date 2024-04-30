package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
}
