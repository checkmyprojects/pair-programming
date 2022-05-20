package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.repository.CarsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CarsServiceImplementsTest {

    @Mock
    private CarsRepository carsRepository;

    private CarsServiceImplements underTest;

    @BeforeEach
    void setup(){
        underTest = new CarsServiceImplements(carsRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(carsRepository).findAll();
    }

    @Test
    void save() {
        Cars car = new Cars(
                "name",
                "manufacturer",
                "img",
                2000,
                4,
                1,
                "description"
        );
        underTest.save(car);

        ArgumentCaptor<Cars> carsArgumentCaptor = ArgumentCaptor.forClass(Cars.class);
        verify(carsRepository).save(carsArgumentCaptor.capture());
        Cars capturedCar = carsArgumentCaptor.getValue();
        assertThat(capturedCar).isEqualTo(car);
    }

    @Test
    void findById() {
        Cars car = new Cars(
                1L,
                "name",
                "manufacturer",
                "img",
                2000,
                4,
                1,
                "description"
        );
        underTest.findById(car.getId());
        verify(carsRepository).findById(1L);
    }

    @Test
    void delete() {
        Cars car = new Cars(
                1L,
                "name",
                "manufacturer",
                "img",
                2000,
                4,
                1,
                "description"
        );
        underTest.delete(car.getId());
        verify(carsRepository).deleteById(1L);
    }

    @Test
    void listUser() {
        Cars car = new Cars(
                1L,
                "name",
                "manufacturer",
                "img",
                2000,
                4,
                1,
                "description"
        );
        underTest.findById(car.getId());
        verify(carsRepository).findById(1L);
    }

    @Test
    void findByUsername() {
    }
}