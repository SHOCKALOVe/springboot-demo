package com.example.springbootdemo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    public Employee() {
    }
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id @GeneratedValue @Column(name = "ID") private  Integer id;

   @Column(name = "FIRST_NAME") private String firstName;

   @Column(name = "LAST_NAME") private  String lastName;
}
