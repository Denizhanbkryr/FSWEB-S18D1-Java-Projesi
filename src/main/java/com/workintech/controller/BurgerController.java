package com.workintech.controller;

import com.workintech.entity.BreadType;
import com.workintech.entity.Burger;
import com.workintech.repository.BurgerRepository;
import com.workintech.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerRepository burgerRepository;

    @Autowired
    public BurgerController(BurgerRepository burgerDao) {
        this.burgerRepository = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerRepository.save(burger);
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable long id) {
        return burgerRepository.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        return burgerRepository.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id) {
        return burgerRepository.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        BreadType bt = BreadType.valueOf(breadType);
        return burgerRepository.findByBreadType(bt);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price) {
        return burgerRepository.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByPrice(@PathVariable String content) {
        return burgerRepository.findByContent(content);
    }

}

