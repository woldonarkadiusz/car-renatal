package com.carrental.controller;

import com.carrental.domain.model.Giveback;
import com.carrental.service.GivebackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/giveback")
@Slf4j
public class GivebackController {

    private final GivebackService givebackService;

    @GetMapping("/create")
    public String createGivebackForm(Model model) {
        model.addAttribute("giveback", new Giveback());
        return "giveback/form";
    }

    @PostMapping("/create")
    public String createGiveback(@ModelAttribute("returnCar") Giveback giveback) {
        givebackService.createGiveback(giveback);
        log.info("Created new giveback {}", giveback);

        return "redirect:/giveback/list";
    }

    @GetMapping("/list")
    public String givebackList(Model model) {
        List<Giveback> givebacks = givebackService.getAllGivebacks();

        model.addAttribute("givebacks", givebacks);
        return "giveback/list";
    }

    @GetMapping("/edit/{id}")
    public String ediGivebackForm(@PathVariable("id") Integer id, Model model) {
        Optional<Giveback> maybeGiveback = givebackService.getGivebackById(id);

        if (maybeGiveback.isPresent()) {
            model.addAttribute("giveback", maybeGiveback.get());
            return "giveback/edit-form";
        } else {
            return "redirect:/giveback/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editGiveback(@ModelAttribute("giveback") Giveback giveback) {
        givebackService.editGiveback(giveback);

        return "redirect:/giveback/list";
    }

    @GetMapping("/delete")
    public String deleteGiveback(@RequestParam("id") Integer id) {
        givebackService.deleteById(id);
        return "redirect:/giveback/list";
    }
}
