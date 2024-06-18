package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import java.util.ArrayList;
import java.util.List;
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
	
	@Autowired
	private TallaService tallaService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private LineaVentaService lineaVentaService;
	
	
	public void addProductoToVenta(int cantidad, Long idProducto, @AuthenticationPrincipal Usuario user, Long idTalla, Long idColor, Venta venta) {
		Optional<Producto> optProducto = productoService.findById(idProducto);
		if(optProducto.isPresent()) {
			Producto producto = optProducto.get();
			Optional<LineaVenta> optLineaVenta = venta.getListaLineasVenta()
													  .stream()
													  .filter(lineaVenta -> lineaVenta.getProducto()
															  						  .getId()
													  								  .equals(idProducto))
													  .filter(lineaVenta -> lineaVenta.getColor()
															  						  .getId()
															  						  .equals(idColor))
													  .filter(lineaVenta -> lineaVenta.getTalla()
															  						  .getId()
															  						  .equals(idTalla))
													  .findFirst();
			
			if(optLineaVenta.isPresent()) {
				LineaVenta lv = optLineaVenta.get();
				lv.setCantidad(lv.getCantidad()+cantidad);
				lv.setSubTotal(lv.calcularSubtotal());
				repository.save(venta);
			} else {
				Optional<Talla> optTalla = tallaService.findById(idTalla);
				Optional<Color> optColor = colorService.findById(idColor);
				if(optColor.isPresent() && optTalla.isPresent()) {
					Talla talla = optTalla.get();
					Color color = optColor.get();
					LineaVenta nuevaLineaVenta = crearLineaVenta(producto, talla, color, cantidad, venta);
					nuevaLineaVenta.setSubTotal(nuevaLineaVenta.calcularSubtotal());
					venta.getListaLineasVenta().add(nuevaLineaVenta);
					venta.getListaLineasVenta().forEach(lineaVenta -> {
					    lineaVenta.setVenta(venta);
					    lineaVentaService.save(nuevaLineaVenta);
					});

					repository.save(venta);
				} else {
					throw new IllegalArgumentException("No se encuentran la talla o el color");
				}
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
	
	public void removeProductoFromVenta(@AuthenticationPrincipal Usuario user, Long idLineaVenta) {
		Optional<Venta> optVenta = buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			Optional<LineaVenta> optLineaVenta = venta.getListaLineasVenta()
					  .stream()
					  .filter(lineaVenta -> lineaVenta.getId()
							  						  .equals(idLineaVenta))
					  .findFirst();

			if(optLineaVenta.isPresent()) {
				LineaVenta lv = optLineaVenta.get();
				venta.getListaLineasVenta().remove(lv);
				lineaVentaService.delete(lv);
			}
			repository.save(venta);
		}
	}
	
	public void sumarCantidadLineaVenta(@AuthenticationPrincipal Usuario user, Long idLineaVenta) {
		Optional<Venta> optVenta = buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			Optional<LineaVenta> optLineaVenta = lineaVentaService.findById(idLineaVenta);
			
			if(optLineaVenta.isPresent()) {
				LineaVenta lv = optLineaVenta.get();
				lv.setCantidad(lv.getCantidad()+1);
				lv.setSubTotal(lv.calcularSubtotal());
			}
			repository.save(venta);
			
		}
	}
	
	public void restarCantidadLineaVenta(@AuthenticationPrincipal Usuario user, Long idLineaVenta) {
		Optional<Venta> optVenta = buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			Optional<LineaVenta> optLineaVenta = lineaVentaService.findById(idLineaVenta);
			
			if(optLineaVenta.isPresent()) {
				LineaVenta lv = optLineaVenta.get();
				lv.setCantidad(lv.getCantidad()-1);
				lv.setSubTotal(lv.calcularSubtotal());
				if(lv.getCantidad() <= 0) {
					this.removeProductoFromVenta(user, idLineaVenta);
				}
			}
			repository.save(venta);
			
		}
	}
	
	public List<Venta> findAllUserFinishedVentas(@AuthenticationPrincipal Usuario user){
		return repository.findFinishedVentas(user);
	}
	
	public void calcularPrecioTotalVenta(@AuthenticationPrincipal Usuario user) {
		Optional<Venta> optVenta = this.buscarVentaNotFinished(user);
		if(optVenta.isPresent()) {
			Venta venta = optVenta.get();
			double precioTotal = 0;
			for (LineaVenta lineaVenta : venta.getListaLineasVenta()) {
				precioTotal = precioTotal+lineaVenta.getSubTotal();
			}
			venta.setPrecioTotal(precioTotal);
			repository.save(venta);
			
		} else {
			throw new IllegalArgumentException("Venta no encontrada");
		}
	}
	
}
