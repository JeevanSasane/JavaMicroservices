package com.lcws.user.service.external.services;

import com.lcws.user.service.entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings/createRating")
    Rating createRating(@RequestBody Rating rating);

    @PutMapping("/ratings/createRating/{ratingId}")
    Rating updateRating(@PathVariable Long ratingId, @RequestBody Rating rating);

    @DeleteMapping("/ratings/deleteRating/{ratingId}")
    void deleteRating(Long ratingId);

}























