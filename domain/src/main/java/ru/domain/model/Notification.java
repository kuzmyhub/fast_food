package ru.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_number")
    private int orderNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    private LocalDateTime created = LocalDateTime.now();
}
