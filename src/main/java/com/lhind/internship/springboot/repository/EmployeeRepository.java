package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE first_name = :firstName", nativeQuery = true)
    List<Employee> findByFirstName(String firstName);

    Optional<Employee> findByUsername(String username);

}
