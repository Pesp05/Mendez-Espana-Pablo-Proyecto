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
		model.addAttribute("producto", producto);
		return "admin/formularioRegistroProducto";
	}
	
	@PostMapping("/producto/nuevo/submit")
	public String submitNewProductoForm (@ModelAttribute("productoForm") Producto producto, Model model) {
		productoService.save(producto);
		return "redirect:admin/producto/nuevo";
	}
	
	@GetMapping("/producto/editar/{id}")
	public String showEditProductForm(@PathVariable("id") long id, Model model) {
		Optional<Producto> aEditar = productoService.findById(id);
		if(aEditar.isPresent()) {
			model.addAttribute(aEditar);
			return "admin/formularioRegistroProducto";
		} else {
			return "redirect:/producto/nuevo";
		}
	}
	
	@PostMapping("/producto/editar/submit")
	public String submitEditProductForm(@ModelAttribute("producto") Producto producto, Model model) {
		productoService.edit(producto);
		return "redirect:/producto/nuevo";
	}
	
}
