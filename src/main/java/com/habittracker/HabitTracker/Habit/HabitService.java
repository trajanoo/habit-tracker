package com.habittracker.HabitTracker.Habit;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    // listar
    public List<HabitModel> listarHabitos() {
        return habitRepository.findAll();
    }

    // listar por id
    public HabitModel listarHabitosPorID(Long id) {
        Optional<HabitModel> habitoID = habitRepository.findById(id);
        return habitoID.orElse(null);
    }


}
