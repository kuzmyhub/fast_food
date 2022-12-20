package ru.job4j.domain.model;

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
    private Customer customer;
    private Courier courier;
    private Status status;
    private LocalDateTime created = LocalDateTime.now();
}
