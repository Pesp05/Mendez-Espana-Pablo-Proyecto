package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import lombok.Getter;

@Getter
public enum Categoria {
	
	BICICLETAS("Bicicleta"),
	COMPONENTES("Componente"),
	ROPAYEQUIPAMIENTO("Ropa y equipamiento"),
	ACCESORIOS("Accesorio");
	
	private String nombre;
	
	private Categoria(String nombre) {
		this.nombre = nombre;
	}
	
}
