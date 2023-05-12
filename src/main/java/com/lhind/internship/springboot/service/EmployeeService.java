package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.exception.EmployeeNotFoundException;
import com.lhind.internship.springboot.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> loadAll();

    EmployeeDTO loadById(Long id) throws EmployeeNotFoundException;

    EmployeeDTO storeEmployee(EmployeeDTO employeeDTO);
}
