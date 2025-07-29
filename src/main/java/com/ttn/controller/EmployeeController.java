package com.ttn.controller;

import com.ttn.dto.EmployeeQ2Dto;
import com.ttn.dto.EmployeeSalaryDto;
import com.ttn.entities.Employee;
import com.ttn.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public void addingEmployee(@RequestBody List<Employee> employees) {
        employeeService.addEmployees(employees);
    }

    @PostMapping("/employee")
    public void addingSingleEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/employee-salary")
    public ResponseEntity<List<EmployeeSalaryDto>> getEmployeeSalaryList() {
        return ResponseEntity.ok(employeeService.getEmployeeName());
    }

    @PatchMapping("/employee-salary")
    public void updateSalary(@RequestParam Float salary) {
        employeeService.updateSalary(salary);
    }

    @DeleteMapping("/employee-min-salary")
    public void deleteEmployeeWithLessSalary() {
        employeeService.deleteMinSalaryEmployee();
    }

    @GetMapping("/employee-native-startwith")
    public ResponseEntity<List<EmployeeQ2Dto>> getStartingWith() {
        return ResponseEntity.ok(employeeService.getStartingWith());
    }

    @DeleteMapping("/employee-age")
    public ResponseEntity<Long> deleteByAge(@RequestParam Integer age) {
       return ResponseEntity.ok(employeeService.deleteEmployeeByAge(age));
    }
}
