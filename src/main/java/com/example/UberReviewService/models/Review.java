package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookingreview")
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    Double rating;


    @Override
    public String toString() {
        return "review{" +
                "content='" + content + '\'' +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                '}';
    }
}
