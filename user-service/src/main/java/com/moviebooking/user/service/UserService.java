package com.moviebooking.user.service;

import java.util.List;

import com.moviebooking.user.dto.UserLoginDTO;
import com.moviebooking.user.dto.UserRegisterDTO;
import com.moviebooking.user.entity.User;

public interface UserService {
	
	List<String> getUserBookings(Long id);
      User register(UserRegisterDTO dto);
      User login(UserLoginDTO dto);
      User getUser(Long id);
}
