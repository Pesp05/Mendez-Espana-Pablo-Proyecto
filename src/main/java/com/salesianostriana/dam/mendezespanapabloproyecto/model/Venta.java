package com.salesianostriana.dam.mendezespanapabloproyecto.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@Builder.Default
	private List<LineaVenta> listaLineasVenta = new ArrayList<>();
	
	private boolean isFinished;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_venta_usuario"))
	private Usuario usuario;
	
	private LocalDateTime fecha;
	
	private double precioTotal;
	
}
