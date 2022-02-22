package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> searchCompaniesContainsArg(String arg) {
        LOGGER.info("Searching companies for: " + "\"" + arg + "\"");
        List<Company> companies = companyDao.retrieveCompaniesContainsArg(arg);

        if (companies.size() == 0) {
            LOGGER.info("No companies found for: " + "\"" + arg + "\"");
        }

        return companies;
    }

    public List<Employee> searchEmployeesContainsArg(String arg) {
        LOGGER.info("Searching employees for: " + "\"" + arg + "\"");
        List<Employee> employees = employeeDao.retrieveEmployeeContainsArg(arg);

        if (employees.size() == 0) {
            LOGGER.info("No employees found for: " + "\"" + arg + "\"");
        }

        return employees;
    }
}
