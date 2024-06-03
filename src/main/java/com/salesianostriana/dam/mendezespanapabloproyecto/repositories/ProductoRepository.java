package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.categoria = :categoria")
	public List<Producto> productosPorCategoria(@Param("categoria") Categoria categoria);
	
	@Query("select p from Producto p where p.nombre ILIKE %:nombre%")
	public List<Producto> productosPorNombre(@Param("nombre") String nombre);
	
}
