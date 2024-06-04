package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.List;
import java.util.ArrayList;

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
	private List<Color> colores = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_talla",
			joinColumns = @JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="talla_id")
	)
	@Builder.Default
	private List<Talla> tallas = new ArrayList<>();
	
	@Enumerated(value = EnumType.STRING)
	private Categoria categoria;
	
	/*Helpers
	public void addToMarca(Marca marca) {
		this.marca = marca;
		marca.getProductos().add(this);
	}
	
	public void removeFromCurso(Marca marca) {
		marca.getProductos().remove(this);
		this.marca = null;		
	}
	
	public void addColor(Color c) {
		this.colores.add(c);
		c.getProductos().add(this);
	}
	
	public void removeColor(Color c) {
		c.getProductos().remove(this);
		this.colores.remove(c);
	}
	
	public void addTalla(Talla t) {
		this.tallas.add(t);
		t.getProductos().add(this);
	}
	
	public void removeTalla(Talla t) {
		t.getProductos().remove(this);
		this.tallas.remove(t);
	}
	*/
}
