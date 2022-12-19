package ru.job4j.contorller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.Status;
import ru.job4j.service.StatusService;

@RestController
@AllArgsConstructor
public class StatusController {

    private StatusService simpleStatusService;

    @GetMapping("/status/{orderId}")
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

    @PostMapping("/status")
    public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
