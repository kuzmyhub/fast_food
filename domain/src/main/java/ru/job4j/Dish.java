package ru.job4j;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Dish {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private int cost;
}
