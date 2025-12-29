package com.moviebooking.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.user.dto.UserLoginDTO;
import com.moviebooking.user.dto.UserRegisterDTO;
import com.moviebooking.user.entity.User;
import com.moviebooking.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
   @Autowired
   UserService service;
   
   @GetMapping("/{userId}/bookings")
   public List<String> getUserBookings(@PathVariable Long userId){
	   return service.getUserBookings(userId);
   }
   
   @PostMapping("/register")
   public User register(@RequestBody UserRegisterDTO dto)
   {
	   return service.register(dto);
   }
   
   @PostMapping("/login")
   public User login(@RequestBody UserLoginDTO dto)
   {
	   return service.login(dto);
   }
   
   @GetMapping("/{id}")
   public User getUser(@PathVariable Long id)
   {
	   return service.getUser(id);
   }
   
}
