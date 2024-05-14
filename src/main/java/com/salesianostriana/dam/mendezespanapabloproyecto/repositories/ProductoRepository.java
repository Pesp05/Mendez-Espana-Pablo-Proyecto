package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
}
