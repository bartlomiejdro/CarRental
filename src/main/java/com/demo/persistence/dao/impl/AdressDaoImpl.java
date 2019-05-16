package com.demo.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.persistence.dao.AdressDao;
import com.demo.persistence.entity.AdressEntity;

@Repository
public class AdressDaoImpl extends AbstractDao<AdressEntity, Long> implements  AdressDao{

}
