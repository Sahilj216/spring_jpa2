package com.ttn.service;

import com.ttn.dto.EmployeeQ2Dto;
import com.ttn.dto.EmployeeSalaryDto;
import com.ttn.entities.Employee;
import com.ttn.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<EmployeeSalaryDto> getEmployeeName() {
        return employeeRepository.customFinder1();
    }

    public void updateSalary(Float salary) {
        List<Employee> employee = employeeRepository.findLessThanAvgSalary();
        List<Employee> list = employee.stream().map(e -> {
            e.setSalary(salary);
            return e;
        }).toList();
        employeeRepository.saveAll(list);
    }

    public void deleteMinSalaryEmployee() {
        employeeRepository.deleteEmployeeByMinSalary();
    }

    public List<EmployeeQ2Dto> getStartingWith() {
        return employeeRepository.findEmployeeStartingWith()
                .stream().map(emp -> new EmployeeQ2Dto(
                        ((Number) emp[0]).longValue(),
                        ((String) emp[1]),
                        ((Number) emp[2]).intValue()
                )).toList();
    }

    public long deleteEmployeeByAge(int age){
        return employeeRepository.deleteEmployeeGreaterThan(age);
    }

}
