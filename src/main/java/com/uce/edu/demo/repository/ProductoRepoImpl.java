package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStock;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	private static Logger LOG = Logger.getLogger(ProductoRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto p) {
		this.entityManager.persist(p);

	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);

	}

	@Override
	public void borrar(Integer id) {
		Producto p = this.buscar(id);
		this.entityManager.remove(p);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Producto> myQuery = this.entityManager
					.createQuery("SELECT c FROM Producto c WHERE c.nombre =:nombre", Producto.class);
			myQuery.setParameter("nombre", nombre);
			return myQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("No se ecnontro el producto");
		}
		return null;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoDeBarra(String codigoDeBarra) {
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT c FROM Producto c WHERE c.codigoBarras =:valor", Producto.class);
		myQuery.setParameter("valor", codigoDeBarra);
		return myQuery.getSingleResult();
	}

	@Override
	public ProductoStock buscarPorCodigoDeBarraSencillo(String codigoDeBarra) {
		TypedQuery<ProductoStock> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.ProductoStock(p.codigoBarras, p.nombre, p.categoria, p.stock) FROM Producto p WHERE p.codigoBarras = :datoCodigo",
				ProductoStock.class);
		myQuery.setParameter("datoCodigo", codigoDeBarra);
		return myQuery.getSingleResult();
	}

	@Override
	public Producto buscarCriteria(String codBarras, String nombre, String stock) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Producto> myQuery = myBuilder.createQuery(Producto.class);

		Root<Producto> myTabla = myQuery.from(Producto.class);

		Predicate predCogidoBarras = myBuilder.equal(myTabla.get("codigoBarras"), codBarras);
		Predicate predNombre = myBuilder.equal(myTabla.get("nombre"), nombre);
		Predicate predStock = myBuilder.equal(myTabla.get("stock"), stock);

		Predicate miPredFinal = myBuilder.and(predCogidoBarras, predNombre, predStock);

		CriteriaQuery<Producto> myQueryCompleto = myQuery.select(myTabla).where(miPredFinal);

		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQueryCompleto);

		return myQueryFinal.getSingleResult();
	}

}
