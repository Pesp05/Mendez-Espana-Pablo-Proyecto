package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;

@Controller
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@GetMapping("/admin/color/nuevo")
	public String showNewColorForm(Model model) {
		model.addAttribute("color", new Color());
		return "admin/formularioRegistroColor";
	}
	
	@PostMapping("/admin/color/nuevo/submit")
	public String submitNewColorForm (@ModelAttribute("color") Color color) {
		colorService.save(color);
		return "redirect:/admin/lista/variantes";
	}
	
	@GetMapping("/admin/color/borrar/{id}")
    public String deleteColor(@PathVariable("id") long id) {
        Optional<Color> color = colorService.findById(id);
        if(color.isPresent()) {
        	if(colorService.hayProductoEnColor(id).isEmpty()) {
        		colorService.delete(color.get());
            	return "redirect:/admin/lista/variantes";
        	} else {
        		return "redirect:/admin/lista/variantes?error=true";
        	}
        } else {
        	throw new IllegalArgumentException("Color no encontrado");
        }
    }
	
}
