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

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	/*
	@GetMapping("/{id}")
	public String showUserAccount(@PathVariable("id") long id, Model model) {
		
	}
	*/
	@GetMapping("/nuevo")
	public String showNewUserForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "formularioRegistroUsuario";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewUserForm(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/login";
	}
	
	@GetMapping("/editar/{id}")
	public String editUserById(@PathVariable("id") long id, Model model) {
		Optional<Usuario> aEditar = usuarioService.findById(id);
		if(aEditar.isPresent()) {
			Usuario usuario = aEditar.get();
			model.addAttribute("usuario", usuario);
			return "formularioRegistroUsuario";
		} else {
			return "redirect:/portada";
		}
	}
	
	@PostMapping("/editar/submit")
	public String submitEditUserById(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.edit(usuario);
		return "redirect:/portada";
	}
	
}
