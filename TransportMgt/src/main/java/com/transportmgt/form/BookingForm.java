package com.transportmgt.form;

import javax.persistence.Column;

import com.transportmgt.dto.BookingDTO;
import com.transportmgt.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingForm extends BaseForm {
	
	
	private String userId;
	
	private String transportId;
	
	private String transportName;
	
	private String transportNumber;
	
	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private String numberOfHours;
	
	
	
	
	public BookingDTO getDTO() {
		BookingDTO bean = new BookingDTO();
		bean.setId(id);
		bean.setUserId(DataUtility.getLong(userId));
		bean.setTransportId(DataUtility.getLong(transportId));
	    bean.setFirstName(firstName);
	    bean.setLastName(lastName);
	    bean.setEmail(email);
	    bean.setPhoneNumber(phoneNumber);
	    bean.setNumberOfHours(numberOfHours);
	    bean.setTransportName(transportName);
	    bean.setTransportNumber(transportNumber);
	    

		return bean;
	}

	public void populate(BookingDTO bean) {
		id = bean.getId();
        userId = DataUtility.getStringData(bean.getUserId());
        transportId = DataUtility.getStringData(bean.getTransportId());
        firstName = bean.getFirstName();
        lastName = bean.getLastName();
        email  = bean.getEmail();
        phoneNumber = bean.getPhoneNumber();
        numberOfHours = bean.getNumberOfHours();
        transportName = bean.getTransportName();
        transportNumber = bean.getTransportNumber();

	}

}


