package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class review extends BaseModel{

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
