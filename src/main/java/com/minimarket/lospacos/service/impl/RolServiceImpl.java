package com.minimarket.lospacos.service.impl;

import com.minimarket.lospacos.models.entity.Rol;
import com.minimarket.lospacos.models.repository.RolRepository;
import com.minimarket.lospacos.service.iface.RolService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
    
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getAll() {
        List<Rol> roles = new ArrayList<>();
        rolRepository.findAll().forEach(roles::add);
        return  roles;
    }

    @Override
    public void create(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void update(int id, Rol rol) {
        Optional<Rol> existsRol = rolRepository.findById(id);
        if (existsRol.isPresent()) {
            existsRol.get().setName(rol.getName());
            rolRepository.save(existsRol.get());
        }
    }

    @Override
    public void delete(int id) {
        Optional<Rol> existsRol = rolRepository.findById(id);
        if (existsRol.isPresent()) {
            rolRepository.delete(existsRol.get());
        }
    }
    
}
