package com.example.pairprogramming.controllers;

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

@Controller
@RequestMapping ("/user")
public class UserController {
    @Autowired
    private ICarsService carsService;

    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String createANewUser (Model model) {

        User user = new User();
        /*List<Users> listUsers= usersService.listUsers();*/

        model.addAttribute("title", "Form: New User");
        model.addAttribute("user", user);
        /* model.addAttribute("users", listUsers);*/

        return "/views/user/frmUser";
    }
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result,
                           Model model, RedirectAttributes attribute){

        if (result.hasErrors()){
            model.addAttribute("title", "Form: New Event");
            model.addAttribute("user", user);
            System.out.println("Error with form");

            return "/views/user/frmUser";
        }

        userService.save(user);
        System.out.println("User Successfully saved!");
        attribute.addFlashAttribute("success","User Successfully saved!");
        return "redirect:/views/user/index";
    }

    @GetMapping("/edit/{id}")
    public String editUser (@PathVariable("id") Long idUser, Model model,
                            RedirectAttributes attribute){

        User user = null;

        if(idUser > 0) {
            user = userService.findById(idUser);

            if(user == null){
                System.out.println("Error: The indicated Id doesn't exist!");
                attribute.addFlashAttribute("error","Attention: The indicated Id doesn't exist!");
                return "redirect:/views/user/index";
            }
        }else {
            System.out.println("Error:Errors with the Id!");
            attribute.addFlashAttribute("error","Attention: Errors with the Id");
            return "redirect:/views/user/index";
        }


        model.addAttribute("title", "Form: Edit User");
        model.addAttribute("user", user);


        return "/views/user/frmUsers";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long idUsers, RedirectAttributes attribute){
        User user = null;

        if(idUsers > 0) {
            user = userService.findById(idUsers);

            if(user == null){
                System.out.println("Error:The indicated Id doesn't exist!");
                attribute.addFlashAttribute("error","Attention: The indicated Id doesn't exist!");
                return "redirect:/views/users/index";
            }
        }else {
            System.out.println("Error: Error with the Id");
            attribute.addFlashAttribute("error","Attention: error with the Id!");
            return "redirect:/views/user/index";
        }

        userService.delete(idUsers);
        System.out.println("Successfully deleted!");
        attribute.addFlashAttribute("warning","Successfully deleted!");

        return "redirect:/views/user/index";
    }
}


