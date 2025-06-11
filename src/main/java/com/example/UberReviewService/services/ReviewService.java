package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository repository;

    private DriverRepository driverRepository;

    public ReviewService( ReviewRepository repository, DriverRepository driverRepository){
        this.repository= repository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************************");
        Review r = Review.builder().content("Nice ride with uber and execellent").rating(4.5).build();
        System.out.println(r);
        repository.save(r);

        Optional<Driver> d = driverRepository.findById(101L);
        System.out.println("PassengerName" + d.get().getName() + "LicenseNo :  " + d.get().getLicenseNumber() + "Bookings : " + d.get().getBookings());

    }

}
