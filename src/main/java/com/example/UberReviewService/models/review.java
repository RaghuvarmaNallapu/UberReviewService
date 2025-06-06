package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false)
    Date createdAt;

    @Column(nullable = false)
    Date updatedAt;



}
