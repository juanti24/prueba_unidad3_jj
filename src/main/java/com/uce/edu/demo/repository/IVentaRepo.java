package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepo {

	public void insertar(Venta venta);

	public Venta buscar(Integer id);

	public void actualizar(Venta venta);

	public void borrar(Integer id);

	public List<Venta> buscarFecha(LocalDateTime fecha);

}
