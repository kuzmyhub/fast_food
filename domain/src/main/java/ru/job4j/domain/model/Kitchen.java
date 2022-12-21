package ru.job4j.domain.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Kitchen {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> dishes;
}
