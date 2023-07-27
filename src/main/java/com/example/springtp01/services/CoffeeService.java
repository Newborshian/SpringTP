package com.example.springtp01.services;

import com.example.springtp01.entities.Coffee;

import java.util.List;
import java.util.Optional;

public interface CoffeeService {
    List<Coffee> getAllCoffees();

    Coffee saveCoffee(Coffee coffee);

    void deleteCoffee(Integer id);

    Optional<Coffee> getById(Integer id);

}
