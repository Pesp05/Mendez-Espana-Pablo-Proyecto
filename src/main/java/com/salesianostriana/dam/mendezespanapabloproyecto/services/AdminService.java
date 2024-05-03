package com.salesianostriana.dam.mendezespanapabloproyecto.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.mendezespanapabloproyecto.model.Admin;
import com.salesianostriana.dam.mendezespanapabloproyecto.repositories.AdminRepository;
import com.salesianostriana.dam.mendezespanapabloproyecto.services.base.BaseServiceImpl;

@Service
public class AdminService extends BaseServiceImpl<Admin, Long, AdminRepository>{

}
