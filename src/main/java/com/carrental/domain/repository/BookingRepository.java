package com.carrental.domain.repository;

import com.carrental.controller.BookingForm;
import com.carrental.domain.model.Booking;
import com.carrental.domain.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> { }
