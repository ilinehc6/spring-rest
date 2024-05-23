package com.example.ems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.service.EmpolyeeService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ems.dto.EmployeeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private EmpolyeeService empolyeeService;

    //Build Add employee rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = empolyeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    // Build Get employee rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        EmployeeDto employeeDto = empolyeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }

    // Build Get all employees rest API
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = empolyeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Build Update employee rest API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, 
                    @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeDto = empolyeeService.updateEmployee(id, employeeDto);
        
        return ResponseEntity.ok(updatedEmployeeDto);
    }
    
    @DeleteMapping("{id}")
    // Build Delete employee rest API
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        empolyeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
