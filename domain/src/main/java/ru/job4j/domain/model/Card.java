package ru.job4j.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Card {
    @EqualsAndHashCode.Include
    private int id;
    private int bonuses;
    private Customer customer;
}
