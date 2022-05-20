package com.example.pairprogramming.controllers;

import com.example.pairprogramming.service.ICarsService;
import com.example.pairprogramming.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cars")

public class CarsController {
    @Autowired
    private ICarsService carsService;

    @Autowired
    private IUserService userService;
}
