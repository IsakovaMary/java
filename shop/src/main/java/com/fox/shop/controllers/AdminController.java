package com.fox.shop.controllers;

import com.fox.shop.models.Item;
import com.fox.shop.models.User;
import com.fox.shop.repo.ItemRepository;
import com.fox.shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/admin/user-{id}")
    public String userReviews(@PathVariable(value = "id") long id, Model model) {
        User user = userRepository.findById(id).orElse(new User());
        Iterable<Item> items = user.getItems();
        model.addAttribute("items", items);
        model.addAttribute("user", user);
        return "user-items";
    }

    @PostMapping("/admin/user-{id}/delete")
    public String userDelete(@PathVariable(value = "id") long id) {
        User user = userRepository.findById(id).orElse(new User());
        userRepository.delete(user);
        return "redirect:/admin";
    }
}