package com.transportmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking")
@Getter
@Setter
public class BookingDTO extends BaseDTO {
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "transportId")
	private long transportId;
	
	@Column(name = "transportName", length = 755)
	private String transportName;
	
	@Column(name = "transportNumber", length = 755)
	private String transportNumber;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "email", length = 755)
	private String email;
	
	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;
	
	@Column(name = "numberOfHours", length = 755)
	private String numberOfHours;
	
	@Column(name = "totalPrice")
	private long totalPrice;
	
	@Column(name = "status", length = 755)
	private String status;
	

}
