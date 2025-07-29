package com.ttn.entities;

import com.ttn.entities.embeds.Compensation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeTable")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private long id;

    @Column(name = "empFirstName")
    private String firstName;

    @Column(name = "empLastName")
    private String lastName;

    @Column(name = "empSalary")
    private float salary;

    @Column(name = "empAge")
    private int age;

    @Embedded
    private Compensation compensation;

    private float taxAmount;
}
