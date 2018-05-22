package com.hamp.app.models.service;

import java.util.List;

import com.hamp.app.models.entity.Ruta;

public interface IRutaService {

	public List<Ruta> findAll();
	public void save(Ruta t);
	public Ruta findOne(Long t);
	public void delete(Long t);
}
