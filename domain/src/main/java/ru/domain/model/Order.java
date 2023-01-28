package ru.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @JsonProperty("id")
    private int id;
    private int amount;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "order_dishes",
            joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "dish_id", nullable = false, updatable = false)})
    private List<Dish> dishes;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Courier courier;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime created = LocalDateTime.now();
}
