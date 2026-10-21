package com.transportmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transportmgt.dao.BookingDAO;
import com.transportmgt.dto.BookingDTO;
import com.transportmgt.exception.RecordNotFoundException;

@Service
public class BookingService {
	
	@Autowired
	public BookingDAO repository;

	public ResponseEntity<?> Add(BookingDTO entity) {
		BookingDTO cEntity = null;
		try {
			
				cEntity = repository.save(entity);
			
		} catch (Exception e) {

			throw new RecordNotFoundException("Something went wrong..");
		}
		return new ResponseEntity<>(cEntity, HttpStatus.OK);
	}

	
	public List<BookingDTO> list() {
		List<BookingDTO> list = null;

		list = repository.findAll();

		return list;
	}

	public BookingDTO update(BookingDTO user) {

		BookingDTO entity = repository.saveAndFlush(user);
		return entity;
	}

	public List<BookingDTO> delete(long id) {
		List<BookingDTO> list = null;
		if (findById(id) != null) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			throw new RecordNotFoundException("Not a valid user id");
		}
		return list;
	}

	public BookingDTO findById(long id) {
		try {
			if (id > 0) {
				BookingDTO entity = repository.findById(id);
				if (entity == null) {
					throw new RecordNotFoundException("Record not found");

				} else {
					return entity;
				}
			} else {
				throw new RecordNotFoundException("Not a valid user id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RecordNotFoundException("Record not found");
		}
	}
	

}
