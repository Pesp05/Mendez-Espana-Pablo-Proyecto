package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Talla {

	@Id
	@GeneratedValue
	private long id;
	
	private String talla;
	
	@ManyToMany(mappedBy = "tallas")
    private List<Producto> productos;
	
}
