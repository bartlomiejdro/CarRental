package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.domain.DepartamentTO;
import com.demo.persistence.dao.DepartamentDao;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.service.DepartamentService;

@Service
public class DepartamentServiceImpl implements DepartamentService{
	
	@Autowired
	private DepartamentDao departamentRepository;
	
	@Override
	public DepartamentTO save(DepartamentTO departamentTo) {
		DepartamentEntity departament = departamentRepository.save(new DepartamentEntity(departamentTo));
		return new DepartamentTO(departament);
	}

	@Override
	public DepartamentTO findDepartamentById(Long departamentId) {
		DepartamentEntity resultEntity = departamentRepository.findOne(departamentId);		
		return resultEntity == null ? null : new DepartamentTO(resultEntity);
	}
	
	@Override
	public DepartamentTO update(Long departamentId, DepartamentTO departamentTo) {
		DepartamentEntity departament = departamentRepository.findOne(departamentId);
		departament.setAdress(departamentTo.getAdress());
		departament.setEmail(departamentTo.getEmail());
		departament.setPhoneNumber(departamentTo.getPhoneNumber());
		departamentRepository.update(departament);
		
		return new DepartamentTO(departament);
	}

	
	@Override
	public void delete(DepartamentEntity departament) {
		departamentRepository.delete(departament);
	}
}
