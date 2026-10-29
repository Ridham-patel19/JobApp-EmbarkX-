package com.RpJob.demo.Review;


import com.RpJob.demo.Company.Company;
import com.RpJob.demo.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repo;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository repo, CompanyService companyService) {
        this.repo = repo;
        this.companyService = companyService;
    }


    @Override
    public boolean addReview(int companyId , Review review) {
        Company c = companyService.getById(companyId);
        if(c == null){
            return false;
        }


           review.setCompany(c);
           repo.save(review);


        return true;



    }

    @Override
    public List<Review> getAllByCompany(int companyId) {

       List<Review> reviews = repo.findByCompany_companyId(companyId);

       return reviews;


    }

    @Override
    public boolean updateReview(int companyId, int id , Review review) {

        Optional<Review> r = repo.findByreviewIdAndCompany_companyId(id , companyId);
        Company c = companyService.getById(companyId);
        if(r.isEmpty()){
            return false;
        }


        Review existingReview = r.get();

        existingReview.setReviewDescription(review.getReviewDescription());
        existingReview.setRating(review.getRating());


        repo.save(existingReview);

        return true;
    }

    @Override
    public boolean deleteReview(int companyId, int id) {

        var r = repo.findByreviewIdAndCompany_companyId(id , companyId);
        if(r.isEmpty()){
            return false;
        }

        repo.delete(r.get());
        return true;
    }

    @Override
    public Review getById(int companyId, int id) {
       var r = repo.findByreviewIdAndCompany_companyId(id , companyId).orElse(null);



       return r;
    }
}
