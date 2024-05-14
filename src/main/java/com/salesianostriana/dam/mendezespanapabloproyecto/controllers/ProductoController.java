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

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
    private MarcaService marcaService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private TallaService tallaService;
	
	@GetMapping("/lista")
	public String showAdminProductList(Model model) {
		model.addAttribute("listaProductosAdmin", productoService.findAll());
		return "admin/listaAdminProductos";
	}
	
	@GetMapping("/nuevo")
	public String showNewProductForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("colores", colorService.findAll());
        model.addAttribute("tallas", tallaService.findAll());
		return "admin/formularioRegistroProducto";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNewProductoForm (@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String showEditProductForm(@PathVariable("id") long id, Model model) {
		Optional<Producto> aEditar = productoService.findById(id);
		if(aEditar.isPresent()) {
			Producto producto = aEditar.get();
			model.addAttribute("producto", producto);
			model.addAttribute("marcas", marcaService.findAll());
	        model.addAttribute("colores", colorService.findAll());
	        model.addAttribute("tallas", tallaService.findAll());
			return "admin/formularioRegistroProducto";
		} else {
			return "redirect:/producto/nuevo";
		}
	}
	
	@PostMapping("/editar/submit")
	public String submitEditProductForm(@ModelAttribute("producto") Producto producto) {
		productoService.edit(producto);
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/borrar/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        Optional<Producto> producto = productoService.findById(id);
        if(producto.isPresent()) {
            productoService.delete(producto.get());
            return "redirect:/producto/lista";
        } else {
            return "redirect:/producto/lista";
        }
    }
}
