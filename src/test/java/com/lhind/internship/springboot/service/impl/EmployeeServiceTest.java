package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.exception.EmployeeNotFoundException;
import com.lhind.internship.springboot.model.dto.EmployeeDTO;
import com.lhind.internship.springboot.model.entity.Employee;
import com.lhind.internship.springboot.repository.EmployeeRepository;
import com.lhind.internship.springboot.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void loadEmployeeByIdEmployeeIsFound() throws EmployeeNotFoundException {
        final Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Mariol");
        employee.setLastName("Ballaj");
        Mockito.doReturn(Optional.of(employee)).when(employeeRepository).findById(1L);
        final EmployeeDTO result = employeeService.loadById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("Mariol", result.getFirstName());
    }

    @Test
    void loadEmployeeByIdEmployeeIsNotFound() {
        Assertions.assertThrows(ChangeSetPersister.NotFoundException.class, () -> employeeService.loadById(1L));
    }

}