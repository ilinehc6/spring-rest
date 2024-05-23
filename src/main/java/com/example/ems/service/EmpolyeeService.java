package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmpolyeeService {
    
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employeeId);
}
