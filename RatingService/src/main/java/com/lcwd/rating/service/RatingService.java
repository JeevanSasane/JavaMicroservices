package com.lcwd.rating.service;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {


    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(Long userId);

    List<Rating> getRatingByHotelId(Long hotelId);


}
