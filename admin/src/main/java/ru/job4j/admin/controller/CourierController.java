package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.admin.service.CourierService;

@Controller
@RequestMapping("/admin/courier")
@AllArgsConstructor
public class CourierController {

    private CourierService simpleCourierService;

    @GetMapping("/couriers")
    public String getCouriers(@RequestParam(name = "delete", required = false) boolean delete,
                              Model model) {
        model.addAttribute("couriers", simpleCourierService.findAll());
        model.addAttribute("delete", delete);
        return "couriers";
    }

    @PostMapping("/deleteCourier")
    public String deleteCourier(@ModelAttribute("id") int id) {
        boolean isDeleted = simpleCourierService.deleteById(id);
        return "redirect:/admin/courier/couriers?delete=" + isDeleted;
    }

}
