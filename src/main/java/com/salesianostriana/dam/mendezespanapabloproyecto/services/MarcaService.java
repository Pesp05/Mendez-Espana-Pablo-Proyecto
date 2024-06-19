package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Marca;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.MarcaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class MarcaService extends BaseServiceImpl<Marca, Long, MarcaRepository>{

	public List<Producto> productosAsocMarca(Long id){
		return repository.siHayProductosAsociadosMarca(id);
	}
	
}
