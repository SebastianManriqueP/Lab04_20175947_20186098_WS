package com.example.lab04_ws.repository;

import com.example.lab04_ws.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
