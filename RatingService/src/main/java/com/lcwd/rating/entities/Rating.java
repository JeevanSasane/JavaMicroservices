package com.lcwd.rating.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    private Long userId;

    private Long hotelId;

    private Integer rating;

    private String feedback;




}
