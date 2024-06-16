package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.VentaService;

import ch.qos.logback.core.model.Model;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService ventaService;

	@PostMapping("/carrito/addProducto")
	public String addProductoToVenta(@AuthenticationPrincipal Usuario user, Model model, @PathVariable("idProducto") Long idProducto, int cantidad, Talla talla, Color color) {
		Optional<Venta> optVenta = ventaService.buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			ventaService.addProductoToVenta(cantidad, idProducto, venta.getId(), user, talla, color);
			return "redirect:/carrito";
		} else {
			return "redirect:/portada";
		}
		
	}
	
}
