package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmployeesWithNameEqualsTo(@Param("LASTNAME") String lastName);

    @Query
    List<Employee> retrieveEmployeeContainsArg(@Param("ARG") String arg);
}