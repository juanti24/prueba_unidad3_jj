package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaService {

	public void insertar(DetalleVenta detalleVenta);

	public DetalleVenta buscar(Integer id);

	public void actaualizar(DetalleVenta detalleVenta);

	public void borrar(Integer id);
}
