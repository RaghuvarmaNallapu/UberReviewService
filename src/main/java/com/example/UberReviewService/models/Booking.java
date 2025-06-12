package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.Date;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private Review review;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingstatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endDate;

    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
}
