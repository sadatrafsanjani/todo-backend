package com.todo.backend.model;

import lombok.*;
import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE")
    private Instant date;

    @Column(name = "STATUS")
    private boolean status;
}

