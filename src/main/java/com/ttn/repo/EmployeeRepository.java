package com.ttn.repo;

import com.ttn.dto.EmployeeSalaryDto;
import com.ttn.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT NEW com.ttn.dto.EmployeeSalaryDto (e.firstName , e.lastName) FROM Employee e WHERE e.salary > (SELECT AVG(e.salary) FROM Employee e ) order by e.age,e.salary desc")
    List<EmployeeSalaryDto> customFinder1();

    @Query("SELECT e FROM Employee e WHERE e.salary < (SELECT AVG(e.salary) FROM Employee e)")
    List<Employee> findLessThanAvgSalary();

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary = (SELECT min(e.salary) FROM Employee e)")
    long deleteEmployeeByMinSalary();

    @Query(value = "SELECT emp_id,emp_first_name,emp_age FROM employee_table" +
            " WHERE emp_last_name LIKE '%singh'",nativeQuery = true)
    List<Object[]> findEmployeeStartingWith();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM employee_table WHERE emp_age = :age",nativeQuery = true)
    long deleteEmployeeGreaterThan(int age);
}