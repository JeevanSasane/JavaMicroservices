package com.lcws.user.service.entites;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {

    private Long ratingId;

    private Long userId;

    private Long hotelId;

    private Integer rating;

    private String feedback;

    private Hotel hotel;

}










