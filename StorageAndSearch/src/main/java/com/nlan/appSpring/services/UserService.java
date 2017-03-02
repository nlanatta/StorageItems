package com.nlan.appSpring.services;

import com.nlan.appSpring.model.User;

public interface UserService {
    void save(User user);
    
    User saveAndFlush(User user);

    User findByUsername(String username);
    
    User findById(Long Id);
}
