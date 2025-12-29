package com.moviebooking.user.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long userid;
   private String name;
   @Column(unique=true)
   private String password;
   private String phone;
   private String email;
    public User() {
	super();
    }
	public User(Long userid, String name, String password, String phone, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email=email;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}  
}
