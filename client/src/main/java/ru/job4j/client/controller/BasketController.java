package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.client.service.DishService;
import ru.job4j.client.service.PrincipalService;
import ru.job4j.domain.model.Dish;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/client/basket")
@AllArgsConstructor
public class BasketController {

    private DishService simpleDishService;
    private PrincipalService simplePrincipalService;

    @GetMapping
    public String basket(Model model, Principal principal,
                         @CookieValue(value = "basket", required = false) String ids) {
        List<Dish> dishes = simpleDishService.getBasketDishes(ids);
        Integer amount = simpleDishService.getDishAmount(dishes);
        model.addAttribute("dishes", dishes);
        model.addAttribute("amount", amount);
        model.addAttribute("dishIds", ids);
        model.addAttribute("username",
                simplePrincipalService.getUsername(principal));
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

