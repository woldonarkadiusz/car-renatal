package com.carrental.domain.repository;

import com.carrental.domain.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
