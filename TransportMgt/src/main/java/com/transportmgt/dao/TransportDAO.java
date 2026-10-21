package com.transportmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportmgt.dto.TransportDTO;

public interface TransportDAO extends JpaRepository<TransportDTO, Long>{

	public TransportDTO findById(long id);
	public TransportDTO findByNumber(String number);
	
}
