package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;


public interface IProductoService {

	public void insertar(Producto producto);

	public Producto buscar(Integer id);

	public void actualizar(Producto producto);

	public void borrar(Integer id);

	public Producto buscaPorNombre(String nombre);

	public Producto buscarPorCodigoDeBarra(String codigoDeBarra);
	
	public Producto buscarCriteria(String codBarras, String nombre, String stock);
	
	
	
}
