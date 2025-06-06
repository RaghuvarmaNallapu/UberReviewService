package com.example.UberReviewService.services;


import com.example.UberReviewService.models.review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository repository;

    public ReviewService( ReviewRepository repository){
        this.repository= repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************************");
        review r = review.builder().content("Nice ride with uber and execellent").rating(4.5).build();
        System.out.println(r);
        repository.save(r);
    }

}
