package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarsServiceImplements implements ICarsService{
    @Override
    public List<Cars> findAll() {
        return null;
    }

    @Override
    public void save(Cars cars) {

    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public Cars findByUsername(String username) {
        return null;
    }
}
