package ru.job4j;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Customer {
    @EqualsAndHashCode.Include
    private int id;
    private String phoneNumber;
}
