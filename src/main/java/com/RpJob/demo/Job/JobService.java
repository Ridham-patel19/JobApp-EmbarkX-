package com.RpJob.demo.Job;


import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {
    List<Job> getAlljobs();

    void addJob(Job job);

    boolean deleteJob(int id);

    boolean updateJob(int id, Job job);
}
