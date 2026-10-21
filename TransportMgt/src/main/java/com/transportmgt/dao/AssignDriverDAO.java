package com.transportmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportmgt.dto.AssignDriverDTO;

public interface AssignDriverDAO extends JpaRepository<AssignDriverDTO, Long>{

	public AssignDriverDTO findById(long id);
}
