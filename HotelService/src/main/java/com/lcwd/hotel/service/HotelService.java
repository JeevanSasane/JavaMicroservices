package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotel(Long hotelId);

    List<Hotel> getAllHotels();
}
