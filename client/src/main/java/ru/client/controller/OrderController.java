package ru.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.client.service.CustomerService;
import ru.client.service.DishService;
import ru.client.service.OrderService;
import ru.domain.model.Customer;
import ru.domain.model.Dish;
import ru.domain.model.Order;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/client/order")
@AllArgsConstructor
public class OrderController {

    private DishService simpleDishService;
    private CustomerService simpleCustomerService;
    private OrderService simpleOrderService;

    @GetMapping("/addressForm")
    public String orderForm(@ModelAttribute(name = "dishIds") String dishIds,
                            Model model, Principal principal) {
        model.addAttribute("dishIds", dishIds);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "addressForm";
    }

    @SuppressWarnings("checkstyle:ParameterNumber")
    @PostMapping("/orderPreview")
    public String formOrder(Model model,
                              @ModelAttribute(name = "dishIds") String ids,
                              @ModelAttribute(name = "street") String street,
                              @ModelAttribute(name = "house") String house,
                              @ModelAttribute(name = "entrance") String entrance,
                              @ModelAttribute(name = "flor") String flor,
                              @ModelAttribute(name = "apartment") String apartment) {
        StringBuilder address = new StringBuilder();
        address.append("Ул. ").append(street)
                .append(", дом ").append(house)
                .append(", подъезд ").append(entrance)
                .append(", эт. ").append(flor)
                .append(", кв. ").append(apartment);
        List<Dish> dishes = simpleDishService.getBasketDishes(ids);
        int dishAmount = simpleDishService.getDishAmount(dishes);
        model.addAttribute("address", address);
        model.addAttribute("dishAmount", dishAmount);
        model.addAttribute("dishes", dishes);
        model.addAttribute("dishIds", ids);
        return "orderPreview";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute(name = "dishIds") String ids,
                              @ModelAttribute(name = "address") String address,
                              Principal principal) {
        List<Dish> dishes = simpleDishService.getBasketDishes(ids);
        int dishAmount = simpleDishService.getDishAmount(dishes);
        Customer customer = simpleCustomerService.findCustomerByUsername(
                simpleCustomerService.getUsername(principal)
        );
        Order order = new Order();
        order.setAmount(dishAmount);
        order.setAddress(address);
        order.setDishes(dishes);
        order.setCustomer(customer);
        Order savedOrder = simpleOrderService.createOrder(order);
        return "redirect:/client/payment/createPayment/?id=" + savedOrder.getId();
    }

    @GetMapping("/clientOrders")
    public String clientOrders(Model model, Principal principal) {
        Customer customer = simpleCustomerService.findCustomerByUsername(
                simpleCustomerService.getUsername(principal)
        );
        List<Order> orders = simpleOrderService.findAllOrdersByCustomerId(customer.getId());
        model.addAttribute("orders", orders);
        model.addAttribute("username",
                simpleCustomerService.getUsername(principal));
        return "clientOrders";
    }
}
