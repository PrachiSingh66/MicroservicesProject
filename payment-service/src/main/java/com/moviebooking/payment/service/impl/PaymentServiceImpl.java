package com.moviebooking.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.payment.dto.PaymentRequestDTO;
import com.moviebooking.payment.entity.Payment;
import com.moviebooking.payment.repository.PaymentRepository;
import com.moviebooking.payment.service.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment makePayment(PaymentRequestDTO request) {
		// simulate payment gateway
		String status=Math.random()>0.2?"SUCCESS":"FAILED";
		Payment payment=new Payment();
		payment.setBookingId(request.getBookingId());
		payment.setAmount(request.getAmount());
		payment.setPaymentMethod(request.getMethod());
		payment.setPaymentStatus(status);
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPayment(Long paymentId) {
		
		return paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment not found"));
		
	}

}
