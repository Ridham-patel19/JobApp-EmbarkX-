package com.RpJob.demo.Job;


import com.RpJob.demo.Company.ComapnyRepository;
import com.RpJob.demo.Company.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {


private JobRepository repo;
private ComapnyRepository companyRepo;


    public JobServiceImpl(JobRepository repo, ComapnyRepository companyRepo) {
        this.repo = repo;
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Job> getAlljobs() {
        return repo.findAll();
    }

    @Override
    public void addJob(Job job) {

        Company company = companyRepo.findById(job.getCompany().getCompanyId())
                .orElseThrow(() ->
                        new RuntimeException("Company not found"));

        job.setCompany(company);
        repo.save(job);
    }

    @Override
    public boolean deleteJob(int id) {
          Job job = repo.findById(id).orElse(null);

           if(job == null){
               return false;

        }

           repo.delete(job);

        return true;
    }

    @Override
    public boolean updateJob(int id, Job job) {
        Job isJob = repo.findById(id).orElse(null);

        if(isJob == null){
            return false;

        }


        isJob.setJobName(job.getJobName());
        isJob.setJobDesc(job.getJobDesc());
        isJob.setSalary(job.getSalary());
        Company company = companyRepo.findById(job.getCompany().getCompanyId())
                .orElseThrow(() ->
                        new RuntimeException("Company not found"));
        isJob.setCompany(company);
        repo.save(isJob);

        return false;
    }
}

//Iterator<Job> iterator =  jobs.iterator();
//while(iterator.hasNext()){
//Job result = iterator.next();
//            if(result.getJobId() == id){
//        result.setJobName(job.getJobName());
//        result.setJobDesc(job.getJobDesc());
//        result.setSalary(job.getSalary());
//
//        return true;
//
//        }
//
//        }
