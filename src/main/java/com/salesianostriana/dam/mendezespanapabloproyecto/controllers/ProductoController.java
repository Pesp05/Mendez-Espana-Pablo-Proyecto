package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/producto/lista")
	public String showAdminProductList(Model model) {
		model.addAttribute("listaProductosAdmin", productoService.findAll());
		return "admin/listaAdminProductos";
	}
	
	@GetMapping("/producto/nuevo")
	public String showNewProductForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "admin/formularioRegistroProducto";
	}
	
	@PostMapping("/producto/nuevo/submit")
	public String submitNewProductoForm (@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/producto/lista";
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
	public String submitEditProductForm(@ModelAttribute("producto") Producto producto) {
		productoService.edit(producto);
		return "redirect:/producto/nuevo";
	}
	
}
