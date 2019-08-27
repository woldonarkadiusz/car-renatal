package com.carrental.service;

import com.carrental.domain.model.Giveback;
import com.carrental.domain.repository.GivebackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GivebackService {

    private final GivebackRepository givebackRepository;

    public void createGiveback (Giveback giveback) { givebackRepository.save(giveback); }

    public List<Giveback> getAllGivebacks() {
        return givebackRepository.findAll();
    }

    public Optional<Giveback> getGivebackById(Integer id) { return givebackRepository.findById(id); }

    public void editGiveback(Giveback giveback) { givebackRepository.save(giveback); }

    public void deleteById(Integer id) { givebackRepository.deleteById(id); }
}
