package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;

@Service
public class ProductoService {

	public List<Producto> getLista() {
		return Arrays.asList(
				new Producto(),
				new Producto()
				);		
	}
}
