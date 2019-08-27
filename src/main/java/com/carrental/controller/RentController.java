package com.carrental.controller;

import com.carrental.domain.model.Rent;
import com.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rent")
@Slf4j
public class RentController {

    private final RentService rentService;

    @GetMapping("/create")
    public String createRentForm(Model model) {
        model.addAttribute("rent", new Rent());
        return "rent/form";
    }

    @PostMapping("/create")
    public String createRent(@ModelAttribute("rent") Rent rent) {
        rentService.createRent(rent);
        log.info("Created new rent {}", rent);

        return "redirect:/rent/list";
    }

    @GetMapping("/list")
    public String rentList(Model model) {
        List<Rent> rents = rentService.getAllRents();

        model.addAttribute("rents", rents);
        return "rent/list";
    }

    @GetMapping("/edit/{id}")
    public String editRentForm(@PathVariable("id") Integer id, Model model) {
        Optional<Rent> maybeRent = rentService.getRentById(id);

        if (maybeRent.isPresent()) {
            model.addAttribute("rent", maybeRent.get());
            return "rent/edit-form";
        } else {
            return "redirect:/rent/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editRent(@ModelAttribute("rent") Rent rent) {
        rentService.editRent(rent);

        return "redirect:/rent/list";
    }

    @GetMapping("/delete")
    public String deleteRent(@RequestParam("id") Integer id) {
        rentService.deleteById(id);
        return "redirect:/rent/list";
    }
}
