package com.lcws.user.service.repositories;

import com.lcws.user.service.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
