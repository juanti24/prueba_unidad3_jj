package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public void insertar(Producto producto) {
		this.productoRepo.insertar(producto);

	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscar(id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepo.actualizar(producto);

	}

	@Override
	public void borrar(Integer id) {
		this.productoRepo.borrar(id);

	}

	@Override
	
	public Producto buscaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscaPorNombre(nombre);
	}

	@Override
	
	public Producto buscarPorCodigoDeBarra(String codigoDeBarra) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarPorCodigoDeBarra(codigoDeBarra);
	}

	@Override
	public Producto buscarCriteria(String codBarras, String nombre, String stock) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarCriteria(codBarras, nombre, stock);
	}



}
