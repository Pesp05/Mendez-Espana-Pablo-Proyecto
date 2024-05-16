package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.ProductoRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository>{
	
	public List<Producto> buscarPorCategoria(Categoria categoria){
		return repository.productosPorCategoria(categoria);
	}
	
}
