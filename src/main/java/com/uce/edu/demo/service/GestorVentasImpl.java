package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.IVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoIngreso;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class GestorVentasImpl implements IGestorVentas {

	private static final Logger LOG = Logger.getLogger(GestorVentasImpl.class);

	@Autowired
	private IVentaRepo iVentaRepository;

	@Autowired
	private IProductoRepo iProductoRepository;

	@Autowired
	private IProductoService productoServi;

	@Autowired
	private IVentaService ventaServi;


	@Override
	public void ingresarProductos(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
		Producto insertar = this.productoServi.buscaPorNombre(producto.getNombre());
		if (insertar == null) {
			producto.setStock(stock);
			this.productoServi.insertar(producto);
		} else {
			insertar.setStock(insertar.getStock() + stock);
		this.productoServi.actualizar(producto);
		}
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoIngreso> lista, String cedula, String numeroVenta) {
		// TODO Auto-generated method stub

		Venta v = new Venta();
		v.setCedulaCliente(cedula);
		v.setNumero(numeroVenta);
		v.setFecha(LocalDateTime.now());

		BigDecimal total = BigDecimal.ZERO;

		List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();

		for (ProductoIngreso productoIngreso : lista) {

			Producto p = this.iProductoRepository.buscarPorCodigoDeBarra(productoIngreso.getCodigoBarras());

			if (p.getStock().equals(0)) {

				throw new RuntimeException();
			}
			if (p.getStock() <= productoIngreso.getCantidad()) {
				productoIngreso.setCantidad(p.getStock());
			}
			DetalleVenta dv = new DetalleVenta();
			dv.setProducto(p);
			dv.setPrecioUnitario(p.getPrecio());
			dv.setCantidad(productoIngreso.getCantidad());
			dv.setSubtotal(p.getPrecio().multiply(new BigDecimal(productoIngreso.getCantidad())));

			total = total.add(dv.getSubtotal());
			dv.setVenta(v);
			detalles.add(dv);

			p.setStock(p.getStock() - productoIngreso.getCantidad());
			this.iProductoRepository.actualizar(p);
			;

		}

		v.setDetalles(detalles);
		v.setTotalVenta(total);

		this.iVentaRepository.insertar(v);

	}

	@Override
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad) {

		List<Venta> listaVentas = this.ventaServi.buscarFecha(fechaVenta);
		listaVentas.stream().forEach(v -> {
			LOG.info(v.getDetalles());
		});

	}

}
