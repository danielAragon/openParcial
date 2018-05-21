package com.hamp.app.models.service;

import java.util.List;

public interface IService<T> {
	public List<T> findAll();
	public void save(T t);
	public T findOne(Long t);
	public void delete(Long t);
}
