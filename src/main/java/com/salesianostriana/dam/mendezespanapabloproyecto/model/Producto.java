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
	private char size;
	private String color;
	private String descripcion;
	private double valoracion;
	private boolean disponibilidad;
	
	//Other Constructors
	public Producto(Long id, String nombre, double precioVenta, double precioFabrica, String imagen, String marca,
			char size, String color, String descripcion, boolean disponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioFabrica = precioFabrica;
		this.imagen = imagen;
		this.marca = marca;
		this.size = size;
		this.color = color;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}

	public Producto(Long id, String nombre, double precioVenta, double precioFabrica, String imagen, String marca,
			char size, String color, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioFabrica = precioFabrica;
		this.imagen = imagen;
		this.marca = marca;
		this.size = size;
		this.color = color;
		this.descripcion = descripcion;
	}

	public Producto(Long id, String nombre, double precioVenta, double precioFabrica, String imagen, String marca,
			char size, String color, String descripcion, double valoracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioFabrica = precioFabrica;
		this.imagen = imagen;
		this.marca = marca;
		this.size = size;
		this.color = color;
		this.descripcion = descripcion;
		this.valoracion = valoracion;
	}
	
}
