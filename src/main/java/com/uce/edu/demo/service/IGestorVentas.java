package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoIngreso;

public interface IGestorVentas {

	public void ingresarProductos(Producto producto, Integer stock);
	
	public void realizarVenta(List<ProductoIngreso> lista, String cedula, String numeroVenta);
	
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad);
}
