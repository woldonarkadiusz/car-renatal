package com.carrental.controller;

import com.carrental.domain.model.Booking;
import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.service.BookingService;
import com.carrental.service.CarService;
import com.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;
    private final DepartmentService departmentService;

    @GetMapping("/create")
    public String createBookingForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("booking", new Booking());
        model.addAttribute("departments", departments);
        return "booking/form";
    }

    @GetMapping("/create-car")
    public String createBooking(@RequestParam("department") Integer depId, @RequestParam("beginningOfRent")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @RequestParam("endOfRent")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end, Model model) {


        //log.info("Created new booking {}", booking);
        BookingForm bookingForm = new BookingForm();

        bookingForm.setBeginningOfRent(start);
        bookingForm.setEndOfRent(end);
        model.addAttribute("booking", bookingForm);
        model.addAttribute("cars", bookingService.getCarsByDepartmentId(depId));
        return "booking/form-with-id";
    }

    @PostMapping("/create/finish")
    public String bookingListById( @ModelAttribute("booking") BookingForm booking, Model model) {
        int id = bookingService.createBooking(booking);

        return "redirect:/booking/details/" + id;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Booking booking = bookingService.getBookingById(id).get();
        model.addAttribute("booking", booking);

        return "booking/details";
    }


    @GetMapping("/list")
    public String bookingList(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments", departments);
        model.addAttribute("bookings", bookings);
        return "booking/list";
    }

    @GetMapping("/edit/{id}")
    public String editBookingForm(@PathVariable("id") Integer id, Model model) {
        Optional<Booking> maybeBooking = bookingService.getBookingById(id);

        if (maybeBooking.isPresent()) {
            model.addAttribute("booking", maybeBooking.get());
            return "booking/edit-form";
        } else {
            return "redirect:/booking/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.editBooking(booking);

        return "redirect:/booking/list";
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam("id") Integer id) {
        bookingService.deleteById(id);
        return "redirect:/booking/list";
    }
}
