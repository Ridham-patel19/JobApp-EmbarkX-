package com.RpJob.demo.Company;
import java.util.List;
public interface CompanyService {
    boolean addCompany(Company company);

    List<Company> getAllCompany();

    boolean updateJob(int id, Company company);

    Company getById(int id);

    boolean deleteCompany(int id);
}
