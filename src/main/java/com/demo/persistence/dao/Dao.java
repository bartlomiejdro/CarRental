package com.demo.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface Dao<T, K extends Serializable> {

    T save(T entity);

    T getOne(K id);

    T findOne(K id);

    List<T> findAll();

    T update(T entity);

    void delete(T entity);

    void delete(K id);

    void deleteAll();

    long count();

    boolean exists(K id);

	EntityManager getEM();
}
