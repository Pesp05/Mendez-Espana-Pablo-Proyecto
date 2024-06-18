package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("select v from Venta v where v.isFinished = false and v.usuario = :user")
	public Optional<Venta> findVentaNotFinished(@Param("user") Usuario user);
	
	@Query("select v from Venta v where v.isFinished = true and v.usuario = :user")
	public List<Venta> findFinishedVentas(@Param("user") Usuario user);
	
}
