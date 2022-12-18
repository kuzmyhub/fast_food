package ru.job4j;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Notification {
    @EqualsAndHashCode.Include
    private int id;
    private String status;
}
