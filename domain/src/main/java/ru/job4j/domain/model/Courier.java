package ru.job4j.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Courier {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private String phoneNumber;
}
