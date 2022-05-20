package com.example.pairprogramming.repository;


import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
