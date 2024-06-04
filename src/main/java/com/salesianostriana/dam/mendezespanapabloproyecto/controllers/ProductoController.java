package com.salesianostriana.dam.mendezespanapabloproyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ColorService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.MarcaService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.TallaService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
    private MarcaService marcaService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private TallaService tallaService;
    

    @GetMapping("/producto/{id}")
    public String showDetailedProduct(@PathVariable("id") long id, Model model) {
    	Optional<Producto> aMostrar = productoService.findById(id);
    	if(aMostrar.isPresent()) {
    		Producto producto = aMostrar.get();
    		List<Color> coloresDisponibles = productoService.buscarColoresDisponibles(id);
    		List<Talla> tallasDisponibles = productoService.buscarTallasDisponibles(id);
    		model.addAttribute("producto", producto);
    		model.addAttribute("colores", coloresDisponibles);
    		model.addAttribute("tallas", tallasDisponibles);
    		return "vistaProductosDetallada";
    	} else {
    		return "vistaProductosDetallada";
    	}
    }
    
    @GetMapping("/producto/vista/{categoria}")
    public String showProductsByCategory(@PathVariable("categoria") String categoria, Model model) {
    	Categoria c = Categoria.valueOf(categoria.toUpperCase());
    	model.addAttribute("productos", productoService.buscarPorCategoria(c));
    	return "vistaProductosGeneral";
    }
    
    @GetMapping("/producto/search")
    public String showProductsByName(@RequestParam("nombre") String nombre, Model model) {
    	model.addAttribute("productos", productoService.buscarPorNombre(nombre));
    	return "vistaProductosGeneral";
    }
	
	@GetMapping("/admin/producto/nuevo")
	public String showNewProductForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("colores", colorService.findAll());
        model.addAttribute("tallas", tallaService.findAll());
		return "admin/formularioRegistroProducto";
	}
	
	@PostMapping("/admin/producto/nuevo/submit")
	public String submitNewProductoForm (@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/admin/lista/producto";
	}
	
	@GetMapping("/admin/producto/editar/{id}")
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
			return "redirect:/admin/lista/producto";
		}
	}
	
	@PostMapping("/admin/producto/editar/submit")
	public String submitEditProductForm(@ModelAttribute("producto") Producto producto) {
		productoService.edit(producto);
		return "redirect:/admin/lista/producto";
	}
	
	@GetMapping("/admin/producto/borrar/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        Optional<Producto> producto = productoService.findById(id);
        if(producto.isPresent()) {
            productoService.delete(producto.get());
            return "redirect:/admin/lista/producto";
        } else {
            return "redirect:/admin/lista/producto";
        }
    }
}