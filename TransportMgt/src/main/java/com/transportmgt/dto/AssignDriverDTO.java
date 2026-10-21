package com.transportmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="assigndriver")
@Getter
@Setter
public class AssignDriverDTO extends BaseDTO {
	
	@Column(name = "driverId")
	private long driverId;
	
	@Column(name = "transportId")
	private long transportId;
	
	@Column(name = "driverName", length = 755)
	private String driverName;
	
	
	@Column(name = "transportNumber", length = 755)
	private String transportNumber;

}
