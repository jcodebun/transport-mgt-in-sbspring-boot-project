package com.transportmgt.form;

import javax.validation.constraints.NotEmpty;

import com.transportmgt.dto.TransportDTO;
import com.transportmgt.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportForm extends BaseForm{
	
	@NotEmpty(message = "Transport name is required")
	private String name;

	@NotEmpty(message = "Transport type is required")
	private String type;
	
	@NotEmpty(message = "Number is required")
	private String number;
	
	@NotEmpty(message = "Storage is required")
	private String storage;
	
	private String price;
	
	public TransportDTO getDTO() {
		TransportDTO bean=new TransportDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setNumber(number);
		bean.setType(type);
		bean.setStorage(storage);
		bean.setPrice(DataUtility.getLong(price));
		return bean;
	}

	public void populate(TransportDTO bean) {
		id = bean.getId();
        name = bean.getName();
        number = bean.getName();
        type = bean.getType();
        storage = bean.getStorage();
        price = DataUtility.getStringData(bean.getPrice());

	}


	

}
