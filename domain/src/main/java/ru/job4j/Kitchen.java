package ru.job4j;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Kitchen {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private List<Order> orders;
}
