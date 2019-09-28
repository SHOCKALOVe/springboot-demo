package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list(){

        return  employeeService.list();
    }

    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable Integer id){
        return employeeService.get(id);
    }

    @PostMapping("/employees")
    public void create(@RequestBody Employee param){
        employeeService.save(param);
    }

    @PutMapping("/employees/{id}")
    public void update(@PathVariable Integer id,@RequestBody Employee param){
        employeeService.update(id,param);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.delete(id);
    }
}
