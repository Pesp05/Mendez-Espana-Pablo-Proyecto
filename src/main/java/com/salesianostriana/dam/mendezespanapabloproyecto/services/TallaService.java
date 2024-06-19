package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.TallaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class TallaService extends BaseServiceImpl<Talla, Long, TallaRepository>{

	public List<Producto> hayProductoEnTalla(Long id){
		return repository.siHayProductoEnTalla(id);
	}
	
}
