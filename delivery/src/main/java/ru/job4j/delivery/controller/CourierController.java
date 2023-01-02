package ru.job4j.delivery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.delivery.service.CourierService;
import ru.job4j.domain.model.Courier;

import java.util.List;

@RestController
@RequestMapping("/courier")
@AllArgsConstructor
public class CourierController {

    private CourierService simpleCourierService;

    @PostMapping
    public ResponseEntity<Courier> addCourier(@RequestBody Courier courier) {
        return new ResponseEntity<>(
                simpleCourierService.save(courier),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCourierById(@RequestParam int id) {
        simpleCourierService.deleteById(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Courier>> findAllCouriers() {
        return new ResponseEntity<>(
                simpleCourierService.findAll(),
                HttpStatus.OK
        );
    }
}
