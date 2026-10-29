package com.RpJob.demo.Company;


import com.RpJob.demo.Job.Job;
import com.RpJob.demo.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ToString
@Component
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;
    private String companyName;
    private String companyDescription;


    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs = new ArrayList<Job>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<Review>();

}
