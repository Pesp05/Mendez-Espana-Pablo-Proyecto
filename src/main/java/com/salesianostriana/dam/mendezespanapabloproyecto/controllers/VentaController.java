package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.CompraProducto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService ventaService;

	@PostMapping("/carrito/addProducto")
	public String addProductoToVenta(@AuthenticationPrincipal Usuario user, @ModelAttribute("compraProducto") CompraProducto compraProducto) {
		int cantidad = compraProducto.getCantidad();
		Long idProducto = compraProducto.getIdProducto();
		Long idTalla = compraProducto.getIdTalla();
		Long idColor = compraProducto.getIdColor();
		Optional<Venta> optVenta = ventaService.buscarVentaNotFinished(user);
		Venta venta = optVenta.orElseGet(() -> ventaService.crearVenta(user));
		ventaService.addProductoToVenta(cantidad, idProducto, user, idTalla, idColor, venta);
		return "redirect:/carrito/vista";
		
	}
	
	@GetMapping("/carrito/vista")
	public String showCarrito(@AuthenticationPrincipal Usuario user, Model model) {
		Optional<Venta> optVenta = ventaService.buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			List<LineaVenta> lineasVenta = venta.getListaLineasVenta();
			model.addAttribute("venta", venta);
			model.addAttribute("listaLineasVenta", lineasVenta);
			return "carrito";
		} else {
			return "carrito";
		}
		
	}
	
	
	@GetMapping("/carrito/borrarLineaVenta/{id}")
	public String deleteLineaVenta(@PathVariable("id") Long idLineaVenta, @AuthenticationPrincipal Usuario user) {
		ventaService.removeProductoFromVenta(user, idLineaVenta);
		return "redirect:/carrito/vista";
	}
	
}
