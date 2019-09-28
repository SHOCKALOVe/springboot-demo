package com.example.springbootdemo.service;

import com.example.springbootdemo.domain.Employee;
import com.example.springbootdemo.exception.UnprocessableException;
import com.example.springbootdemo.repository.EmployeeReposittory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeService {
    @Autowired private EmployeeReposittory reposittory;

    public Employee get(Integer id){
        Employee employee = this.reposittory.get(id);
        if (employee == null){
            throw  new UnprocessableException("this id  not found.");
        }
        return this.reposittory.get(id);
    }

    @Transactional
    public void save(Employee employee){
        this.reposittory.save(employee);
    }

    @Transactional
    public void update(Integer id,Employee param){
        Employee employee = get(id);
        if (employee == null){
            throw new UnprocessableException("Not found id");
        }

        employee.setFirstName(param.getFirstName());
        employee.setLastName(param.getLastName());

        reposittory.save(employee);
    }

    public List<Employee> list(){
        return  this.reposittory.list();
    }

    @Transactional
    public void delete(Integer id){
        Employee employee = get(id);
        if (employee == null){
            throw new UnprocessableException("Not found id");
        }

        this.reposittory.delete(employee);

    }
}
