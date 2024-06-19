package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.ColorRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class ColorService extends BaseServiceImpl<Color, Long, ColorRepository>{
	
	public List<Producto> hayProductoEnColor(Long id){
		return repository.siHayProductoEnColor(id);
	}
	
}
