package com.lcwd.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
@CrossOrigin(origins = "*")
public class StaffController {

    @GetMapping("/getStaffs")
    public ResponseEntity<List<String>> getStaffs(){
        return new ResponseEntity<>(Arrays.asList("Ram","Sham","Sheeta","Krishna"), HttpStatus.OK);
    }


}


