package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.EmployeeDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> loadAll();

    EmployeeDTO loadById(Long id) throws ChangeSetPersister.NotFoundException;

    EmployeeDTO storeEmployee(EmployeeDTO employeeDTO);
}
