package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.admin.service.CourierService;
import ru.job4j.admin.service.CustomerService;
import ru.job4j.domain.model.Courier;

import java.security.Principal;

@Controller
@RequestMapping("/admin/courier")
@AllArgsConstructor
public class CourierController {

    private CourierService simpleCourierService;
    private CustomerService simpleCustomerService;

    @GetMapping("/couriers")
    public String getCouriers(@RequestParam(name = "dismiss", required = false) String dismiss,
                              Model model, Principal principal) {
        model.addAttribute("couriers", simpleCourierService.findAll());
        model.addAttribute("dismiss", dismiss);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "couriers";
    }

    @PostMapping("/dismissCourier")
    public String dismissCourier(@ModelAttribute("id") int id) {
        boolean isDismissed = simpleCourierService.dismissById(id);
        return "redirect:/admin/courier/couriers?dismiss=" + isDismissed;
    }

    @PostMapping("/hireCourier")
    public String hireCourier(@ModelAttribute("id") int id) {
        boolean isDismissed = simpleCourierService.hireById(id);
        return "redirect:/admin/courier/couriers?dismiss=" + !isDismissed;
    }

    @GetMapping("/formAddCourier")
    public String formAddCourier(Model model, Principal principal) {
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "addCourier";
    }

    @PostMapping("/addCourier")
    public String addCourier(@ModelAttribute Courier courier,
                             Model model, Principal principal) {
        simpleCourierService.add(courier);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "redirect:/admin/courier/couriers";
    }
}
