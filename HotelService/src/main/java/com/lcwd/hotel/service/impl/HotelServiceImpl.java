package com.lcwd.hotel.service.impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Resource Not Found Exception with given Id"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
