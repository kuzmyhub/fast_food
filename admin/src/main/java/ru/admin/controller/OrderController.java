package ru.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.admin.service.CustomerService;
import ru.admin.service.OrderService;
import ru.domain.model.Order;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/order")
@AllArgsConstructor
public class OrderController {

    private CustomerService simpleCustomerService;
    private OrderService simpleOrderService;

    @GetMapping("/orders")
    public String getOrders(Model model, Principal principal) {
        List<Order> orders = simpleOrderService.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "orders";
    }

    @GetMapping("/orderInformation/{id}")
    public String orderInformation(@PathVariable(name = "id") int id,
                                   Model model, Principal principal) {
        Optional<Order> optionalOrder = simpleOrderService.findById(id);
        if (optionalOrder.isEmpty()) {
            return "404";
        }
        model.addAttribute("order", optionalOrder.get());
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "order";
    }
}
