package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Venta venta) {
		this.entityManager.persist(venta);

	}

	@Override
	public Venta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Venta.class, id);
	}

	@Override
	public void actualizar(Venta venta) {
		this.entityManager.merge(venta);

	}

	@Override
	public void borrar(Integer id) {
		Venta venta = this.buscar(id);
		this.entityManager.remove(venta);

	}

	@Override
	public List<Venta> buscarFecha(LocalDateTime fecha) {
		TypedQuery<Venta> miTypedQuery = this.entityManager.createQuery("SELECT v FROM Venta v WHERE v.fecha = :datoFecha", Venta.class);
		miTypedQuery.setParameter("datoFecha", fecha);
		return miTypedQuery.getResultList();
	}

}
