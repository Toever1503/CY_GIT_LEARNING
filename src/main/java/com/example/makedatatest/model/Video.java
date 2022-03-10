package com.example.makedatatest.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "video")
@Data
@ToString
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "season", length = 6)
    private String season;

    @Column(name = "year")
    private Integer year;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "rating")
    private Integer rating;

}