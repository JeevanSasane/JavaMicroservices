package com.lcwd.rating.repository;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    // custom finder methods;

    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);
}
