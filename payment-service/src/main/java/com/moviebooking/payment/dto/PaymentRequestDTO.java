package com.moviebooking.payment.dto;

public class PaymentRequestDTO {
	private Long bookingId;
	private double amount;
	private String method;
	public PaymentRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentRequestDTO(Long bookingId, double amount, String method) {
		super();
		this.bookingId = bookingId;
		this.amount = amount;
		this.method = method;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
