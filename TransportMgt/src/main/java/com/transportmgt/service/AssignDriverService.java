package com.transportmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.transportmgt.dao.AssignDriverDAO;
import com.transportmgt.dto.AssignDriverDTO;
import com.transportmgt.exception.RecordNotFoundException;

@Service
public class AssignDriverService {

	
	@Autowired
	public AssignDriverDAO repository;

	public ResponseEntity<?> Add(AssignDriverDTO entity) {
		AssignDriverDTO cEntity = null;
		try {
			
				cEntity = repository.save(entity);
			
		} catch (Exception e) {

			throw new RecordNotFoundException("Something went wrong..");
		}
		return new ResponseEntity<>(cEntity, HttpStatus.OK);
	}

	
	public List<AssignDriverDTO> list() {
		List<AssignDriverDTO> list = null;

		list = repository.findAll();

		return list;
	}

	public AssignDriverDTO update(AssignDriverDTO user) {

		AssignDriverDTO entity = repository.saveAndFlush(user);
		return entity;
	}

	public List<AssignDriverDTO> delete(long id) {
		List<AssignDriverDTO> list = null;
		if (findById(id) != null) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			throw new RecordNotFoundException("Not a valid user id");
		}
		return list;
	}

	public AssignDriverDTO findById(long id) {
		try {
			if (id > 0) {
				AssignDriverDTO entity = repository.findById(id);
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
