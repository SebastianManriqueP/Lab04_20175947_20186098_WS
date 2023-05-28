package com.example.lab04_ws.controller;

import com.example.lab04_ws.entities.Employees;
import com.example.lab04_ws.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/listar")
    List<Employees> listarEmployees(){return employeesRepository.findAll();}
}