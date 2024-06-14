package com.lcwd.rating.controller;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>>getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/getAllRatingsByUserId/{userId}")
    public ResponseEntity<List<Rating>>getAllRatingsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/getAllRatingsByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>>getAllRatingsByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
