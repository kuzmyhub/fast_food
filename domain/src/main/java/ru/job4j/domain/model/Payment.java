package ru.job4j.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Payment {
    @EqualsAndHashCode.Include
    private int id;
    private String amount;
    private Order order;
    private LocalDateTime created = LocalDateTime.now();
}
