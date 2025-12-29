package com.moviebooking.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.payment.dto.PaymentRequestDTO;
import com.moviebooking.payment.entity.Payment;
import com.moviebooking.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/pay")
	public Payment makePayment(@RequestBody PaymentRequestDTO request) {
		return paymentService.makePayment(request);
	}
	@GetMapping("/{paymentId}")
	public Payment getPayment(@PathVariable Long paymentId) {
		return paymentService.getPayment(paymentId);
	}
}
