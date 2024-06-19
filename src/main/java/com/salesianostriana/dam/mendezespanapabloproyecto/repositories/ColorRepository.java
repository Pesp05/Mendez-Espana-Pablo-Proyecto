package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;

public interface ColorRepository extends JpaRepository<Color, Long>{
	
	@Query("SELECT p FROM Producto p JOIN p.colores c WHERE c.id = :colorId")
	public List<Producto> siHayProductoEnColor(@Param("colorId")Long id);
	
}
