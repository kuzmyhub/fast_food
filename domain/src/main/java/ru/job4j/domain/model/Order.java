package ru.job4j.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Order {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private int amount;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> dishes;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Courier courier;
    @ManyToOne(cascade = CascadeType.ALL)
    private Status status;
    private LocalDateTime created = LocalDateTime.now();
}
