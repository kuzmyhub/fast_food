package ru.domain.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Card {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private double discount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
