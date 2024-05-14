package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;

@Controller
@RequestMapping("/color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@GetMapping("/lista")
	public String showAdminColorList(Model model) {
		model.addAttribute("listaColoresAdmin", colorService.findAll());
		return "admin/listaAdminColores";
	}
	
	@GetMapping("/nuevo")
	public String showNewColorForm(Model model) {
		model.addAttribute("color", new Color());
		return "admin/formularioRegistroTalla";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewColorForm (@ModelAttribute("color") Color color) {
		colorService.save(color);
		return "redirect:/color/lista";
	}
	
	@GetMapping("/borrar/{id}")
    public String deleteColor(@PathVariable("id") long id) {
        Optional<Color> color = colorService.findById(id);
        if(color.isPresent()) {
            colorService.delete(color.get());
            return "redirect:/color/lista";
        } else {
            return "redirect:/color/lista";
        }
    }
	
}
