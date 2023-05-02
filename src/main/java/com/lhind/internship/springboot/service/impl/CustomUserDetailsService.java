package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.entity.Employee;
import com.lhind.internship.springboot.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(username)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    private UserDetails toUserDetails(Employee employee) {
        return User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .roles(employee.getRoles().stream().map(role -> role.getRole().name()).toArray(String[]::new))
                .build();
    }

}
