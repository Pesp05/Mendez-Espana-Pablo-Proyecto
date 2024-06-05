package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CompraProductoForm {
	
	private long idProducto;
	private Talla talla;
	private Color color;
	private int cantidad;
	
	

}
