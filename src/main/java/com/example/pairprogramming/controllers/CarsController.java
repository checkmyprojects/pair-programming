package com.example.pairprogramming.controllers;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import com.example.pairprogramming.service.ICarsService;
import com.example.pairprogramming.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/cars")

public class CarsController {
    @Autowired
    private ICarsService carsService;

    @Autowired
    private IUserService userService;


    @GetMapping("/")
    public String listCars (Model model){
        List<Cars> listOfCars  = carsService.findAll();

        model.addAttribute("title", "List of Cars");
        model.addAttribute("cars", listOfCars );
        return "/views/admin/list";
    }

    @GetMapping("/create")
    public String createNewCar (Model model){

        Cars cars = new Cars();

        model.addAttribute("title", "Form: New Cars");
        model.addAttribute("cars", cars );

        return "/views/admin/frmCreate";
    }

    @PostMapping("/save")
    public String saveCar(@Valid @ModelAttribute Cars cars, BindingResult result,
                            Model model, RedirectAttributes attribute){

        if (result.hasErrors()){
            model.addAttribute("title", "Form: New Car");
            model.addAttribute("cars", cars);
            System.out.println("Errors with the form");

            return "/views/admin/frmCreate";
        }

        carsService.save(cars);
        System.out.println("Successfully saved!");
        attribute.addFlashAttribute("success","Successfully saved");
        return "redirect:/views/admin/";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable("id") Long idCars, Model model,
                             RedirectAttributes attribute){

        Cars cars = null;

        if(idCars > 0) {
            cars = carsService.findById(idCars);

            if(cars == null){
                System.out.println("Error: The ID doesn't exist!");
                attribute.addFlashAttribute("error","Attention: The ID doesn't exist!");
                return "redirect:/views/admin/";
            }
        }else {
            System.out.println("Error: Problem whit ID!");
            attribute.addFlashAttribute("error","Attention: Error with the indicate ID!");
            return "redirect:/views/admin/";
        }


        model.addAttribute("title", "Form: Edit Cars");
        model.addAttribute("cars", cars);


        return "/views/admin/frmCreate";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar (@PathVariable("id") Long idCars, RedirectAttributes attribute){
        Cars cars = null;

        if(idCars > 0) {
            cars = carsService.findById(idCars);

            if(cars == null){
                System.out.println("Error: The ID doesn't not exist!");
                attribute.addFlashAttribute("error","Attention: The ID doesn't exist!");
                return "redirect:/views/admin/";
            }
        }else {
            System.out.println("Error: Error with the indicated ID!");
            attribute.addFlashAttribute("error","Attention: Error with the indicated ID!");
            return "redirect:/views/admin/";
        }

        carsService.delete(idCars);
        System.out.println("Successfully Removed!");
        attribute.addFlashAttribute("warning","Successfully Removed!");

        return "redirect:/views/admin/";
    }
    @GetMapping("/users")
    public String findAllUsers(Model model){
        List<User> listOfUsers = userService.findAll();

        model.addAttribute("title", "List of users");
        model.addAttribute("users", listOfUsers);
        return "/views/admin/listUsers";
    }
}
