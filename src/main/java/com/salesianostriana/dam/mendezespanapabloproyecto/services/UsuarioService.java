package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.UsuarioRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository>{

	@Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Usuario save(Usuario t) {
    t.setPassword(passwordEncoder.encode(t.getPassword()));
        
        return super.save(t);
    }
	
}
