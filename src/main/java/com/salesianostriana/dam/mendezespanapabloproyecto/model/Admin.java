package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Admin extends Usuario{

	public Admin(String nombreUsuario, String password, String email) {
		super(nombreUsuario, password, email);
	}

}
