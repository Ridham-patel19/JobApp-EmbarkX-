package com.RpJob.demo.Company;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private ComapnyRepository repo;

    public CompanyServiceImpl(ComapnyRepository repo) {
        this.repo = repo;
    }


    @Override
    public boolean addCompany(Company company) {

        if(company == null){
            return false;
        }

        try{
            repo.save(company);
            return true;
        }catch(Exception e){
            System.out.println("eeror in company repo " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<Company> getAllCompany() {

       List<Company> companies = repo.findAll();
        return companies;
    }

    @Override
    public boolean updateJob(int id, Company company) {
        if(!repo.existsById(id)){
            return false;
        }
        company.setCompanyId(id);
        repo.save(company);

        return true;
    }

    @Override
    public Company getById(int id) {
      return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(int id) {
        Company c = repo.findById(id).orElse(null);

        if( c == null){
            return false;
        }

        repo.delete(c);
        return true;
    }
}
