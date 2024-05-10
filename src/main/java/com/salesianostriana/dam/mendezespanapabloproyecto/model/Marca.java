package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import lombok.Getter;

@Getter
public enum Marca {
	
	SHIMANO("Shimano"),
	SPECIALIZED("Specialized"),
	GHOST("Ghost"),
	CANNONDALE("Cannondale"),
	BH("BH"),
	BTWIN("Btwin"),
	MMR("MMR"),
	ORBEA("Orbea"),
	TREK("Trek"),
	KTM("KTM"),
	PINARELLO("Pinarello");
	
	private String nombre;
	
	private Marca(String nombre) {
		this.nombre = nombre;
	}

}
