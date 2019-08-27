package com.carrental.service;

import com.carrental.controller.BookingForm;
import com.carrental.domain.model.Booking;
import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.domain.repository.BookingRepository;
import com.carrental.domain.repository.CarRepository;
import com.carrental.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final DepartmentRepository departmentRepository;
    private final CarRepository carRepository;
    private final DepartmentService departmentService;
    private final CarService carService;

    public Integer createBooking (BookingForm bookingForm) {

        Booking booking = new Booking();
       booking.setBeginningOfRent(bookingForm.getBeginningOfRent());
       booking.setEndOfRent(bookingForm.getEndOfRent());

       booking.setCar(carRepository.findById(bookingForm.getCarId()).get());
       return bookingRepository.save(booking).getId();

    }

    public void createBooking(Booking booking, Integer depId){

        // TODO
    }

    public List<Booking> getAllBookings() { return bookingRepository.findAll(); }

    public Optional<Booking> getBookingById(Integer id) { return bookingRepository.findById(id); }

    public void editBooking(Booking booking) { bookingRepository.save(booking); }

    public void deleteById(Integer id) { bookingRepository.deleteById(id); }

    public List<Car> getCarsByDepartmentId(Integer depId) {

        Department department = departmentRepository.findById(depId).get();

        return carRepository.findAllByDepartment(department);
    }
}
