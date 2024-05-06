package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;;

@Controller
public class ProductoController {
	
	private ProductoService productoService;
	
	@GetMapping("/producto/nuevo")
	public String showNewProductForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("productoForm", producto);
		return "formularioRegistroProducto";
	}
	
	@PostMapping("/producto/nuevo/submit")
	public String submit (@ModelAttribute("productoForm") Producto producto, Model model) {
		model.addAttribute("producto", producto);
		return "redirect:/portada";
	}
	
}
