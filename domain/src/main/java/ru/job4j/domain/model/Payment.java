package ru.job4j.domain.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Payment {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    private String amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
    private LocalDateTime created = LocalDateTime.now();
}
