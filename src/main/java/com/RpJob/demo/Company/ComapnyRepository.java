package com.RpJob.demo.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComapnyRepository extends JpaRepository<Company , Integer> {
}
