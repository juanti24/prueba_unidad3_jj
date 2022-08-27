package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaRepo {

	public void insertar(DetalleVenta detalleVenta);

	public DetalleVenta buscar(Integer id);

	public void actaualizar(DetalleVenta detalleVenta);

	public void borrar(Integer id);

}
