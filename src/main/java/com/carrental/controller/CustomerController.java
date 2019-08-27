package com.carrental.controller;

import com.carrental.domain.model.Customer;
import com.carrental.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/create")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        log.info("Created new customer {}", customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String customerList(Model model) {
        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable("id") Integer id, Model model) {
        Optional<Customer> maybeCustomer = customerService.getCustomerById(id);

        if (maybeCustomer.isPresent()) {
            model.addAttribute("customer", maybeCustomer.get());
            return "customer/edit-form";
        } else {
            return "redirect:/customer/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.editCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/customer/list";
    }
}
