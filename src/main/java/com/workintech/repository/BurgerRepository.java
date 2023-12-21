package com.workintech.repository;

import com.workintech.entity.BreadType;
import com.workintech.entity.Burger;

import java.util.List;

public interface BurgerRepository {
    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(long id);

    Burger update(Burger burger);

    Burger remove(long id);

    List<Burger> findByPrice(Integer price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);
}
