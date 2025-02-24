package com.habittracker.HabitTracker.Habit;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitController {

    // CRUD: Create, Read, Update, Delete

    // Create:
    @PostMapping("/adicionar")
    public String adicionarHabito() {
        return "Hábito adicionado com sucesso";
    }

    // Read:
    @GetMapping("/listar")
    public String listarHabitos() {
        return "Hábitos listados com sucesso";
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
