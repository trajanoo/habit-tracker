package com.habittracker.HabitTracker.Habit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<HabitModel, Long> {
}
