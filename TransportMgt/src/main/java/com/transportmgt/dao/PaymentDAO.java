package com.transportmgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportmgt.dto.PaymentDTO;
import com.transportmgt.dto.UserDTO;

public interface PaymentDAO extends JpaRepository<PaymentDTO, Long> {
	
	public PaymentDTO findById(long id);
	public List<PaymentDTO> findByEmail(String email);

}
