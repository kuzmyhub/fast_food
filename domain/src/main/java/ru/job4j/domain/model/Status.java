package ru.job4j.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Status {
    @EqualsAndHashCode.Include
    private int id;
    private String condition;
}
