package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Libro l1 = new Libro();
		l1.setTitulo("Java");
		l1.setFechaPublicacion(LocalDate.now());
		
		Autor a1 = new Autor();
		a1.setNombre("Joel");
		a1.setNacional("Ecuador");
		Autor a2 = new Autor();
		a2.setNacional("Argentina");
		a2.setNombre("Julio");

		Set<Autor> autores = new HashSet<>();
		autores.add(a1);
		autores.add(a2);

		Set<Libro> libros = new HashSet<>();
		libros.add(l1);

		l1.setAutores(autores);
		a2.setLibros(libros);
		a1.setLibros(libros);

		this.iLibroService.guardar(l1);
	}

}
