package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CompraProductoForm {
	
	private Talla talla;
	private Color color;
	private int cantidad;
	private double subtotal;
	
	@ManyToOne
	private Venta venta;
	
	@ManyToOne
	private Producto producto;

}
