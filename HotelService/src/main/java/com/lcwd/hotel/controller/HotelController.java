package com.lcwd.hotel.controller;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getHotel(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}
