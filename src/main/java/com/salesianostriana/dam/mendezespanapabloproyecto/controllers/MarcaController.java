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
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Marca;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/lista")
	public String showAdminBrandList(Model model) {
		model.addAttribute("listaMarcasAdmin", marcaService.findAll());
		return "admin/listaAdminMarcas";
	}
	
	@GetMapping("/nuevo")
	public String showNewBrandForm(Model model) {
		model.addAttribute("marca", new Marca());
		return "admin/formularioRegistroMarca";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewBrandForm (@ModelAttribute("marca") Marca marca) {
		marcaService.save(marca);
		return "redirect:/marca/lista";
	}
	
	@GetMapping("/borrar/{id}")
    public String deleteMarca(@PathVariable("id") long id) {
        Optional<Marca> marca = marcaService.findById(id);
        if(marca.isPresent()) {
            marcaService.delete(marca.get());
            return "redirect:/marca/lista";
        } else {
            return "redirect:/marca/lista";
        }
    }
	
}
