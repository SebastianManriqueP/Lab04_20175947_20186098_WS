package com.example.lab04_ws.controller;

import com.example.lab04_ws.entities.Employees;
import com.example.lab04_ws.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.core.io.ByteArrayResource;


import java.lang.StringBuilder;
@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/listar")
    List<Employees> listarEmployees(){return employeesRepository.findAll();}

    @GetMapping("/descargarListaTrabajadores")
    public ResponseEntity<String> descargarListaTrabajadores() {
        List<Employees> listaTrabajadores = employeesRepository.findAllExceptPresident();
        StringBuilder stringBuilder = new StringBuilder();
        for (Employees employee : listaTrabajadores) {
            stringBuilder.append(employee.toString()).append("\n");
        }
        String content = stringBuilder.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDisposition(ContentDisposition.parse("attachment; filename=listaDeTrabajadores.txt"));

        return ResponseEntity.ok().headers(headers).body(content);
    }
    @GetMapping("/buscar")
    Optional<Employees> buscarEmployees(@RequestParam("id") Integer id){
        return employeesRepository.findById(id);}

}
