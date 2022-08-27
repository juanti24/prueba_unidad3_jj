package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaRepo ventaRepo;

	@Override
	public void insertar(Venta venta) {
		this.ventaRepo.insertar(venta);

	}

	@Override
	public Venta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscar(id);
	}

	@Override
	public void actualizar(Venta venta) {
		this.ventaRepo.actualizar(venta);

	}

	@Override
	public void borrar(Integer id) {
		this.ventaRepo.borrar(id);

	}

	@Override
	public List<Venta> buscarFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarFecha(fecha);
	}

	@Override
	public void procesarVenta(List<Producto> productos, String cedulaClientes, String numeroVenta) {
		BigDecimal totalPagar = BigDecimal.ZERO;
		
		Venta venta = new Venta();
		venta.setCedulaCliente(cedulaClientes);
		venta.setFecha(LocalDateTime.now());	
		venta.setNumero(numeroVenta);
		
		
		List<Producto> listaproductos = new ArrayList<>();
		
		for(Producto cofigo : productos) {
			
			
			
			
		}
		
		
	}

}
