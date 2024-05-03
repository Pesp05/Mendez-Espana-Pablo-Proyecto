package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import org.springframework.stereotype.Service;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Cliente;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.ClienteRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class ClienteService extends BaseServiceImpl<Cliente, Long, ClienteRepository>{

}
