package com.example.springtp01.controllers;

import com.example.springtp01.entities.Coffee;
import com.example.springtp01.repositories.CoffeeRepository;
import com.example.springtp01.services.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("coffee")
public class RestApiDemoController {
    private final CoffeeService coffeeService;

    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController(CoffeeService coffeeService, CoffeeRepository coffeeRepository) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/getAllCoffees")
    Iterable<Coffee> getAllCoffees(){

        return coffeeService.getAllCoffees();
    }

    @GetMapping("/getCoffeeById/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable Integer id){
        return coffeeService.getById(id);
    }

    @PostMapping("/postCoffee")
    Coffee postCoffee(@RequestBody Coffee coffee){
        return coffeeService.saveCoffee(coffee);
    }

    @PutMapping("/coffees/{id}")
        //c'est comme un post -> il faut donner des valeurs dans le body et mettre en methode post
    ResponseEntity<Coffee> putCoffee(@PathVariable Integer id, @RequestBody Coffee coffee) {

        Optional<Coffee> existingCoffeeOptional = coffeeService.getById(id);

        if (existingCoffeeOptional.isPresent()) {
            Coffee existingCoffee = existingCoffeeOptional.get();
            existingCoffee.setName(coffee.getName());
            return new ResponseEntity<>(coffeeService.saveCoffee(existingCoffee), HttpStatus.OK);
        } else {

            return new ResponseEntity<>(coffeeService.saveCoffee(coffee), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/deletedCoffees/{id}")
    void deleteCoffee(@PathVariable Integer id){

        coffeeService.deleteCoffee(id);
    }

}
