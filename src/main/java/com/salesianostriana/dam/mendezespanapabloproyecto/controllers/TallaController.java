package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;

@Controller
public class TallaController {

	@Autowired
	private TallaService tallaService;
	
	@GetMapping("/admin/talla/nuevo")
	public String showNewSizeForm(Model model) {
		model.addAttribute("talla", new Talla());
		return "admin/formularioRegistroTalla";
	}
	
	@PostMapping("/admin/talla/nuevo/submit")
	public String submitNewSizeForm (@ModelAttribute("talla") Talla talla) {
		tallaService.save(talla);
		return "redirect:/admin/lista/variantes";
	}
	
	@GetMapping("/admin/talla/borrar/{id}")
    public String deleteTalla(@PathVariable("id") long id) {
        Optional<Talla> talla = tallaService.findById(id);
        if(talla.isPresent()) {
            tallaService.delete(talla.get());
            return "redirect:/admin/lista/variantes";
        } else {
            return "redirect:/admin/lista/variantes";
        }
    }
	
}
