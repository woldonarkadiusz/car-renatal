package com.carrental.controller;

import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.service.CarService;
import com.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
@Slf4j
public class CarController {

    private final CarService carService;
    private final DepartmentService departmentService;

    @GetMapping("/create")
    public String createCarForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments",departments);
        model.addAttribute("car", new Car());
        return "car/form";
    }

    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult result, Model model) {
        if(result.hasErrors()){
            List<Department> departments = departmentService.getAllDepartments();
            model.addAttribute("departments",departments);

            return "car/form";
        }
        carService.createCar(car);
        log.info("Created new car {}", car);

        return "redirect:/car/list";
    }

    @GetMapping("/create/{departmentId}")
    public String createCarFormWithId(@PathVariable("departmentId") Integer departmentId, Model model) {

        model.addAttribute("departmentId", departmentId);
        model.addAttribute("car", new Car());
        return "car/form-with-id";
    }

    @PostMapping("/create/{departmentId}")
    public String createCarFormWithId(@ModelAttribute("car") Car car, @PathVariable("departmentId") Integer departmentId) {
        carService.createCar(car, departmentId);
        log.info("Created new car {}", car);

        return "redirect:/car/list";
    }

    @GetMapping("/list")
    public String carList(Model model) {
        List<Car> cars = carService.getAllCars();
        List<Department> departments = departmentService.getAllDepartments();


        model.addAttribute("cars", cars);
        return "car/list";
    }

    @GetMapping("/edit/{id}")
    public String editRentForm(@PathVariable("id") Integer id, Model model) {
        Optional<Car> maybeCar = carService.getCarById(id);
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments",departments);
        if (maybeCar.isPresent()) {
            model.addAttribute("car", maybeCar.get());
            return "car/edit-form";
        } else {
            return "redirect:/car/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCar(@ModelAttribute("car") Car car) {
        carService.editCar(car);

        return "redirect:/car/list";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/car/list";
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }
}
