package com.carrental.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class BookingForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginningOfRent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endOfRent;
    private Integer carId;
}
