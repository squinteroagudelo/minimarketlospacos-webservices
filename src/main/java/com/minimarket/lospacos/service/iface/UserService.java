package com.minimarket.lospacos.service.iface;

import com.minimarket.lospacos.models.entity.User;
import java.util.List;

public interface UserService {
    
    void create(User user);
    
    List<User> getAll();
    
    void update(int id, User user);
    
    void delete(int id);
    
        /**
     * Login usuario
     * @param user Objeto User
     * @return User
     * @throws java.lang.Exception
     */
    User login(User user) throws Exception;
}
