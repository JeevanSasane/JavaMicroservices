package com.lcws.user.service.controller;

import com.lcws.user.service.entites.User;
import com.lcws.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1= userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    int retryCount=1;

    @GetMapping("/getUser/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        System.out.println("Retry count"+retryCount);
        retryCount++;
        User user= userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBackForAll")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUser();
        return ResponseEntity.ok(users);
    }


    // Rating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallBack(Long userId,Exception ex){

        System.out.println("fallback is executed because service is down: "+ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This is Dummy user"). build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallBackForAll(Exception ex){
        System.out.println("fallback is executed because service is down: "+ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This is Dummy user"). build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping("/currentUser")
    public String getLoginUser(Principal principal){
        return principal.getName();
    }


}

















