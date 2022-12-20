package ru.job4j.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Notification {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private String status;
    private String description;
}
