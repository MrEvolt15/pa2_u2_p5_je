package com.uce.edu;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	//1. Query (JPQL)
	//1.1 TypedQuery
	//1.2NamedQUery

	//2.NativeQUery
	//3.Criteria Api Query

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Queries");
		List<Libro> libros = this.iLibroService.buscarPorFecha(LocalDate.of(2024, 1, 1));
		for (Libro libro : libros) {
			System.out.println(libro);
		}
		System.out.println("Typed Query");
		Libro lib =this.iLibroService.buscarPorTitulo("Python");
		System.out.println(lib);
		List<Libro> lista2 = this.iLibroService.buscarPorFechaTyped(LocalDate.of(2024, 1, 1));
		for (Libro libro : lista2) {
			System.out.println(libro);
		}
		System.out.println("Named Query");
		Libro lib2 = this.iLibroService.buscarPorTituloNamed("Python");
		System.out.println(lib2);
		List<Libro> lista3 = this.iLibroService.buscarPorFechaNamed(LocalDate.of(2024, 1, 1));
		for (Libro libro : lista3) {
			System.out.println(libro);
		}
	}
}
