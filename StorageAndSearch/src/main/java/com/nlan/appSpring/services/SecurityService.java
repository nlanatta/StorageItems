package com.nlan.appSpring.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
