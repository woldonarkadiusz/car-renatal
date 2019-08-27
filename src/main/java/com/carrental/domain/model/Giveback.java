package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Giveback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate givebackDate;
    private String givebackNotes;
    private Integer extraCharge;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;
}
