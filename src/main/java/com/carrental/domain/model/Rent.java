package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String notes;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;
}
