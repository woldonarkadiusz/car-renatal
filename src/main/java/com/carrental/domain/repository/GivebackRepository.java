package com.carrental.domain.repository;

import com.carrental.domain.model.Giveback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GivebackRepository extends JpaRepository<Giveback, Integer> {
}