package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.mendezespanapabloproyecto.services.ProductoService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LineaVenta {
	
	@Autowired
	ProductoService productoService;
	
	@Id
	@GeneratedValue
	private Long id;

	private CompraProductoForm productoCompra;
	private double subTotal;
	
}
