package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;

public interface TallaRepository extends JpaRepository<Talla, Long>{
	
	@Query("SELECT p FROM Producto p JOIN p.tallas t WHERE t.id = :tallaId")
	public List<Producto> siHayProductoEnTalla(@Param("tallaId")Long id);
	
}
