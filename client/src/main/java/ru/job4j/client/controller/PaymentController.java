package ru.job4j.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.client.service.CustomerService;
import ru.job4j.client.service.OrderService;
import ru.job4j.client.service.PaymentService;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.Payment;

import java.security.Principal;

@Controller
@RequestMapping("client/payment")
@AllArgsConstructor
public class PaymentController {

    private CustomerService simpleCustomerService;
    private OrderService simpleOrderService;
    private PaymentService simplePaymentService;

    @GetMapping("/paymentForm")
    public String paymentForm(@ModelAttribute(name = "dishIds") String ids,
                              @ModelAttribute(name = "address") String address,
                              Model model, Principal principal) {
        model.addAttribute("dishIds", ids);
        model.addAttribute("address", address);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "paymentForm";
    }

    @GetMapping("/createPayment")
    public String createPayment(@RequestParam(name = "id") int id,
                                Model model, Principal principal) {
        Order order = simpleOrderService.findOrderById(id).get();
        Payment payment = new Payment();
        payment.setOrder(order);
        simplePaymentService.save(payment);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "redirect:/client";
    }
}
