package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Venta {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="venta", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<CompraProductoForm> listaLineasVenta = new ArrayList<>();
	
	private boolean isFinished;
	
	@ManyToOne
	private Usuario user;
	
}
