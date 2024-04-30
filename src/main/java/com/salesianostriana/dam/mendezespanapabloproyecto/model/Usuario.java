package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombreUsuario;
	private String password;
	private String email;
	
}
