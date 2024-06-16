package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.VentaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository>{

	@Autowired
	private ProductoService productoService;
	
	public void addProductoToVenta(int cantidad, Long idProducto, Long idVenta, @AuthenticationPrincipal Usuario user, Talla talla, Color color) {
		Optional<Venta> optVenta = this.buscarVentaNotFinished(user);
		Venta venta = optVenta.orElseGet(() -> crearVenta(user));
		Optional<Producto> optProducto = productoService.findById(idProducto);
		if(optProducto.isPresent()) {
			Producto producto = optProducto.get();
			Optional<LineaVenta> optLineaVenta = venta.getListaLineasVenta()
													  .stream()
													  .filter(lineaVenta -> lineaVenta.getProducto()
															  						  .getId()
													  								  .equals(idProducto))
													  .filter(lineaVenta -> lineaVenta.getColor()
															  						  .equals(color))
													  .filter(lineaVenta -> lineaVenta.getTalla()
															  						  .equals(talla))
													  .findFirst();
			
			if(optLineaVenta.isPresent()) {
				LineaVenta lv = optLineaVenta.get();
				lv.setCantidad(lv.getCantidad()+cantidad);
				repository.save(venta);
			} else {
				LineaVenta nuevaLineaVenta = crearLineaVenta(producto, talla, color, cantidad, venta);
				venta.getListaLineasVenta().add(nuevaLineaVenta);
				repository.save(venta);
			}
			
		} else {
			throw new IllegalArgumentException("No se encuentra el producto");
		}
		
	}
	
	public Venta crearVenta(@AuthenticationPrincipal Usuario user) {
		Venta nuevaVenta = Venta.builder()
								.usuario(user)
								.listaLineasVenta(new ArrayList<>())
								.isFinished(false)
								.build();
		this.save(nuevaVenta);
		return nuevaVenta;							
	}
	
	public LineaVenta crearLineaVenta(Producto producto, Talla talla, Color color, int cantidad, Venta venta) {
		LineaVenta nuevaLineaVenta = LineaVenta.builder()
											   .cantidad(cantidad)
											   .color(color)
											   .talla(talla)
											   .producto(producto)
											   .venta(venta)
											   .build();
		return nuevaLineaVenta;
	}
	
	public Optional<Venta> buscarVentaNotFinished(@AuthenticationPrincipal Usuario user) {
		 return repository.findVentaNotFinished(user);
	}
	
}
