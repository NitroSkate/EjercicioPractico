package com.ejercicio.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ejercicio.parcial.domain.Importancia;

public interface ImportanciaDAO {
	
	public List<Importancia>findAll() throws DataAccessException;

}
