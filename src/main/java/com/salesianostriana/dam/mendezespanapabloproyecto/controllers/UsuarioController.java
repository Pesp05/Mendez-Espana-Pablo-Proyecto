package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/nuevo")
	public String showNewUserForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "formularioRegistroUsuario";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewUserForm(@ModelAttribute("usuario") Usuario usuario) {
		Optional<Usuario> existingUser = usuarioService.findIfUsernameExists(usuario.getUsername());
		if(existingUser.isEmpty()) {
			usuarioService.save(usuario);
			return "redirect:/login";
		} else {
			return "redirect:/usuario/nuevo?error=true";
		}
	}
	
	@GetMapping("/editar")
	public String editUser(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}
	
	@PostMapping("/editar/submit")
	public String submitEditUserById(@ModelAttribute("usuario") Usuario usuario) {
		Optional<Usuario> existingUser = usuarioService.findIfUsernameExists(usuario.getUsername());
		if(existingUser.isEmpty()) {
			usuarioService.edit(usuario);
			return "redirect:/usuario/perfil";
		} else {
			return "redirect:/usuario/editar?error=true";
		}
		
	}
	
	@GetMapping("/perfil")
	public String viewUserProfile(@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "user/vistaPerfil";
	}
	
}
