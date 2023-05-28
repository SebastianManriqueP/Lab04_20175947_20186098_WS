package com.example.lab04_ws.repository;

import com.example.lab04_ws.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,String> {
}
