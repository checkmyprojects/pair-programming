package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;

import java.util.List;

public interface ICarsService {
    public List<Cars> findAll();
    public void save(Cars cars);

    public void findById(Long id);
    public void delete(Long id);
    List<User> listUser();
    public Cars findByUsername(String username);
}
