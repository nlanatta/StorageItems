package com.nlan.appSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlan.appSpring.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
