package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private IDetalleVentaRepo detalleVentaRepo;
	
	@Override
	public void insertar(DetalleVenta detalleVenta) {
		this.detalleVentaRepo.insertar(detalleVenta);
		
	}

	@Override
	public DetalleVenta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleVentaRepo.buscar(id);
	}

	@Override
	public void actaualizar(DetalleVenta detalleVenta) {
		this.detalleVentaRepo.actaualizar(detalleVenta);
		
	}

	@Override
	public void borrar(Integer id) {
		this.detalleVentaRepo.borrar(id);
		
	}

	
}
