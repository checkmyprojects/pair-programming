package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplements implements IUserService{


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User users) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Cars> listCars() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
