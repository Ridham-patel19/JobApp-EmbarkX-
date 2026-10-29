package com.RpJob.demo.Job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping
    public ResponseEntity<List<Job>> getAllJob(){
        return new ResponseEntity<>(jobService.getAlljobs() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
//        System.out.println(job.getJobName());
//        System.out.println(job.getCompany());
//        System.out.println(job.getCompany().getCompanyId());
        jobService.addJob(job);

        return new ResponseEntity<>("Added" , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id){
       if( jobService.deleteJob( id) ){
           return new ResponseEntity<>("Deleted" , HttpStatus.OK);
        }

        return new ResponseEntity<>("not found " , HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id , @RequestBody Job job){
        if(jobService.updateJob(id , job)){
            return new ResponseEntity<>("Updated" , HttpStatus.OK);
        }

        return new ResponseEntity<>("not found " , HttpStatus.NOT_FOUND);
    }
}
