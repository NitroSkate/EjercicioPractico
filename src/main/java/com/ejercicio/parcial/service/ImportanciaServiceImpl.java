package com.ejercicio.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ejercicio.parcial.dao.ImportanciaDAO;
import com.ejercicio.parcial.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{
	
	@Autowired
	ImportanciaDAO iDao;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return iDao.findAll();
	}



}
