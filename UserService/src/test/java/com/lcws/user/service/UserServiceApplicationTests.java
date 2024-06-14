package com.lcws.user.service;

import com.lcws.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private RatingService ratingService;


//	@Test
//	void createRating(){
//		Rating rating=Rating.builder().rating(10).userId(2L).hotelId(3L).feedback("Testing").build();
//		Rating rating1 = ratingService.createRating(rating);
//		System.out.println("rating1--"+rating1);
//	}


}
