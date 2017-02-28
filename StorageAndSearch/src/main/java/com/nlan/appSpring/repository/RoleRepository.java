package com.nlan.appSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlan.appSpring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
