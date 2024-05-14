package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private long id;
	
	private String nombre;
	private double precioVenta;
	private double precioFabrica;
	private String imagen;
	private String descripcion;
	
	@ManyToOne
    private Marca marca;
	
	@ManyToMany
    private List<Color> colores;
	
	@ManyToMany
    private List<Talla> tallas;
	
	@Enumerated(value = EnumType.STRING)
	private Categoria categoria;
	
}
