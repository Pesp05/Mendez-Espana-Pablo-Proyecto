package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.ProductoRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository>{
	
	public List<Producto> buscarPorCategoria(Categoria categoria){
		return repository.productosPorCategoria(categoria);
	}
	
	public List<Producto> buscarPorNombre(String nombre){
		return repository.productosPorNombre(nombre);
	}
	
	public List<Color> buscarColoresDisponibles(Long id){
		return repository.coloresPorIdProducto(id);
	}
	
	public List<Talla> buscarTallasDisponibles(Long id){
		return repository.tallasPorIdProducto(id);
	}
	
	public List<LineaVenta> buscarSiProductoEnLineaVenta(Long id){
		return repository.siProductoEnLineaDeVenta(id);
	}
	
	public List<Producto> buscar6MasBaratos(){
		return repository.buscar6MasBaratos();
	}
	
	public List<Producto> buscar3MasVendidos(){
		return repository.buscar3MasVendidos();
	}
	
	public Usuario buscarBestUser() {
		return repository.bestUser();
	}
	
}
