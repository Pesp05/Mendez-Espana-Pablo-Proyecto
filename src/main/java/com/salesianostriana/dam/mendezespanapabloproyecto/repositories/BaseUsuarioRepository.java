package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;

@NoRepositoryBean
public interface BaseUsuarioRepository<T extends Usuario> extends JpaRepository<T, Long> {
	
	public T findByNombreUsuario(String nombreUsuario);

}
