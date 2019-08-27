package com.carrental.service;

import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.domain.repository.CarRepository;
import com.carrental.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final DepartmentService departmentService;

    public void createCar(Car car){ carRepository.save(car); }

    public void createCar(Car car, Integer departmentId){

        Optional<Department> department = departmentService.getDepartmentById(departmentId);

        department.ifPresent(car::setDepartment);

        carRepository.save(car);
    }

    public List<Car> getAllCars(){ return carRepository.findAll(); }

    public List<Car> getAllCarsById(Department department) {

			return carRepository.findAllByDepartment(department);
    }

    public Optional<Car> getCarById(Integer id){
        return carRepository.findById(id);
    }

    public void editCar (Car car){
        carRepository.save(car);
    }

    public void deleteById (Integer id){
        carRepository.deleteById(id);
    }

}
