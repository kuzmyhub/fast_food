package ru.job4j.order.contorller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.model.Status;
import ru.job4j.order.service.StatusService;

@RestController
@AllArgsConstructor
@RequestMapping("/status")
public class StatusController {

    private StatusService simpleStatusService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Status> checkStatus(int orderId) {
        Status status = simpleStatusService.checkStatus(orderId)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Order number %s not found", orderId
                                )
                        )
                );
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
