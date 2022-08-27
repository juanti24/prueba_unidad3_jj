package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStock;

public interface IProductoRepo {

	public void insertar(Producto producto);

	public Producto buscar(Integer id);

	public void actualizar(Producto producto);

	public void borrar(Integer id);

	public Producto buscaPorNombre(String nombre);

	public Producto buscarPorCodigoDeBarra(String codigoDeBarra);
	
	public ProductoStock buscarPorCodigoDeBarraSencillo(String codigoDeBarra);
	
	public Producto buscarCriteria(String codBarras, String nombre, String stock);
	
}
