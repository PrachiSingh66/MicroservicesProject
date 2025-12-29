package com.moviebooking.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.user.dto.UserLoginDTO;
import com.moviebooking.user.dto.UserRegisterDTO;
import com.moviebooking.user.entity.User;
import com.moviebooking.user.feign.BookingClient;
import com.moviebooking.user.repository.UserRepository;
import com.moviebooking.user.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository repo;
	
	@Autowired
	private BookingClient bookingClient;
	public List<String> getUserBookings(Long id){
		return bookingClient.getBookingsByUser(id);
	}
	@Override
	public User register(UserRegisterDTO dto)
	{
		if(repo.findByEmail(dto.getEmail())!=null)
		{
			throw new RuntimeException("Email already registered");
		}
		User user= new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		
		return repo.save(user);
	}
	@Override
	public User login(UserLoginDTO dto) 
	{
		User user=repo.findByEmail(dto.getEmail());
		if(user==null || !user.getPassword().equals(dto.getPassword()))
		{
			throw new RuntimeException("Invalid credentials");
		}
		return user;
	}
	@Override
	public User getUser(Long id)
	{
		return repo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
	}

}

