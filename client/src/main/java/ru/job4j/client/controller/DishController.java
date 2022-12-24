package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.client.service.DishService;
import ru.job4j.domain.model.Dish;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/client/dish")
@AllArgsConstructor
public class DishController {

    private DishService simpleDishService;

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("dishes", simpleDishService.findAll());
        return "menu";
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") Integer id) {
        Optional<Dish> optionalDish = simpleDishService.findDishById(id);
        if (optionalDish.isEmpty()) {
            System.out.println("no");
        }
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(optionalDish.get().getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(optionalDish.get().getPhoto()));
    }
}
