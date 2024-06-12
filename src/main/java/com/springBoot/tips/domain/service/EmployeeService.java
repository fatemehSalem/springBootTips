package com.springBoot.tips.domain.service;

import com.springBoot.tips.domain.projection.EmployeeName;
import com.springBoot.tips.domain.projection.EmployeeNameAndSalary;
import com.springBoot.tips.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    List<EmployeeName> names = employeeRepository.findAllBy(EmployeeName.class);
    List<EmployeeNameAndSalary> nameAndSalaries = employeeRepository.findAllBy(EmployeeNameAndSalary.class);
}
