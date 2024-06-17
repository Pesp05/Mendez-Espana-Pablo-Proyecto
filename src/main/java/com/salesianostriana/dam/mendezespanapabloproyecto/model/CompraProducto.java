package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class CompraProducto {

	private Long idProducto;
	private Long idTalla;
	private Long idColor;
	private int cantidad;

	//Helper
	public void addProductoToCompraProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
}
