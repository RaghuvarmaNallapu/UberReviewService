package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository repository;

    private DriverRepository driverRepository;

    private BookingRepository bookingRepository;

    public ReviewService( ReviewRepository repository, DriverRepository driverRepository,BookingRepository bookingRepository){
        this.repository= repository;
        this.driverRepository = driverRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************************");
        Review r = Review.builder().content("Nice ride with uber and execellent").rating(4.5).build();
        System.out.println(r);
        repository.save(r);

        Optional<Driver> d = driverRepository.findById(101L);
        d.ifPresent(driver -> System.out.println("PassengerName" + driver.getName() + "LicenseNo :  " + driver.getLicenseNumber() + "Bookings : " + driver.getBookings()));


        List<Long> driverIds = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        List<Booking> b = bookingRepository.findBookingByDriverId(driverIds);

        for(Booking booking : b){
            System.out.println("Booking ID: " + booking.getId() + "Driver ID: " + booking.getDriver().getId() + "Status: " + booking.getBookingstatus());
        }


        //SUBSELECT EXAMPLE
        List<Long> driversList = Arrays.asList(101L,102L,103L,104L,105L);
        List<Driver> Drivers = driverRepository.findDriverByIdsIn(driversList);

        for (Driver driver : Drivers){
            List<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getBookingstatus()));
        }

    }

}
