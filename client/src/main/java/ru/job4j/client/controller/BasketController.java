package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.client.service.DishService;
import ru.job4j.domain.model.Dish;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/client/basket")
@AllArgsConstructor
public class BasketController {

    private DishService simpleDishService;

    @GetMapping
    public String basket(Model model,
                         @CookieValue(value = "basket") String ids) {
        List<Dish> dishes = simpleDishService.getBasketDishes(ids);
        Integer amount = simpleDishService.getDishAmount(dishes);
        model.addAttribute("dishes", dishes);
        model.addAttribute("amount", amount);
        return "basket";
    }

    @PostMapping("/addToBasket")
    public String addToBasket(@CookieValue(value = "basket", required = false) String ids,
                              HttpServletResponse response,
                              Model model,
                              @ModelAttribute(name = "id") String id) {
        Cookie cookie;
        if (ids == null) {
            cookie = new Cookie("basket", id);
        } else {
            cookie = new Cookie("basket", ids + "." + id);
        }
        cookie.setMaxAge(100000);
        response.addCookie(cookie);
        response.setContentType("text/plain");
        System.out.println(cookie.getValue());
        model.addAttribute("dishes", simpleDishService.findAll());
        return "redirect:/client/dish/menu";
    }
}

