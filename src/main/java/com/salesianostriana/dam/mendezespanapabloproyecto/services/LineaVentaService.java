package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.LineaVentaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class LineaVentaService extends BaseServiceImpl<LineaVenta, Long, LineaVentaRepository>{

	public void calcularSubtotal(Long id) {
		Optional<LineaVenta> opLv = this.repository.findById(id);
		if(opLv.isPresent()) {
			LineaVenta lv = opLv.get();
			double precioVenta = lv.getProducto().getPrecioVenta();
			int cantidad = lv.getCantidad();
			lv.setSubtotal(cantidad*precioVenta);	
		}
		
	}
	
}
