package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
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
}
