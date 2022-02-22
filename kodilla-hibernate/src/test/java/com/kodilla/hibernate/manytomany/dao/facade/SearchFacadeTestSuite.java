package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.facade.CompanyRetriever;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyRetriever companyRetriever;

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testShouldRetrieveCompanyContains() {
        //Given
        List<Company> companies = companyRetriever.retrieve();

        companyDao.saveAll(companies);

        //When
        List<Company> companiesResult = searchFacade.searchCompaniesContainsArg("%ata%");

        //Then
        assertEquals(companiesResult.size(), 2);
        System.out.println(companiesResult);
        //Clean up
        try {
            companyDao.deleteById(companies.get(0).getId());
            companyDao.deleteById(companies.get(1).getId());
            companyDao.deleteById(companies.get(2).getId());

        } catch (Exception e) {
            //do nothing
        }
    }
}
