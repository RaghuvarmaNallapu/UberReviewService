package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
