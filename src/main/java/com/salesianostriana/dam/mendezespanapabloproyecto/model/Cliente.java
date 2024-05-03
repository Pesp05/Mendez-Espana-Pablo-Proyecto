package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario{

	public Cliente(String nombreUsuario, String password, String email) {
		super(nombreUsuario, password, email);
	}

}
