package com.transportmgt.form;

import javax.validation.constraints.NotEmpty;

import com.transportmgt.dto.AssignDriverDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignDriverForm extends BaseForm {

	private long driverId;
	
	private long transportId;
	

	
	
	public AssignDriverDTO getDTO() {
		AssignDriverDTO bean=new AssignDriverDTO();
		bean.setId(id);
		bean.setDriverId(driverId);
		bean.setTransportId(transportId);


		return bean;
	}

	public void populate(AssignDriverDTO bean) {
		id = bean.getId();
		driverId = bean.getDriverId();
		transportId = bean.getTransportId();

    

	}
}
