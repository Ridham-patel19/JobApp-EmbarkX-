package com.RpJob.demo.Review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}/review")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable int companyId , @RequestBody Review review){
        boolean isAdded = service.addReview(companyId , review);
        if(!isAdded){
            return new ResponseEntity<>("There is an erroe while adding a review" , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Added" , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllByCompany(@PathVariable int companyId){
        List<Review> reviews = service.getAllByCompany(companyId);

        return new ResponseEntity<>(reviews , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable int companyId ,
                                               @PathVariable int id ,
                                               @RequestBody Review review){
        boolean isUpdated = service.updateReview(companyId , id, review);

        if(!isUpdated){
            return new ResponseEntity<>("not Updated" , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(" Updated" , HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteReview(@PathVariable int companyId , @PathVariable int id ){
        boolean isDeleted = service.deleteReview(companyId , id);

        if(!isDeleted){
            return new ResponseEntity<>("Not deleted" , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(" deleted" , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(@PathVariable int companyId , @PathVariable int id){
        Review r = service.getById(companyId , id);

        return new ResponseEntity<>(r , HttpStatus.FOUND);
    }


}
