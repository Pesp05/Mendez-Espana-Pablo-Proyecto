package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Color {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	/*
	@ManyToMany(mappedBy="colores", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Producto> productos = new ArrayList<>();
*/
}
