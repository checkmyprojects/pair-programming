package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import com.example.pairprogramming.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarsServiceImplements implements ICarsService{

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<Cars> findAll() {

        return (List<Cars>) carsRepository.findAll() ;
    }

    @Override
    public void save(Cars cars)
    {carsRepository.save(cars);

    }

    @Override
    public Cars findById(Long id) {
        return carsRepository.findById(id).orElse(null);

    }

    @Override
    public void delete(Long id) { carsRepository.deleteById(id);

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
