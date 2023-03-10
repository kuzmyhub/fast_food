package ru.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.dish.service.DishService;
import ru.domain.model.Dish;

import java.util.List;

@RestController
@RequestMapping("/dish")
@AllArgsConstructor
public class DishController {

    private DishService simpleDishService;

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        return new ResponseEntity<>(
                simpleDishService.addDish(dish),
                HttpStatus.OK
        );
    }

    @GetMapping("/findById")
    public ResponseEntity<Dish> findDishById(@RequestParam int id) {
        Dish dish = simpleDishService.findDishById(id).
                orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Dish number %s not found", id)
                        )
                );
        return new ResponseEntity<>(
                dish,
                HttpStatus.OK
        );
    }

    @GetMapping("/findByName")
    public ResponseEntity<Dish> findDishByName(@RequestParam String name) {
        Dish dish = simpleDishService.findDishByName(name).
                orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Dish name %s not found", name)
                        )
                );
        return new ResponseEntity<>(
                dish,
                HttpStatus.OK
        );
    }

    @PutMapping("/exclude")
    public ResponseEntity<Void> excludeDish(@RequestParam int id) {
        simpleDishService.excludeDishById(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @PutMapping("/enable")
    public ResponseEntity<Void> enableDish(@RequestParam int id) {
        simpleDishService.enableDishById(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Dish>> findAll() {
        return new ResponseEntity<>(
                simpleDishService.findAll(),
                HttpStatus.OK
        );
    }
}
