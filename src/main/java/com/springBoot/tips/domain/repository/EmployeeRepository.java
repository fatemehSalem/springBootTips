package com.springBoot.tips.domain.repository;

import com.springBoot.tips.domain.EmployeeNameAndSalary;
import com.springBoot.tips.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    List<EmployeeNameAndSalary> findAllBy();
}
