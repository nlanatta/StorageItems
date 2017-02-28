package com.nlan.appSpring.services;

import com.nlan.appSpring.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
