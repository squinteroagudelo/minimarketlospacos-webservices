package com.minimarket.lospacos.service.impl;

import com.minimarket.lospacos.models.entity.Rol;
import com.minimarket.lospacos.models.entity.User;
import com.minimarket.lospacos.models.repository.RolRepository;
import com.minimarket.lospacos.models.repository.UserRepository;
import com.minimarket.lospacos.service.iface.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public void create(User user) {
        Optional<Rol> rol = rolRepository
                .findById(user.getRolId().getId());
        
        if (rol.isPresent()) {
            userRepository.save(user);
        }
    }
    
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void update(int id, User user) {
        Optional<User> existsUser = userRepository.findById(id);
        if (existsUser.isPresent()) {
            existsUser.get().setName(user.getName());
            existsUser.get().setLastName(user.getLastName());
            existsUser.get().setPhone(user.getPhone());
            existsUser.get().setEmail(user.getEmail());
            existsUser.get().setPassword(user.getPassword());
            existsUser.get().setAddress(user.getAddress());
            Optional<Rol> rol = rolRepository
                .findById(user.getRolId().getId());
            if (rol.isPresent()) {
                existsUser.get().setRolId(rol.get());
            }
            userRepository.save(existsUser.get());
        }
    }

    @Override
    public void delete(int id) {
        Optional<User> existsUser = userRepository.findById(id);
        if (existsUser.isPresent()) {
            userRepository.delete(existsUser.get());
        }        
    }
    
    
    @Override
    public User login(User user)throws Exception{
        Optional<User> existsUser = this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (!existsUser.isPresent()){
            throw new Exception ("Usuario y/o contraseña incorrecto!!!");
        }
        return existsUser.get();
    }
    
}
