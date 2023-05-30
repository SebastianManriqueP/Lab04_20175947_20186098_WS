package com.example.lab04_ws.repository;

import com.example.lab04_ws.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM employees i join jobs z on i.job_id=z.job_id where NOT z.job_id='AD_PRES';")
    List<Employees> findAllExceptPresident();
}
