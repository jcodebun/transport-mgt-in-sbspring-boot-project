package com.transportmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="transport")
@Getter
@Setter
public class TransportDTO extends BaseDTO{
	
	@Column(name = "name", length = 755)
	private String name;

	@Column(name = "type", length = 755)
	private String type;
	
	@Column(name = "number", length = 755)
	private String number;

	@Column(name = "storage", length = 755)
	private String storage;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@Column(name = "assignStatus")
	private boolean assignStatus;
	
	@Column(name = "bookingStatus")
	private boolean bookingStatus;



}
