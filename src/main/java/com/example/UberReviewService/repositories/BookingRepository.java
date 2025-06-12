package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select b from Booking b where b.driver.id IN :driverId")
    List<Booking> findBookingByDriverId(List<Long> driverId);
}
