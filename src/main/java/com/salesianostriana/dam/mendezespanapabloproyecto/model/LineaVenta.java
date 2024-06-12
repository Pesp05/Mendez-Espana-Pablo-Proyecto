package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LineaVenta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Talla talla;
	
	@ManyToOne
	private Color color;
	
	private int cantidad;
	private double subTotal;
	
	@ManyToOne
	private Venta venta;
	
	@ManyToOne
	private Producto producto;

	
	//Helpers
	public void addToLineaVenta(Producto producto) {
		this.producto = producto;
		producto.getLineasVenta().add(this);
	}
	
	public void removeFromLineaVenta(Producto producto) {
		producto.getLineasVenta().remove(this);
		this.producto = null;		
	}
	
}
