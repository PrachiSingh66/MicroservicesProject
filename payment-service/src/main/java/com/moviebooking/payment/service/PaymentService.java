package com.moviebooking.payment.service;

import com.moviebooking.payment.dto.PaymentRequestDTO;
import com.moviebooking.payment.entity.Payment;

public interface PaymentService {
	Payment makePayment(PaymentRequestDTO request);
	Payment getPayment(Long paymentId);
}

