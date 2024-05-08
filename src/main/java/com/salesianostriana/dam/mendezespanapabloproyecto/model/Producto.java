package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Producto {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private double precioVenta;
	private double precioFabrica;
	private String imagen;
	private String marca;
	private String descripcion;
	
}
