package com.example.lab04_ws.repository;

import com.example.lab04_ws.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
