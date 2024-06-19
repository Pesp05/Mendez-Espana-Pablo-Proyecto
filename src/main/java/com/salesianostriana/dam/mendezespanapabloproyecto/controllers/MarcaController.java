package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Marca;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;

@Controller
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/admin/marca/nuevo")
	public String showNewBrandForm(Model model) {
		model.addAttribute("marca", new Marca());
		return "admin/formularioRegistroMarca";
	}
	
	@PostMapping("/admin/marca/nuevo/submit")
	public String submitNewBrandForm (@ModelAttribute("marca") Marca marca) {
		marcaService.save(marca);
		return "redirect:/admin/lista/variantes";
	}
	
	@GetMapping("/admin/marca/borrar/{id}")
    public String deleteMarca(@PathVariable("id") long id) {
        Optional<Marca> marca = marcaService.findById(id);
        if(marca.isPresent()) {
        	if(marcaService.productosAsocMarca(id).isEmpty()) {
        		marcaService.delete(marca.get());
            	return "redirect:/admin/lista/variantes";
        	} else {
        		return "redirect:/admin/lista/variantes?error=true";
        	}
        } else {
            throw new IllegalArgumentException("Marca no encontrada");
        }
    }
	
}
