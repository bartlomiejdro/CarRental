package com.demo.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.persistence.dao.CustomerDao;
import com.demo.persistence.entity.CustomerEntity;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao{

}
