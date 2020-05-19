package com.ejercicio.parcial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ejercicio.parcial.dao.ContribuyenteDAO;
import com.ejercicio.parcial.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

	@Autowired
	ContribuyenteDAO cDao;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return cDao.findAll();
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		cDao.insert(contribuyente);
	}

}
