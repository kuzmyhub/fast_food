package ru.job4j;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Order {
    @EqualsAndHashCode.Include
    private int id;
    private int amount;
    private String address;
    private List<Dish> dishes;
    private Client client;
    private Courier courier;
    private Payment payment;
    private LocalDateTime created = LocalDateTime.now();
}
