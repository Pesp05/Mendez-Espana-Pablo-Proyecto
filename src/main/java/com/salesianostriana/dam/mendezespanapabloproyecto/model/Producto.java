package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private String descripcion;
	
	@ManyToOne
    private Marca marca;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_color",
			joinColumns = @JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="color_id")
	)
	@Builder.Default
	private Set<Color> colores = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_talla",
			joinColumns = @JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="talla_id")
	)
	@Builder.Default
	private Set<Talla> tallas = new HashSet<>();
	
	@Enumerated(value = EnumType.STRING)
	private Categoria categoria;
	
	@OneToMany(mappedBy="producto", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<LineaVenta> lineasVenta = new ArrayList<>();
	
}
