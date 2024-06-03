package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByUsername(String username);

}
