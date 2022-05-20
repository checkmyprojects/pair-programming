package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public void save(User users);

    public User findById(Long id);
    public void delete(Long id);
    List<Cars> listCars();
    public User findByUsername(String username);
}
