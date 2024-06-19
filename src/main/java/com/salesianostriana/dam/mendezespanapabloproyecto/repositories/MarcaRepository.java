package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Marca;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

	@Query("select m.productos from Marca m where m.id = :idMarca")
	public List<Producto> siHayProductosAsociadosMarca(@Param("idMarca") Long idMarca);
	
}
