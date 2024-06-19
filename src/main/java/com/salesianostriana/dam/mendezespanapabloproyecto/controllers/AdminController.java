package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.UsuarioService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.VentaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private TallaService tallaService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VentaService ventaService;

	@GetMapping("/menu")
	public String showAdminMenu() {
		return "admin/adminMenu";
	}
	
	@GetMapping("/lista/producto")
	public String showAdminProductList(Model model) {
		model.addAttribute("listaProductosAdmin", productoService.findAll());
		return "admin/listaAdminProductos";
	}
	
	@GetMapping("/lista/variantes")
	public String showAdminBrandList(Model model) {
		model.addAttribute("listaMarcasAdmin", marcaService.findAll());
		model.addAttribute("listaTallasAdmin", tallaService.findAll());
		model.addAttribute("listaColoresAdmin", colorService.findAll());
		return "admin/listaAdminVariantes";
	}
	
	@GetMapping("/lista/users")
	public String showAllUsers(Model model) {
		List<Usuario> listaUsuarios = usuarioService.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "admin/listaUsuariosAdmin";
	}
	
	@GetMapping("/ventas/user/{id}")
	public String showVentasFromUser(@PathVariable("id") Long id, Model model) {
		Optional<Usuario> optUser = usuarioService.findById(id);
		if(optUser.isPresent()) {
			Usuario user = optUser.get();
			List<Venta> listaVentasUser = user.getVentas();
			model.addAttribute("listaVentasUser", listaVentasUser);
			model.addAttribute("usuario", user);
			return "admin/ventasUserAdmin";
		} else {
			throw new IllegalArgumentException("No se encuentra el usuario");
		}
	}
	
	@GetMapping("/venta/ver/detalles/{id}")
	public String showDetailedVenta(@PathVariable("id") Long id, Model model) {
		Optional<Venta> optVenta = ventaService.findById(id);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			Usuario user = venta.getUsuario();
			List<LineaVenta> listaLineasVenta = venta.getListaLineasVenta();
			model.addAttribute("venta", venta);
			model.addAttribute("usuario", user);
			model.addAttribute("listaLineasVenta", listaLineasVenta);
			return "admin/detallesVentaAdmin";
		} else {
			throw new IllegalArgumentException("no se encuentra la venta");
		}
	}
	
}
