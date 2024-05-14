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
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;

@Controller
@RequestMapping("/talla")
public class TallaController {

	@Autowired
	private TallaService tallaService;
	
	@GetMapping("/lista")
	public String showAdminSizeList(Model model) {
		model.addAttribute("listaTallasAdmin", tallaService.findAll());
		return "admin/listaAdminTallas";
	}
	
	@GetMapping("/nuevo")
	public String showNewSizeForm(Model model) {
		model.addAttribute("talla", new Talla());
		return "admin/formularioRegistroTalla";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewSizeForm (@ModelAttribute("marca") Talla talla) {
		tallaService.save(talla);
		return "redirect:/talla/lista";
	}
	
	@GetMapping("/borrar/{id}")
    public String deleteTalla(@PathVariable("id") long id) {
        Optional<Talla> talla = tallaService.findById(id);
        if(talla.isPresent()) {
            tallaService.delete(talla.get());
            return "redirect:/talla/lista";
        } else {
            return "redirect:/talla/lista";
        }
    }
	
}
