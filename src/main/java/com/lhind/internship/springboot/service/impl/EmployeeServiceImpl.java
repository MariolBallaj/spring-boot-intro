package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.exception.EmployeeNotFoundException;
import com.lhind.internship.springboot.model.dto.EmployeeDTO;
import com.lhind.internship.springboot.model.entity.Employee;
import com.lhind.internship.springboot.model.enums.EmploymentStatus;
import com.lhind.internship.springboot.repository.EmployeeRepository;
import com.lhind.internship.springboot.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> loadAll() {
        return employeeRepository.findAll().stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO loadById(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).map(EmployeeDTO::new).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public EmployeeDTO storeEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmploymentStatus(EmploymentStatus.ACTIVE);
        return new EmployeeDTO(employeeRepository.save(employee));
    }

}
