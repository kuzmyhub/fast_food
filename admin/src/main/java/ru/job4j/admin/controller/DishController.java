package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.admin.service.DishService;
import ru.job4j.domain.model.Dish;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/admin/dish")
@AllArgsConstructor
public class DishController {

    private DishService simpleDishService;

    @GetMapping("/menu")
    public String menu(@RequestParam(name = "delete", required = false) boolean delete,
                       Model model) {
        model.addAttribute("dishes", simpleDishService.findAll());
        model.addAttribute("delete", delete);
        return "menu";
    }

    @PostMapping("/deleteDish")
    public String deleteDish(@ModelAttribute(name = "id") int id) {
        boolean isDeleted = simpleDishService.deleteDishById(id);
        return "redirect:/admin/dish/menu?delete=" + isDeleted;
    }

    @GetMapping("/formAddDish")
    public String formAddDish() {
        return "addDish";
    }

    @PostMapping("/addDish")
    public String addDish(@ModelAttribute Dish dish,
                          @RequestParam("file") MultipartFile file) throws IOException {
        dish.setPhoto(file.getBytes());
        simpleDishService.addDish(dish);
        return "redirect:/admin/dish/menu";
    }

    @GetMapping("/formUpdateDish/{id}")
    public String formUpdateDish(Model model, @PathVariable("id") Integer id) {
        Optional<Dish> optionalDish = simpleDishService.findDishById(id);
        if (optionalDish.isEmpty()) {
            return "404";
        }
        model.addAttribute("dish", optionalDish.get());
        return "updateDish";
    }

    @PostMapping("/updateDish")
    public String updateDish(@ModelAttribute Dish dish,
                             @RequestParam("file") MultipartFile file) throws IOException {
        dish.setPhoto(file.getBytes());
        simpleDishService.addDish(dish);
        return "redirect:/admin/dish/menu";
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") Integer id) {
        Optional<Dish> optionalDish = simpleDishService.findDishById(id);
        if (optionalDish.isEmpty()) {
            throw new NoSuchElementException(
                    String.format("Dish number %s not found", id)
            );
        }
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(optionalDish.get().getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(optionalDish.get().getPhoto()));
    }
}
