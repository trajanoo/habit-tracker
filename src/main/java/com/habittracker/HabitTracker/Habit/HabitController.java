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
    public String adicionarHabito() {
        return "Hábito adicionado com sucesso";
    }

    // Read:
    @GetMapping("/listar")
    public List<HabitModel> listarHabitos() {
        return habitService.listarHabitos();
    }

    // Read (id)
    @GetMapping("/listar/{id}")
    public HabitModel listarPorID(@PathVariable Long id) {
        return habitService.listarHabitosPorID(id);
    }

    // Update
    @PutMapping("/alterar")
    public String alterarHabito() {
        return "Hábito alterado com sucesso";
    }

    @DeleteMapping("/remover")
    public String removerHabito() {
        return "Hábito removido com sucesso";
    }
}
