package com.lcws.user.service.service;

import com.lcws.user.service.entites.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(Long userId);


}
