package ru.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.client.service.CustomerService;
import ru.client.service.OrderService;
import ru.client.service.PaymentService;
import ru.domain.model.Order;
import ru.domain.model.Payment;

import java.security.Principal;
import java.util.Optional;

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
    public String createPayment(@RequestParam(name = "id") int id) {
        Optional<Order> optionalOrder = simpleOrderService.findOrderById(id);
        if (optionalOrder.isEmpty()) {
            return "404";
        }
        Payment payment = new Payment();
        payment.setOrder(optionalOrder.get());
        simplePaymentService.save(payment);
        return "redirect:/client/basket/clearBasket";
    }
}
