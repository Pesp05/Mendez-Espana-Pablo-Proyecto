package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.CompraProductoForm;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.VentaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository>{

	public void addLineaVenta(CompraProductoForm lineaVenta, Long idVenta) {
		Optional<Venta> c = this.findById(idVenta);
		if(c.isPresent()) {
			Venta carr = c.get();
			carr.getListaLineasVenta().add(lineaVenta);
			this.repository.save(carr);
		}
	}
	
}
