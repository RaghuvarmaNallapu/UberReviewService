package com.example.UberReviewService.repositories;
import com.example.UberReviewService.models.review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<review, Long> {

}
