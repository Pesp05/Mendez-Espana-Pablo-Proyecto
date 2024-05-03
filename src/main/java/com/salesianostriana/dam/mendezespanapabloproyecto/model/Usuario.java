package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public abstract class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombreUsuario;
	private String password;
	private String email;
	
	public Usuario(String nombreUsuario, String password, String email) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;
	}
	
	
	
}
