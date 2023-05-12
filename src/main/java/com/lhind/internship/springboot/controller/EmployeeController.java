package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.exception.EmployeeNotFoundException;
import com.lhind.internship.springboot.model.dto.EmployeeDTO;
import com.lhind.internship.springboot.service.EmployeeService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@Schema
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize(value = "hasAnyRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok(employeeService.loadAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") Long id) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.loadById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeeDTO> storeEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.status(201).body(employeeService.storeEmployee(employeeDTO));
    }
}
