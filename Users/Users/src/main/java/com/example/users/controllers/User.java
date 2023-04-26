package com.example.users.controllers;


import com.example.users.dao.DaoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class User {
    private final DaoUser daoUser;
    public User(DaoUser daoUser){
        this.daoUser=daoUser;
    }
    @GetMapping("/user")
    public String index(Model model){
        model.addAttribute("user",daoUser.getUsers());
        return "user";
    }
    @GetMapping("/user/{id}")
    public String infoUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user",daoUser.getUserId(id));
        return "user_info";
    }
    @GetMapping("/user/add")
    public String newUser(Model model){
        model.addAttribute("user",new com.example.users.models.User());
        return "add_user";
    }
    @PostMapping("/user/add")
    public String newUser(@ModelAttribute("user")com.example.users.models.User user){
        daoUser.addUser(user);
        return "redirect:/user";
    }
    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("edit_user", daoUser.getUserId(id));
        return "edit_user";
    }
    @PostMapping("/user/edit/{id}")
    public String edit_User(@ModelAttribute("edit_user")com.example.users.models.User user, @PathVariable("id") int id){
        daoUser.updateUser(id,user);
        return "redirect:/user";
    }
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        daoUser.deleteUser(id);
        return "redirect:/user";
    }
//    @POSTMapping("/user/delete/{id}")
//    public String deleteUser(@ModelAttribute("user")com.example.users.models.User user){
//        daoUser.deleteUser(user);
//        return "redirect:/user";
//    }
}
