package com.carrental.service;

import com.carrental.domain.model.Rent;
import com.carrental.domain.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;

    public void createRent (Rent rent) {
        rentRepository.save(rent);
    }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRentById(Integer id) { return rentRepository.findById(id); }

    public void editRent(Rent rent) { rentRepository.save(rent); }

    public void deleteById(Integer id) { rentRepository.deleteById(id); }
}
