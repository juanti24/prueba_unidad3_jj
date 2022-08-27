package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaImpl implements IDetalleVentaRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleVenta detalleVenta) {
		this.entityManager.persist(detalleVenta);

	}

	@Override
	public DetalleVenta buscar(Integer id) {
	
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void actaualizar(DetalleVenta detalleVenta) {
		this.entityManager.merge(detalleVenta);

	}

	@Override
	public void borrar(Integer id) {
		DetalleVenta detalleVenta = this.buscar(id);
		this.entityManager.remove(detalleVenta);

	}

}
