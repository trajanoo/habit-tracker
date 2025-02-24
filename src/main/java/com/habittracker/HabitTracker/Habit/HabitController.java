package com.habittracker.HabitTracker.Habit;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Creates a new habit", description = "This endpoint allows the client to create a new habit in the system. The client should provide the habit details in the request body (JSON), including the habit's name and description. After the habit is created, the response will return the habit's data, including an automatically generated ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Habit added successfully!"),
            @ApiResponse(responseCode = "400", description = "Error adding habit.")
    })
    public HabitModel addHabit(@RequestBody HabitModel habit) {
        return habitService.addHabit(habit);
    }

    // Read:
    @GetMapping("/listar")
    @Operation(summary = "Retrieves all habits", description = "Retrieves a list of all habits.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of habits retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Error retrieving habits.")
    })
    public List<HabitModel> getAllHabits() {
        return habitService.getAllHabits();
    }

    // Read (id)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Retrieves a habit by its ID", description = "This endpoint allows the client to retrieve a habit by its unique ID. The ID should be provided in the path.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habit retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Habit not found for the provided ID.")
    })
    public HabitModel getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }

    // Update
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Updates a habit", description = "This endpoint allows the client to update an existing habit by providing the habit's ID and the updated details in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habit updated successfully."),
            @ApiResponse(responseCode = "404", description = "Habit not found for the provided ID."),
            @ApiResponse(responseCode = "400", description = "Invalid habit data.")
    })
    public HabitModel updateHabit(@PathVariable Long id, @RequestBody HabitModel novoHabito) {
        return habitService.updateHabit(id, novoHabito);
    }

    // Delete
    @DeleteMapping("/remover/{id}")
    @Operation(summary = "Deletes a habit by its ID", description = "This endpoint allows the client to delete a habit by providing its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Habit deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Habit not found for the provided ID.")
    })
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
