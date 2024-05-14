package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Marca {

	@Id
	@GeneratedValue
	private long id;
	
	private String marca;
	
	@OneToMany(mappedBy = "marca")
    private List<Producto> productos;
	
}
