package com.transportmgt.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.transportmgt.dao.TransportDAO;
import com.transportmgt.dto.TransportDTO;
import com.transportmgt.exception.RecordNotFoundException;

@Service
public class TransportService {
	
	@Autowired
	public TransportDAO repository;

	public ResponseEntity<?> Add(TransportDTO entity) {
		TransportDTO cEntity = null;
		try {
			TransportDTO tDto = repository.findByNumber(entity.getName());
			if (tDto == null) {
				cEntity = repository.save(entity);
			} else {
				System.out.println("Duplicate Category..");
				throw new RecordNotFoundException("Transport is already available");
			}
		} catch (Exception e) {

			throw new RecordNotFoundException("Transport is already available");
		}
		return new ResponseEntity<>(cEntity, HttpStatus.OK);
	}

	
	public List<TransportDTO> list() {
		List<TransportDTO> list = null;

		list = repository.findAll();

		return list;
	}

	public TransportDTO update(TransportDTO user) {

		TransportDTO entity = repository.saveAndFlush(user);
		return entity;
	}

	public List<TransportDTO> delete(long id) {
		List<TransportDTO> list = null;
		if (findById(id) != null) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			throw new RecordNotFoundException("Not a valid user id");
		}
		return list;
	}

	public TransportDTO findById(long id) {
		try {
			if (id > 0) {
				TransportDTO entity = repository.findById(id);
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
	
	public Blob getImageById(long id) throws SerialException, SQLException {		
		TransportDTO img = repository.findById(id);
		byte[] blob = img.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}


}
