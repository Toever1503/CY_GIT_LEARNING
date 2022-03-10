package com.example.makedatatest.repository;

import com.example.makedatatest.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}