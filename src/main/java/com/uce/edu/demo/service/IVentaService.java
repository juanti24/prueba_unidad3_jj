package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaService {
	

	public void insertar(Venta venta);

	public Venta buscar(Integer id);

	public void actualizar(Venta venta);

	public void borrar(Integer id);

	public List<Venta> buscarFecha(LocalDateTime fecha);
	
	public void procesarVenta(List<Producto> Productos, String cedulaClientes, String numeroVenta);

}
