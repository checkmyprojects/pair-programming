package com.example.pairprogramming.controllers;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.repository.CarsRepository;
import com.example.pairprogramming.repository.UserRepository;
import com.example.pairprogramming.service.CarsServiceImplements;
import com.example.pairprogramming.service.UserServiceImplements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarsControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Mock
    private CarsRepository carsRepository;

    private CarsServiceImplements underTest;

    @BeforeEach
    void setup(){
        carsRepository.deleteAll();
    }


    public void addCarSample(){
        List<Cars> cars = List.of(
                new Cars(
                        "Golf",
                        "WV",
                        "img",
                        2000,
                        4,
                        1,
                        "description"
                ),
                new Cars(
                        "Leon",
                        "Seat",
                        "img",
                        2002,
                        5,
                        1,
                        "description"
                )
        );
        carsRepository.saveAll(cars);
    }

    @Test
    void listCars() {
        addCarSample();

        assertThat(carsRepository.findAll()).isEqualTo(user);



        /*mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].title", equalTo("Jurassic Park")))
                .andExpect(jsonPath("$[0].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg")))
                .andExpect(jsonPath("$[0].director", equalTo("Steven Spielberg")))
                .andExpect(jsonPath("$[0].year", equalTo(1993)))
                .andExpect(jsonPath("$[0].synopsis", equalTo("A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.")))
                .andExpect(jsonPath("$[0].renter", equalTo(null)))
                .andExpect(jsonPath("$[0].booked", equalTo(false)))
                .andExpect(jsonPath("$[1].title", equalTo("Ratatouille")))
                .andExpect(jsonPath("$[1].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/npHNjldbeTHdKKw28bJKs7lzqzj.jpg")))
                .andExpect(jsonPath("$[1].director", equalTo("Brad Bird")))
                .andExpect(jsonPath("$[1].year", equalTo(2007)))
                .andExpect(jsonPath("$[1].synopsis", equalTo("Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat.")))
                .andExpect(jsonPath("$[1].renter", equalTo(null)))
                .andExpect(jsonPath("$[1].booked", equalTo(false)))
                .andDo(print());*/
    }

    @Test
    void createNewCar() {
    }

    @Test
    void saveCar() {
    }

    @Test
    void editCar() {
    }

    @Test
    void deleteCar() {
    }

    @Test
    void findAllUsers() {
    }
}