package com.carrental.domain.repository;

import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Integer> {

    List<Car> findAllByDepartment(Department department);
}
