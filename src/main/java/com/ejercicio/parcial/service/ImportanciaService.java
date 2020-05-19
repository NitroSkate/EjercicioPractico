package com.ejercicio.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ejercicio.parcial.domain.Importancia;

public interface ImportanciaService {
	public List<Importancia>findAll() throws DataAccessException;
}
