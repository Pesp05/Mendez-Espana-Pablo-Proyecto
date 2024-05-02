package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;;

@Controller
public class ProductoController {
	
	@GetMapping("/producto")
	public String showForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("productoForm", producto);
		return "formularioRegistroProducto";
	}
	
	@PostMapping("/addProducto")
	public String submit (@ModelAttribute("productoForm") Producto producto, Model model) {
		model.addAttribute("producto", producto);
		return "view";
	}
	
}
