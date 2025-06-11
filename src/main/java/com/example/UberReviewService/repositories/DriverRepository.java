package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository  extends JpaRepository<Driver, Long> {

    @Query(value = "SELECT p.id, p.name, COUNT(b.id) AS booking_count " +
            "FROM driver p " +
            "LEFT JOIN booking b ON b.driver_id = p.id " +
            "GROUP BY p.id, p.name", nativeQuery = true)
    List<Object[]> findPassengerBookingCounts();
}
    