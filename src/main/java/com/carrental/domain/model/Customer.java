package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Booking> bookings;

}
