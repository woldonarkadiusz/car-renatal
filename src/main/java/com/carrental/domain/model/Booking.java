package com.carrental.domain.model;

import com.carrental.domain.model.car.Car;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateOfBooking;
    private LocalDate beginningOfRent;
    private LocalDate endOfRent;
    private Integer price;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "booking")
    private Rent rent;

    @OneToOne(mappedBy = "booking")
    private Giveback giveback;


}