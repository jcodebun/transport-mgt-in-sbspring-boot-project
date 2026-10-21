package com.transportmgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportmgt.dto.BookingDTO;

public interface BookingDAO extends JpaRepository<BookingDTO, Long> {
	
	public BookingDTO findById(long id);
	public List<BookingDTO> findByUserId(long id);

}
