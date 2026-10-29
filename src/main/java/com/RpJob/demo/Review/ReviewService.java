package com.RpJob.demo.Review;

import java.util.List;

public interface ReviewService {
    boolean addReview(int companyId , Review review);

    List<Review> getAllByCompany(int companyId);

    boolean updateReview(int companyId, int id,Review review);

    boolean deleteReview(int companyId, int id);

    Review getById(int companyId, int id);
}
