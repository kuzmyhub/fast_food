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

    @PostMapping("/dismiss")
    public ResponseEntity<Void> dismissCourierById(@RequestParam int id) {
        simpleCourierService.dismissById(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @PostMapping("/hire")
    public ResponseEntity<Void> hireCourierById(@RequestParam int id) {
        simpleCourierService.hireById(id);
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
