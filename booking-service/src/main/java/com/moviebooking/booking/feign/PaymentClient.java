package com.moviebooking.booking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moviebooking.booking.dto.PaymentDTO;


@FeignClient(name="payment-service", url="http://localhost:8005")
public interface PaymentClient {
	@PostMapping("/payments/pay")
	PaymentDTO makePayment(@RequestBody PaymentDTO request);
}
