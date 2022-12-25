package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class OrderController {

    @GetMapping("/orderForm")
    public String orderForm() {
        return "addOrder";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute(name = "street") String street,
                              @ModelAttribute(name = "house") String house,
                              @ModelAttribute(name = "entrance") String entrance,
                              @ModelAttribute(name = "flor") String flor,
                              @ModelAttribute(name = "apartment") String apartment) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ул. ").append(street)
                .append(", дом ").append(house)
                .append(", подъезд ").append(entrance)
                .append(", эт. ").append(flor)
                .append(", кв. ").append(apartment);
        System.out.println(stringBuilder);
        return "redirect:/client/dish/menu";
    }

}
