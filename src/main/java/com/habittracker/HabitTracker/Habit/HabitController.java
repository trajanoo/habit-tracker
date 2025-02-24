package com.habittracker.HabitTracker.Habit;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {
    private final HabitRepository habitRepository;
    private final HabitService habitService;

    public HabitController(HabitRepository habitRepository, HabitService habitService) {
        this.habitRepository = habitRepository;
        this.habitService = habitService;
    }

    // CRUD: Create, Read, Update, Delete

    // Create:
    @PostMapping("/adicionar")
    public HabitModel addHabit(@RequestBody HabitModel habit) {
        return habitService.addHabit(habit);
    }

    // Read:
    @GetMapping("/listar")
    public List<HabitModel> getAllHabits() {
        return habitService.getAllHabits();
    }

    // Read (id)
    @GetMapping("/listar/{id}")
    public HabitModel getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }

    // Update
    @PutMapping("/alterar/{id}")
    public HabitModel updateHabit(@PathVariable Long id, @RequestBody HabitModel novoHabito) {
        return habitService.updateHabit(id, novoHabito);
    }

    // Delete
    @DeleteMapping("/remover/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
