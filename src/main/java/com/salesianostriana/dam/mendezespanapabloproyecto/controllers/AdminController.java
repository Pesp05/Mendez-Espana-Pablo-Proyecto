package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private TallaService tallaService;
	
	@Autowired
	private ColorService colorService;

	@GetMapping("/menu")
	public String showAdminMenu() {
		return "admin/adminMenu";
	}
	
	@GetMapping("/lista/producto")
	public String showAdminProductList(Model model) {
		model.addAttribute("listaProductosAdmin", productoService.findAll());
		return "admin/listaAdminProductos";
	}
	
	@GetMapping("/lista/variantes")
	public String showAdminBrandList(Model model) {
		model.addAttribute("listaMarcasAdmin", marcaService.findAll());
		model.addAttribute("listaTallasAdmin", tallaService.findAll());
		model.addAttribute("listaColoresAdmin", colorService.findAll());
		return "admin/listaAdminVariantes";
	}
	
}
