package com.carrental.service;

import com.carrental.domain.model.Customer;
import com.carrental.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer (Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) { return customerRepository.findById(id); }

    public void editCustomer(Customer customer) { customerRepository.save(customer); }

    public void deleteById(Integer id) { customerRepository.deleteById(id); }
}
