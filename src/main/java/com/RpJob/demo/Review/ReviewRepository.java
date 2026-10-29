package com.RpJob.demo.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReviewRepository extends JpaRepository<Review , Integer> {


    List<Review> findByCompany_companyId(int companyId);

    Optional<Review> findByreviewIdAndCompany_companyId(int id, int companyId);
}
