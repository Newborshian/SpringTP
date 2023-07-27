package com.example.springtp01.services;

import com.example.springtp01.entities.Coffee;
import com.example.springtp01.repositories.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeServiceImp implements CoffeeService{

    private CoffeeRepository coffeeRepository;

    public CoffeServiceImp(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee saveCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public void deleteCoffee(Integer id) {
        coffeeRepository.deleteById(id);
    }

    @Override
    public Optional<Coffee> getById(Integer id) {
        return coffeeRepository.findById(id);
    }
}
