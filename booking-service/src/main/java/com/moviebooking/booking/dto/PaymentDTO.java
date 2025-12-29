package com.moviebooking.booking.dto;

import lombok.Data;

@Data
public class PaymentDTO {
	private Long paymentId;
	private double amount;
	private String method;
}
