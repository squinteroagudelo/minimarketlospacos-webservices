package com.minimarket.lospacos.controller;

import com.minimarket.lospacos.models.entity.Rol;
import com.minimarket.lospacos.service.iface.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @GetMapping
    public List<Rol> getAll(){
        return this.rolService.getAll();
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Rol rol){
        this.rolService.create(rol);
    }
    
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody Rol rol){
        this.rolService.update(id, rol);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        this.rolService.delete(id);
    }
}
