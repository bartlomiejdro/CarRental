package com.demo.service;

import com.demo.common.domain.DepartamentTO;
import com.demo.persistence.entity.DepartamentEntity;

public interface DepartamentService {

	DepartamentTO save(DepartamentTO departamentTo);

	DepartamentTO findDepartamentById(Long departamentId);

	 void delete(DepartamentEntity departament);

	DepartamentTO update(Long departamentId, DepartamentTO departamentTo);
}
