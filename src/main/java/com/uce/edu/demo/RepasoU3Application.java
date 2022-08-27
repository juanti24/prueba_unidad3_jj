package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoIngreso;
import com.uce.edu.demo.service.IGestorVentas;

@SpringBootApplication
public class RepasoU3Application implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(RepasoU3Application.class);

	@Autowired
	private IGestorVentas gestorVentas;

	public static void main(String[] args) {
		SpringApplication.run(RepasoU3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setCodigoBarras("12345");
		p1.setNombre("CocaCola");
		p1.setCategoria("Bevidas");
		p1.setPrecio(new BigDecimal("1.5"));

		//Comento para que no se inserten de nuevo en la base
		
		//this.gestorVentas.ingresarProductos(p1, 50);
		//this.gestorVentas.ingresarProductos(p1, 50);


		ProductoIngreso p2 = new ProductoIngreso();
		p2.setCantidad(1);
		p2.setCodigoBarras("1110011");
		
		ProductoIngreso p3 = new ProductoIngreso();
		p3.setCantidad(20);
		p3.setCodigoBarras("1100011");
		
		
		List<ProductoIngreso> lista = new ArrayList<ProductoIngreso>();
		lista.add(p2);
		lista.add(p3);
		
		this.gestorVentas.realizarVenta(lista, "1723920979", "004");
	

	}

}
