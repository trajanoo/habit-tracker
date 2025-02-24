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
    public List<HabitModel> getAllHabits() {
        return habitRepository.findAll();
    }

    // listar por id
    public HabitModel getHabitById(Long id) {
        Optional<HabitModel> habitOptional = habitRepository.findById(id);
        return habitOptional.orElse(null);
    }

    // criar
    public HabitModel addHabit(HabitModel habit) {
        return habitRepository.save(habit);
    }

    // alterar
    public HabitModel updateHabit(Long id, HabitModel updatedHabit) {
        Optional<HabitModel> existingHabit = habitRepository.findById(id);

        if(existingHabit.isPresent()) {
            updatedHabit.setId(id);
            return habitRepository.save(updatedHabit);
        } else {
            return null;
        }
    }

    // deletar
    public void deleteHabit(Long id) {
        if(habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
        }
    }
}
