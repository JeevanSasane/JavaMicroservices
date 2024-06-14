package com.lcws.user.service.service.imp;

import com.lcws.user.service.entites.Hotel;
import com.lcws.user.service.entites.Rating;
import com.lcws.user.service.entites.User;
import com.lcws.user.service.exceptions.ResourceNotFoundException;
import com.lcws.user.service.external.services.HotelService;
import com.lcws.user.service.repositories.UserRepository;
import com.lcws.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users=userRepository.findAll();
        users.forEach(user->{
            Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/getAllRatingsByUserId/"+user.getId(), Rating[].class);
            System.out.println("ratings-"+ratings);
            List<Rating> ratingsList= Arrays.stream(ratings).toList().stream().map(rating->{
//                ResponseEntity<Hotel> hotelResponseEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.getHotelId(), Hotel.class);
//                ResponseEntity<Hotel> hotelResponseEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.getHotelId(), Hotel.class);
                Hotel hotel=hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratingsList);
        });
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User With given Id is not found on server !!:"+userId)
        );

        Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/getAllRatingsByUserId/"+userId, Rating[].class);
        System.out.println("ratings-"+ratings);
        List<Rating> ratingsList = Arrays.stream(ratings).toList().stream().map(rating->{
//            ResponseEntity<Hotel> hotelResponseEntity= restTemplate.getForEntity("http://localhost:8082/hotels/getHotel/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel=hotelResponseEntity.getBody();

            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingsList);
        return user;
    }
}

























